package br.com.fakepix.mockdictapi.client;

import br.com.fakepix.mockdictapi.domain.model.directory.CreateEntryRequest;
import br.com.fakepix.mockdictapi.domain.model.directory.GetEntryPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "DICTClient", url = "http://localhost:9000/api/v1")
public interface DICTClient {
  
  String ENTRIES = "/entries";
  
  @RequestMapping(method = RequestMethod.GET, value = ENTRIES + "/{key}", produces = MediaType.APPLICATION_XML_VALUE,
      consumes = MediaType.APPLICATION_XML_VALUE)
  ResponseEntity<GetEntryPayload> retrieveEntry(@PathVariable("key") String key,
                                                @RequestHeader("PI-PayerAccountServicer") String payerAccountServicer,
                                                @RequestHeader("PI-PayerId") String payerId,
                                                @RequestHeader("PI-EndToEndId") String e2e);
  
  @RequestMapping(path = ENTRIES, method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  ResponseEntity<CreateEntryRequest> createEntry(@RequestBody CreateEntryRequest request);
}
