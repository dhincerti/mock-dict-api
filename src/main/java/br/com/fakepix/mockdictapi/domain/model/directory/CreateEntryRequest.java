package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CreateEntryRequest extends EntryPayload {
  
  
  public CreateEntryRequest(String signature, Entry entry) {
    super(signature, entry);
  }
}
