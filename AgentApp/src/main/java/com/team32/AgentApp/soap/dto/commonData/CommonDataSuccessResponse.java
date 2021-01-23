package com.team32.AgentApp.soap.dto.commonData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonDataSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"commonDataId",
"successful"
})

@XmlRootElement(name = "CommonDataSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class CommonDataSuccessResponse {

  @XmlElement(name = "CommonDataId")
  protected Long commonDataId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the commonDataId property.
   * 
   */
  public Long getCommonDataId() {
      return commonDataId;
  }

  /**
   * Sets the value of the commonDataId property.
   * 
   */
  public void setCommonDataId(Long value) {
      this.commonDataId = value;
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
