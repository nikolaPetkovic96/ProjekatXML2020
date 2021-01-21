package com.team32.AgentApp.soap.dto.izvestaj;

import javax.xml.bind.annotation.XmlElement;

public class IzvestajSuccessResponse {

  @XmlElement(name = "izvestajId")
  protected Long izvestajId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the izvestajId property.
   * 
   */
  public Long getIzvestajId() {
      return izvestajId;
  }

  /**
   * Sets the value of the izvestajId property.
   * 
   */
  public void setIzvestajId(Long value) {
      this.izvestajId = value;
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
