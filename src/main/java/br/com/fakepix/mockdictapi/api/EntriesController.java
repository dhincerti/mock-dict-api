package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.CreateEntryRequest;
import br.com.fakepix.mockdictapi.domain.model.directory.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntriesController {
  
  public static final String ENTRIES = "entries";
  public static final String PI_PAYER_ACCOUNT_SERVICER = "PI-PayerAccountServicer";
  public static final String PI_PAYER_ID = "PI-PayerId";
  public static final String PI_END_TO_END_ID = "PI-EndToEndId";
  private DirectoryService directoryService;
  
  @Autowired
  public EntriesController(DirectoryService directoryService) {
    this.directoryService = directoryService;
  }
  
  @RequestMapping(path = ENTRIES, method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseStatus(code = HttpStatus.CREATED)
  public HttpEntity createEntry(@RequestBody CreateEntryRequest request) {
    try {
      return new ResponseEntity(directoryService.create(request), HttpStatus.CREATED);
    } catch (ResponseException e) {
      return new ResponseEntity(e.getProblem(), HttpStatus.resolve(e.getProblem().getStatus()));
    }
  }
  
  @RequestMapping(path = ENTRIES + "/{key}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity retrieveEntry(@RequestHeader(name = PI_PAYER_ACCOUNT_SERVICER) String payerAccount,
                                             @RequestHeader(name = PI_PAYER_ID) String payerId,
                                             @RequestHeader(name = PI_END_TO_END_ID) String e2eID,
                                             @PathVariable(name = "key") String key) {
    return new ResponseEntity(directoryService.retrieveEntry(key), HttpStatus.OK);
  }
}
