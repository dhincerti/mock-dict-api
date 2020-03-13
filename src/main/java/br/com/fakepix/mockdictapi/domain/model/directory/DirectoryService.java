package br.com.fakepix.mockdictapi.domain.model.directory;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DirectoryService {
  private EntryRepository entryRepository;
  
  @Autowired
  public DirectoryService(EntryRepository entryRepository) {
    this.entryRepository = entryRepository;
  }
  
  public CreateEntryResponse create(CreateEntryRequest request) throws EntryInvalidException, ParticipantForbiddenException {
    validateCreateEntryRequest(request);
    
    Entry savedEntry = entryRepository.save(request.getEntry());
    
    return new CreateEntryResponse(request.getSignature(), savedEntry);
  }
  
  public void validateCreateEntryRequest(CreateEntryRequest request) throws EntryInvalidException, ParticipantForbiddenException {
    checkIfParticipantIsAllowed(request);
    checkIfIsValidKeyType(request);
  }
  
  private void checkIfParticipantIsAllowed(CreateEntryRequest request) throws ParticipantForbiddenException {
    if (request.getSignature().isEmpty()) {
      throw new ParticipantForbiddenException();
    }
  }
  
  private boolean checkIfIsValidKeyType(CreateEntryRequest request) throws EntryInvalidException {
    if (EnumUtils.isValidEnum(KeyType.class, request.getEntry().getKeyType())) {
      return true;
    }
    
    throw new EntryInvalidException("Invalid KeyType", request.getEntry().getKeyType(), "entry.keyType");
  }
  
  public GetEntryPayload retrieveEntry(String key) throws EntryNotFoundException {
    Entry byKey = entryRepository.findByKey(key);
    if (byKey == null) {
      throw new EntryNotFoundException();
    }
    
    return new GetEntryPayload(byKey);
  }

  @Transactional
  public void deleteEntry(DeleteEntryRequest request) throws EntryNotFoundException, ParticipantForbiddenException {
    if (request.getSignature().isEmpty()) {
      throw new ParticipantForbiddenException();
    }
    Entry deleteKey = entryRepository.findByKey(request.getKey());
     if(deleteKey == null){
       throw new EntryNotFoundException();
     }
     entryRepository.deleteByKey(request.getKey());

    }

  }

