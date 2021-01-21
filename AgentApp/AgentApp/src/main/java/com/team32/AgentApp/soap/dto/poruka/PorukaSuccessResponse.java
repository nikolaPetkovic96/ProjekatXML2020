package com.team32.AgentApp.soap.dto.poruka;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.stereotype.Component;

@Component
public class PorukaSuccessResponse {

	  @XmlElement(name = "porukaId")
	  protected Long porukaId;
	  
	  @XmlElement(name = "Successful", defaultValue = "false")
	  protected boolean successful;  
	  
	  
	  /**
	   * Gets the value of the porukaId property.
	   * 
	   */
	  public Long getPorukaId() {
	      return porukaId;
	  }
	
	  /**
	   * Sets the value of the porukaId property.
	   * 
	   */
	  public void setPorukaId(Long value) {
	      this.porukaId = value;
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
