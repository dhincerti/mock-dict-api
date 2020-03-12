package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CreateEntryResponse extends EntryPayload {
  public CreateEntryResponse(String signature, Entry entry) {
    super(signature, entry);
  }
}