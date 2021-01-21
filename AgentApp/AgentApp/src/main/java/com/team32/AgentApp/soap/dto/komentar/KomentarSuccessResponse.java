package com.team32.AgentApp.soap.dto.komentar;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.stereotype.Component;

@Component
public class KomentarSuccessResponse {

	  @XmlElement(name = "komentarId")
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
