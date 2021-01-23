package com.team32.AgentApp.soap.dto.cenovnik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CenovnikSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"cenovnikId",
"successful"
})

@XmlRootElement(name = "CenovnikSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class CenovnikSuccessResponse {

  @XmlElement(name = "CenovnikId")
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
