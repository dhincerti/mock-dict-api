package br.com.fakepix.mockdictapi.domain.model.ratelimit;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConfigurationProperties("rate-limit")
public class RateLimitProperties {
  private Integer clientLimit;
  private Integer clientReset;
  private Integer participantLimit;
  private Integer participantReset;
  
  public Integer getClientLimit() {
    return clientLimit;
  }
  
  public void setClientLimit(Integer clientLimit) {
    this.clientLimit = clientLimit;
  }
  
  public Integer getClientReset() {
    return clientReset;
  }
  
  public void setClientReset(Integer clientReset) {
    this.clientReset = clientReset;
  }
  
  public Integer getParticipantLimit() {
    return participantLimit;
  }
  
  public void setParticipantLimit(Integer participantLimit) {
    this.participantLimit = participantLimit;
  }
  
  public Integer getParticipantReset() {
    return participantReset;
  }
  
  public void setParticipantReset(Integer participantReset) {
    this.participantReset = participantReset;
  }
}
