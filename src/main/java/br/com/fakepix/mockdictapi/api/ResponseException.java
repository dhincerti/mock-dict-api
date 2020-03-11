package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.problems.Problem;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class ResponseException extends Exception {
  
  @JacksonXmlProperty(localName = "problem")
  protected Problem problem;
  
  public ResponseException(String type, String title, Integer status, String detail) {
    problem = new Problem();
    problem.setType(type);
    problem.setTitle(title);
    problem.setStatus(status);
    problem.setDetail(detail);
  }
  
  public Problem getProblem() {
    return problem;
  }
}
