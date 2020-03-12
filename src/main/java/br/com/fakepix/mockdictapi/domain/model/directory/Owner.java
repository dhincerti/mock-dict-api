package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JacksonXmlRootElement
public class Owner implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  @Column
  private Long id;
  
  @JacksonXmlProperty(localName = "Type")
  @Column
  private String type;
  
  @JacksonXmlProperty(localName = "TaxIdNumber")
  @Column
  private String taxIdNumber;
  
  @JacksonXmlProperty(localName = "Name")
  @Column
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