package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JacksonXmlRootElement
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  
  @JacksonXmlProperty(localName = "Type")
  private String type;
  
  @JacksonXmlProperty(localName = "TaxIdNumber")
  private String taxIdNumber;
  
  @JacksonXmlProperty(localName = "Name")
  private String name;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getTaxIdNumber() {
    return taxIdNumber;
  }
  
  public void setTaxIdNumber(String taxIdNumber) {
    this.taxIdNumber = taxIdNumber;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [Type = " + type + ", TaxIdNumber = " + taxIdNumber + ", Name = " + name + "]";
  }
}