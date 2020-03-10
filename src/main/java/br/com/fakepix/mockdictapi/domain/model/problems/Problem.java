package br.com.fakepix.mockdictapi.domain.model.problems;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement
public class Problem {
  @JacksonXmlProperty
  private String xmlns;
  
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Violation> violations;
  
  @JacksonXmlProperty
  private String detail;
  
  @JacksonXmlProperty
  private String type;
  
  @JacksonXmlProperty
  private String title;
  
  @JacksonXmlProperty
  private String status;
  
  public String getXmlns() {
    return xmlns;
  }
  
  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }
  
  public List<Violation> getViolations() {
    return violations;
  }
  
  public void setViolations(List<Violation> violations) {
    this.violations = violations;
  }
  
  public String getDetail() {
    return detail;
  }
  
  public void setDetail(String detail) {
    this.detail = detail;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [xmlns = " + xmlns + ", violations = " + violations + ", detail = " + detail + ", type = " + type + ", title = " + title + ", status = " + status + "]";
  }
}