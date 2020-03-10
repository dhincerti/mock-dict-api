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
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long id;
  
  @JacksonXmlProperty(localName = "Participant")
  private String participant;
  
  @JacksonXmlProperty(localName = "Branch")
  private String branch;
  
  @JacksonXmlProperty(localName = "AccountType")
  private String accountType;
  
  @JacksonXmlProperty(localName = "AccountNumber")
  private String accountNumber;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getParticipant() {
    return participant;
  }
  
  public void setParticipant(String participant) {
    this.participant = participant;
  }
  
  public String getBranch() {
    return branch;
  }
  
  public void setBranch(String branch) {
    this.branch = branch;
  }
  
  public String getAccountType() {
    return accountType;
  }
  
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }
  
  public String getAccountNumber() {
    return accountNumber;
  }
  
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
  
  @Override
  public String toString() {
    return "ClassPojo [Participant = " + participant + ", Branch = " + branch + ", AccountType = " + accountType + ", AccountNumber = " + accountNumber + "]";
  }
}