package com.team32.AgentApp.soap.dto.izvestaj;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzvestajSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"izvestajId",
"successful"
})

@XmlRootElement(name = "IzvestajSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class IzvestajSuccessResponse {

  @XmlElement(name = "IzvestajId")
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
