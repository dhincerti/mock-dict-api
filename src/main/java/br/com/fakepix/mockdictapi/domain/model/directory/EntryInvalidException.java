package br.com.fakepix.mockdictapi.domain.model.directory;

import br.com.fakepix.mockdictapi.api.ResponseException;
import br.com.fakepix.mockdictapi.domain.model.problems.Violation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.http.HttpStatus;

@JacksonXmlRootElement
public class EntryInvalidException extends ResponseException {
  public static final String TYPE = "https://dict.pi.rsfn.net.br/api/v1/error/EntryInvalid";
  public static final String TITLE = "Entry is invalid";
  public static final Integer STATUS = HttpStatus.BAD_REQUEST.value();
  public static final String DETAIL = "Entry has invalid fields";
  
  public EntryInvalidException(String reason, String value, String property) {
    super(TYPE, TITLE, STATUS, DETAIL);
    Violation violation = new Violation();
    violation.setReason(reason);
    violation.setProperty(property);
    violation.setValue(value);
    problem.addViolation(violation);
  }
}
