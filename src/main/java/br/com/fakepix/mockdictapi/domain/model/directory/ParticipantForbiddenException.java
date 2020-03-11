package br.com.fakepix.mockdictapi.domain.model.directory;

import br.com.fakepix.mockdictapi.api.ResponseException;
import org.springframework.http.HttpStatus;

public class ParticipantForbiddenException extends ResponseException {
  
  public static final String TYPE = "https://dict.pi.rsfn.net.br/api/v1/error/Forbidden";
  public static final String TITLE = "Forbidden";
  public static final Integer STATUS = HttpStatus.FORBIDDEN.value();
  public static final String DETAIL = "Participant is not allowed to access this resource";
  
  public ParticipantForbiddenException() {
    super(TYPE, TITLE, STATUS, DETAIL);
  }
}
