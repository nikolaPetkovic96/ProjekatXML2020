package com.team32.AgentApp.soap.dto.adresa;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdresaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
  "adresaId",
  "successful"
})

@XmlRootElement(name = "AdresaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class AdresaSuccessResponse {

  @XmlElement(name = "AdresaId")
  protected Long adresaId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the adresaId property.
   * 
   */
  public Long getAdresaId() {
      return adresaId;
  }

  /**
   * Sets the value of the adresaId property.
   * 
   */
  public void setAdresaId(Long value) {
      this.adresaId = value;
  }

  /**
   * Gets the value of the successful property.
   * 
   */
  public boolean isSuccessful() {
      return successful;
  }

  /**
   * Sets the value of the successful property.
   * 
   */
  public void setSuccessful(boolean value) {
      this.successful = value;
  }
}
