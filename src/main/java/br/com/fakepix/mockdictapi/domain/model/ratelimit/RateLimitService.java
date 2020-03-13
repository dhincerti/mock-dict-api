package br.com.fakepix.mockdictapi.domain.model.ratelimit;

import br.com.fakepix.mockdictapi.api.ResponseHeaders;
import br.com.fakepix.mockdictapi.domain.model.directory.RateLimitedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RateLimitService {
  private RateLimitProperties rateLimitProperties;
  private RateLimitRepository rateLimitRepository;
  
  @Autowired
  public RateLimitService(RateLimitRepository rateLimitRepository, RateLimitProperties rateLimitProperties) {
    this.rateLimitRepository = rateLimitRepository;
    this.rateLimitProperties = rateLimitProperties;
  }
  
  public HttpHeaders getRateLimitsAsHeaders(String payerAccountServicer, String payerId, String e2eID) throws RateLimitedException {
    long nowDate = Instant.now().toEpochMilli();
  
    List<RateLimit> clientRequests = getClientRequests(nowDate, payerId);
    List<RateLimit> participantRequests = getParticipantRequests(nowDate, payerAccountServicer);
  
    if (limitRateHasBeenExceeded(clientRequests, participantRequests)) {
      throw new RateLimitedException();
    }
  
    createRequestRegistry(payerAccountServicer, payerId, e2eID);
  
    return getHttpRateLimitHeaders(clientRequests, participantRequests, nowDate);
  }
  
  private HttpHeaders getHttpRateLimitHeaders(List<RateLimit> clientRequests, List<RateLimit> participantRequests,
                                              long nowDate) {
    int rateLimitClientRemaining = rateLimitProperties.getClientLimit() - clientRequests.size();
    long rateLimitClientReset =
        clientRequests.size() > 0 ?
            (clientRequests.stream()
            .min(Comparator.comparing(RateLimit::getDate))
            .orElse(new RateLimit()).getDate()
            + TimeUnit.SECONDS.toMillis(rateLimitProperties.getClientReset()))
            - nowDate
        : 0;
  
    int rateLimitParticipantRemaining = rateLimitProperties.getParticipantLimit() - participantRequests.size();
    long rateLimitParticipantReset =
        clientRequests.size() > 0 ?
            (participantRequests.stream()
            .min(Comparator.comparing(RateLimit::getDate))
            .orElse(new RateLimit()).getDate()
            + TimeUnit.SECONDS.toMillis(rateLimitProperties.getParticipantReset()))
            - nowDate
        : 0;
    
    HttpHeaders headers = new HttpHeaders();
    headers.set(ResponseHeaders.PI_RATE_LIMIT_CLIENT_REMAINING, Integer.toString(rateLimitClientRemaining));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_CLIENT_RESET, Long.toString(TimeUnit.MILLISECONDS.toSeconds(rateLimitClientReset)));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_REMAINING, Integer.toString(rateLimitParticipantRemaining));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_RESET, Long.toString(TimeUnit.MILLISECONDS.toSeconds(rateLimitParticipantReset)));
    return headers;
  }
  
  private List<RateLimit> getParticipantRequests(long nowDate, String payerAccountServicer) {
    long participantRateLimitDate = nowDate - TimeUnit.SECONDS.toMillis(rateLimitProperties.getClientReset());
    return rateLimitRepository.findAllByPayerAccountServicerAndDateGreaterThanEqual(payerAccountServicer, participantRateLimitDate);
  }
  
  private List<RateLimit> getClientRequests(long nowDate, String payerId) {
    long clientRateLimitDate = nowDate - TimeUnit.SECONDS.toMillis(rateLimitProperties.getClientReset());
    return rateLimitRepository.findAllByPayerIdAndDateGreaterThanEqual(payerId, clientRateLimitDate);
  }
  
  private boolean limitRateHasBeenExceeded(List<RateLimit> payerRequests, List<RateLimit> payerAccountServicerRequests) {
    return payerRequests.size() > rateLimitProperties.getClientLimit()
        || payerAccountServicerRequests.size() > rateLimitProperties.getParticipantLimit();
  }
  
  private void createRequestRegistry(String payerAccountServicer, String payerId, String e2eID) {
    RateLimit rateLimit = new RateLimit();
    rateLimit.setPayerId(payerId);
    rateLimit.setPayerAccountServicer(payerAccountServicer);
    rateLimit.setE2eID(e2eID);
    rateLimit.setDate(Instant.now().toEpochMilli());
    rateLimitRepository.save(rateLimit);
  }
}
