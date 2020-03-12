package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EntryPayload {
  @JacksonXmlProperty(localName = "Entry")
  private Entry entry;
  
  @JacksonXmlProperty(localName = "Signature")
  private String signature;
  
  public EntryPayload(Entry entry) {
    this.entry = entry;
  }
  
  public EntryPayload(String signature, Entry entry) {
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
