package br.com.fakepix.mockdictapi.api;

import br.com.fakepix.mockdictapi.domain.model.directory.Entry;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CreateEntryResponse {
  @JacksonXmlProperty(localName = "Entry")
  private Entry entry;
  
  @JacksonXmlProperty(localName = "Signature")
  private String signature;
  
  public CreateEntryResponse(String signature, Entry entry) {
    this.signature = signature;
    this.entry = entry;
  }
  
  public Entry getEntry() {
    return entry;
  }
  
  public void setEntry(Entry Entry) {
    this.entry = Entry;
  }
  
  public String getSignature() {
    return signature;
  }
  
  public void setSignature(String Signature) {
    this.signature = Signature;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [Entry = " + entry + ", Signature = " + signature + "]";
  }
}