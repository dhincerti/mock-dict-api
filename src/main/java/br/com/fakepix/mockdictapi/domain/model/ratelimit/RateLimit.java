package br.com.fakepix.mockdictapi.domain.model.ratelimit;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ratelimit")
public class RateLimit implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  @Column
  private Long id;
  
  @Column
  private String payerAccountServicer;
  
  @Column
  private String payerId;
  
  @Column
  private String e2eID;
  
  @Column
  private Long date = 0l;
  
  public String getPayerAccountServicer() {
    return payerAccountServicer;
  }
  
  public void setPayerAccountServicer(String payerAccountServicer) {
    this.payerAccountServicer = payerAccountServicer;
  }
  
  public String getPayerId() {
    return payerId;
  }
  
  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }
  
  public String getE2eID() {
    return e2eID;
  }
  
  public void setE2eID(String e2eID) {
    this.e2eID = e2eID;
  }
  
  public Long getDate() {
    return date;
  }
  
  public void setDate(Long date) {
    this.date = date;
  }
}
