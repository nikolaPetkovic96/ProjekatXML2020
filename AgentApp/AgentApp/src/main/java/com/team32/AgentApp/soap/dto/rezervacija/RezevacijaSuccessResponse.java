package com.team32.AgentApp.soap.dto.rezervacija;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RezevacijaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"rezevacijaId",
"successful"
})
@XmlRootElement(name = "RezevacijaSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class RezevacijaSuccessResponse {

  @XmlElement(name = "RezervacijaId")
  protected Long rezevacijaId;
  
  @XmlElement(name = "Successful", defaultValue = "false")
  protected boolean successful;  
  
  
  /**
   * Gets the value of the rezevacijaId property.
   * 
   */
  public Long getRezevacijaId() {
      return rezevacijaId;
  }

  /**
   * Sets the value of the rezevacijaId property.
   * 
   */
  public void setRezevacijaId(Long value) {
      this.rezevacijaId = value;
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
