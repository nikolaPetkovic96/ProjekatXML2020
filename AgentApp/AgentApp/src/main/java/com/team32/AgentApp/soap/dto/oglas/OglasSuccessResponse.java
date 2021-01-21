package com.team32.AgentApp.soap.dto.oglas;

import javax.xml.bind.annotation.XmlElement;

public class OglasSuccessResponse {

  @XmlElement(name = "oglasId")
  protected Long oglasId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the oglasId property.
   * 
   */
  public Long getOglasId() {
      return oglasId;
  }

  /**
   * Sets the value of the oglasId property.
   * 
   */
  public void setOglasId(Long value) {
      this.oglasId = value;
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
