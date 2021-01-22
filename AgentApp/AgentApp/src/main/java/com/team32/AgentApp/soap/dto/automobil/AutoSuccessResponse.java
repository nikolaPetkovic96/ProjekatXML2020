package com.team32.AgentApp.soap.dto.automobil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
    "automobilId",
    "successful"
})

@XmlRootElement(name = "AutoSuccessResponse",namespace="http://www.ftn.uns.ac.rs/sync")
public class AutoSuccessResponse {

  @XmlElement(name = "AutomobilId")
  protected Long automobilId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the automobilId property.
   * 
   */
  public Long getAutomobilId() {
      return automobilId;
  }

  /**
   * Sets the value of the automobilId property.
   * 
   */
  public void setAutomobilId(Long value) {
      this.automobilId = value;
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
