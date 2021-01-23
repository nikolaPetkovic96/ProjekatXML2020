package com.team32.AgentApp.soap.dto.komentar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KomentarSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync", propOrder = {
"komentarId",
"successful"
})

@XmlRootElement(name = "KomentarSuccessResponse", namespace="http://www.ftn.uns.ac.rs/sync")
public class KomentarSuccessResponse {

	  @XmlElement(name = "KomentarId")
	  protected Long komentarId;
	  
	  @XmlElement(name = "Successful", defaultValue = "false")
	  protected boolean successful;  
	  
	  /**
	   * Gets the value of the komentarId property.
	   * 
	   */
	  public Long getKomentarId() {
	      return komentarId;
	  }
	
	  /**
	   * Sets the value of the komentarId property.
	   * 
	   */
	  public void setKomentarId(Long value) {
	      this.komentarId = value;
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
