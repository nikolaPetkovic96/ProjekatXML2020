package com.team32.AgentApp.soap.dto.adresa;

import javax.xml.bind.annotation.XmlElement;

public class AdresaSuccessResponse {

  @XmlElement(name = "adresaId")
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
