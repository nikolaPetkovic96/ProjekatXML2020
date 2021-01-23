package com.team32.AgentApp.soap.dto.slika;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SlikaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"slikaId",
"successful"
})
@XmlRootElement(name = "SlikaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class SlikaSuccessResponse {

  @XmlElement(name = "SlikaId")
  protected Long slikaId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the slikaId property.
   * 
   */
  public Long getSlikaId() {
      return slikaId;
  }

  /**
   * Sets the value of the slikaId property.
   * 
   */
  public void setSlikaIdId(Long value) {
      this.slikaId = value;
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
