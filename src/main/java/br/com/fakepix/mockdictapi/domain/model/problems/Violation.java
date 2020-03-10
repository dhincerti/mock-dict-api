package br.com.fakepix.mockdictapi.domain.model.problems;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Violation {
  @JacksonXmlProperty
  private String reason;
  
  @JacksonXmlProperty
  private String property;
  
  @JacksonXmlProperty
  private String value;
  
  public String getReason() {
    return reason;
  }
  
  public void setReason(String reason) {
    this.reason = reason;
  }
  
  public String getProperty() {
    return property;
  }
  
  public void setProperty(String property) {
    this.property = property;
  }
  
  public String getValue() {
    return value;
  }
  
  public void setValue(String value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [reason = " + reason + ", property = " + property + ", value = " + value + "]";
  }
}
