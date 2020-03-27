package br.com.fakepix.mockdictapi.domain.model.directory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "entry")
@JacksonXmlRootElement
public class Entry implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  @Column
  private Long id;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JacksonXmlProperty(localName = "Account")
  @NotNull
  private Account account;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JacksonXmlProperty(localName = "Owner")
  @NotNull
  private Owner owner;
  
  @JacksonXmlProperty(localName = "KeyType")
  @NotEmpty
  @Column
  private String keyType;
  
  @JacksonXmlProperty(localName = "Key")
  @NotEmpty
  @Column(name = "key", unique = true)
  private String key;
  
  @JacksonXmlProperty(localName = "CreationDate")
  private String creationDate = today();
  
  @JacksonXmlProperty(localName = "KeyOwnershipDate")
  private String keyOwnershipDate = today();
  
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Account getAccount() {
    return account;
  }
  
  public void setAccount(Account account) {
    this.account = account;
  }
  
  public Owner getOwner() {
    return owner;
  }
  
  public void setOwner(Owner owner) {
    this.owner = owner;
  }
  
  public String getKeyType() {
    return keyType;
  }
  
  public void setKeyType(String keyType) {
    this.keyType = keyType;
  }
  
  public String getKey() {
    return key;
  }
  
  public void setKey(String key) {
    this.key = key;
  }
  
  public String getCreationDate() {
    return creationDate;
  }
  
  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }
  
  public String getKeyOwnershipDate() {
    return keyOwnershipDate;
  }
  
  public void setKeyOwnershipDate(String keyOwnershipDate) {
    this.keyOwnershipDate = keyOwnershipDate;
  }
  
  private String today() {
    return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
  }
}