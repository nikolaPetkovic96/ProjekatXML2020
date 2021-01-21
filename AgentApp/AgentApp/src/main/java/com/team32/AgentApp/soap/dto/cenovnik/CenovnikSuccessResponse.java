package com.team32.AgentApp.soap.dto.cenovnik;

import javax.xml.bind.annotation.XmlElement;

public class CenovnikSuccessResponse {

  @XmlElement(name = "cenovnikId")
  protected Long cenovnikId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the cenovnikId property.
   * 
   */
  public Long getCenovnikId() {
      return cenovnikId;
  }

  /**
   * Sets the value of the cenovnikId property.
   * 
   */
  public void setCenovnikId(Long value) {
      this.cenovnikId = value;
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
