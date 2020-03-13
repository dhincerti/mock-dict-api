package br.com.fakepix.mockdictapi.domain.model.directory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
  
  Entry findByKey(String key);
  void deleteByKey(String key);
}
