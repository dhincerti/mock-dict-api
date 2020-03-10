package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class EntriesController {
  
  private DirectoryService directoryService;
  
  @Autowired
  public EntriesController (DirectoryService directoryService){
    this.directoryService = directoryService;
  }
  
  @RequestMapping(path = "entries", method = RequestMethod.POST, consumes = {"application/xml", "application/json"}, produces = {"application/xml", "application/json"})
  public CreateEntryResponse createEntry(@Valid @NotNull @RequestBody CreateEntryRequest request) {
    return directoryService.create(request);
  }
}
