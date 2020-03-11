package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.DirectoryService;
import br.com.fakepix.mockdictapi.domain.model.directory.EntryInvalidException;
import br.com.fakepix.mockdictapi.domain.model.directory.ParticipantForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntriesController {
  
  private DirectoryService directoryService;
  
  @Autowired
  public EntriesController(DirectoryService directoryService) {
    this.directoryService = directoryService;
  }
  
  @RequestMapping(path = "entries", method = RequestMethod.POST, consumes = "application/xml", produces = "application/xml")
  @ResponseStatus(code = HttpStatus.CREATED)
  public HttpEntity createEntry(@RequestBody CreateEntryRequest request) {
    try {
      return new ResponseEntity(directoryService.create(request), HttpStatus.CREATED);
    } catch (ResponseException e) {
      return new ResponseEntity(e.getProblem(), HttpStatus.resolve(e.getProblem().getStatus()));
    }
  }
}
