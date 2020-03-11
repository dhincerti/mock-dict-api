package br.com.fakepix.mockdictapi.domain.model.problems;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "problem")
public class Problem {
  
  @JacksonXmlProperty(isAttribute = true)
  private String xmlns = "urn:ietf:rfc:7807";
  
  @JacksonXmlProperty
  private String type;
  
  @JacksonXmlProperty
  private String title;
  
  @JacksonXmlProperty
  private Integer status;
  
  @JacksonXmlProperty
  private String detail;
  
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Violation> violations = new ArrayList<>();
  
  public String getXmlns() {
    return xmlns;
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
  
  public Integer getStatus() {
    return status;
  }
  
  public void setStatus(Integer status) {
    this.status = status;
  }
  
  public List<Violation> getViolations() {
    return violations;
  }
  
  public void addViolation(Violation violation) {
    violations.add(violation);
  }
  
  @Override
  public String toString() {
    return "ClassPojo [xmlns = " + xmlns + ", violations = " + violations + ", detail = " + detail + ", type = " + type + ", title = " + title + ", status = " + status + "]";
  }
}