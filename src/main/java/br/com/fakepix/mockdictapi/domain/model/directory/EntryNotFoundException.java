package br.com.fakepix.mockdictapi.domain.model.directory;

import br.com.fakepix.mockdictapi.api.ResponseException;
import br.com.fakepix.mockdictapi.domain.model.problems.Violation;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.http.HttpStatus;

@JacksonXmlRootElement
public class EntryNotFoundException extends ResponseException {
  public static final String TYPE = "https://dict.pi.rsfn.net.br/api/v1/error/NotFound";
  public static final String TITLE = "Not found";
  public static final Integer STATUS = HttpStatus.NOT_FOUND.value();
  public static final String DETAIL = "Entry associated with given key does not exist";
  
  public EntryNotFoundException() {
    super(TYPE, TITLE, STATUS, DETAIL);
  }
}
