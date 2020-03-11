package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.Entry;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CreateEntryRequest {
  @JacksonXmlProperty(localName = "Signature")
  private String signature;
  
  @JacksonXmlProperty(localName = "Entry")
  private Entry entry;
  
  public String getSignature() {
    return signature;
  }
  
  public void setSignature(String signature) {
    this.signature = signature;
  }
  
  public void setEntry(Entry entry) {
    this.entry = entry;
  }
  
  public Entry getEntry() {
    return entry;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [Entry = " + entry + ", Signature = " + signature + "]";
  }
  
}
