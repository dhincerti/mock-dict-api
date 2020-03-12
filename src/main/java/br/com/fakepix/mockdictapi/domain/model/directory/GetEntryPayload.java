package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class GetEntryPayload extends EntryPayload {
  
  public GetEntryPayload(Entry entry) {
    super(entry);
  }
}
