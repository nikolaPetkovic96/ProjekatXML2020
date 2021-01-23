package com.team32.AgentApp.soap.dto.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"userId",
"successful"
})
@XmlRootElement(name = "UserSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class UserSuccessResponse {

  @XmlElement(name = "UserId")
  protected Long userId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the userId property.
   * 
   */
  public Long getUserId() {
      return userId;
  }

  /**
   * Sets the value of the userId property.
   * 
   */
  public void setUserId(Long value) {
      this.userId = value;
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
