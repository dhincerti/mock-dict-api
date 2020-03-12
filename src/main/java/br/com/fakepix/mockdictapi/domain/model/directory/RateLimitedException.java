package br.com.fakepix.mockdictapi.domain.model.directory;

import br.com.fakepix.mockdictapi.api.ResponseException;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.http.HttpStatus;

@JacksonXmlRootElement
public class RateLimitedException extends ResponseException {
  public static final String TYPE = "https://dict.pi.rsfn.net.br/api/v1/error/RateLimited";
  public static final String TITLE = "Rate limited";
  public static final Integer STATUS = HttpStatus.TOO_MANY_REQUESTS.value();
  
  public RateLimitedException() {
    super(TYPE, TITLE, STATUS);
  }
}
