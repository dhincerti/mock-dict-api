package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.CreateEntryRequest;
import br.com.fakepix.mockdictapi.domain.model.directory.DeleteEntryRequest;
import br.com.fakepix.mockdictapi.domain.model.directory.DirectoryService;
import br.com.fakepix.mockdictapi.domain.model.ratelimit.RateLimitProperties;
import br.com.fakepix.mockdictapi.domain.model.ratelimit.RateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EntriesController {
  
  public static final String ENTRIES = "entries";
  
  private RateLimitProperties rateLimitProperties;
  private RateLimitService rateLimitService;
  private DirectoryService directoryService;
  
  @Autowired
  public EntriesController(RateLimitProperties rateLimitProperties, RateLimitService rateLimitService,
                           DirectoryService directoryService) {
    this.rateLimitProperties = rateLimitProperties;
    this.rateLimitService = rateLimitService;
    this.directoryService = directoryService;
  }
  
  @RequestMapping(path = ENTRIES, method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseStatus(code = HttpStatus.CREATED)
  public HttpEntity<Object> createEntry(@RequestBody CreateEntryRequest request) {
    try {
      return new ResponseEntity<>(directoryService.create(request), HttpStatus.CREATED);
    } catch (ResponseException e) {
      return new ResponseEntity<>(e.getProblem(), HttpStatus.resolve(e.getProblem().getStatus()));
    }
  }
  
  @RequestMapping(path = ENTRIES + "/{key}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<Object> retrieveEntry(@RequestHeader(name = RequestHeaders.PI_PAYER_ACCOUNT_SERVICER) String payerAccount,
                                              @RequestHeader(name = RequestHeaders.PI_PAYER_ID) String payerId,
                                              @RequestHeader(name = RequestHeaders.PI_END_TO_END_ID) String e2eID,
                                              @PathVariable(name = "key") String key) {
    
    try {
      HttpHeaders headers = rateLimitService.getRateLimitsAsHeaders(payerAccount, payerId, e2eID);
      return ResponseEntity.ok()
          .headers(headers)
          .body(directoryService.retrieveEntry(key));
    } catch (ResponseException e) {
      return new ResponseEntity<>(e.getProblem(), HttpStatus.valueOf(e.getProblem().getStatus()));
    }
  }
  
  @RequestMapping(path = ENTRIES + "/{key}/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public HttpEntity deleteEntry(@RequestBody DeleteEntryRequest request) {
    
    try {
      directoryService.deleteEntry(request);
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    } catch (ResponseException e) {
      return new ResponseEntity(e.getProblem(), HttpStatus.resolve(e.getProblem().getStatus()));
    }
    
  }
  
  private HttpHeaders setHttpHeaders(Map<String, String> rateLimits) {
    HttpHeaders headers = new HttpHeaders();
    headers.set(ResponseHeaders.PI_RATE_LIMIT_CLIENT_REMAINING, rateLimits.get(ResponseHeaders.PI_RATE_LIMIT_CLIENT_REMAINING));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_CLIENT_RESET, rateLimits.get(ResponseHeaders.PI_RATE_LIMIT_CLIENT_RESET));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_REMAINING, rateLimits.get(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_REMAINING));
    headers.set(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_RESET, rateLimits.get(ResponseHeaders.PI_RATE_LIMIT_PARTICIPANT_RESET));
    return headers;
  }
}
