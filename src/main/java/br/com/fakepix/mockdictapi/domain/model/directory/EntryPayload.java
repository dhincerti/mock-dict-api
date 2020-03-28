package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EntryPayload {
  @JacksonXmlProperty(localName = "Entry")
  private Entry entry;
  
  @JacksonXmlProperty(localName = "Signature")
  private String signature;
  
  public EntryPayload(String signature, Entry entry) {
    if (entry != null) {
      entry.setCreationDate(today());
      entry.setKeyOwnershipDate(today());
    }
    
    this.signature = signature;
    this.entry = entry;
  }
  
  private String today() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
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
