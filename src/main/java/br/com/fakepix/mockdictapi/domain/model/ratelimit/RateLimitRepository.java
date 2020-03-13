package br.com.fakepix.mockdictapi.domain.model.ratelimit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateLimitRepository extends CrudRepository<RateLimit, String> {
  
  List<RateLimit> findAllByPayerAccountServicerAndDateGreaterThanEqual(String payerAccountServicer, Long date);
  
  List<RateLimit> findAllByPayerIdAndDateGreaterThanEqual(String payerId, Long nowDate);
}
