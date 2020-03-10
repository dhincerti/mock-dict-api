package br.com.fakepix.mockdictapi.domain.model.directory;

import br.com.fakepix.mockdictapi.api.CreateEntryRequest;
import br.com.fakepix.mockdictapi.api.CreateEntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryService {
  private EntryRepository entryRepository;
  
  @Autowired
  public DirectoryService(EntryRepository entryRepository) {
    this.entryRepository = entryRepository;
  }
  
  public CreateEntryResponse create(CreateEntryRequest request) {
    Entry savedEntry = entryRepository.save(request.getEntry());
    
    return new CreateEntryResponse(request.getSignature(), savedEntry);
  }
}
