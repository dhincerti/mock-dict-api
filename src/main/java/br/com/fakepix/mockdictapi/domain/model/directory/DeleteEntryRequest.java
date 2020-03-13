package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class DeleteEntryRequest  {

  @JacksonXmlProperty(localName = "Signature")
  private String signature;

  @JacksonXmlProperty(localName = "Key")
  private String key;

  public DeleteEntryRequest(String signature, String key){
        this.key  = key;
        this.signature = signature;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String Signature) {
    this.signature = Signature;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "ClassPojo [Signature = " + signature + "Key = " + key + "]";
  }
}
