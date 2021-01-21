package com.team32.AgentApp.soap.dto.narudzbenica;

import javax.xml.bind.annotation.XmlElement;

public class NarudzbenicaSuccessResponse {

  @XmlElement(name = "narudzbenicaId")
  protected Long narudzbenicaId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the narudzbenicaId property.
   * 
   */
  public Long getNarudzbenicaId() {
      return narudzbenicaId;
  }

  /**
   * Sets the value of the narudzbenicaId property.
   * 
   */
  public void setNarudzbenicaId(Long value) {
      this.narudzbenicaId = value;
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
