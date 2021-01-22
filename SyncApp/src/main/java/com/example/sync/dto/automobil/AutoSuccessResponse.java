package com.example.sync.dto.automobil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoSuccessResponse", propOrder = { "automobilId", "successful" })
@XmlRootElement(name = "AutoSuccessResponse")
public class AutoSuccessResponse {
	
	@XmlElement(name = "automobilId")
	protected Long automobilId;
	  
	@XmlElement(name = "Successful", defaultValue = "false")
	protected boolean successful; 
	
	public AutoSuccessResponse(Long automobilId, boolean successful) {
		super();
		this.automobilId = automobilId;
		this.successful = successful;
	}

	public AutoSuccessResponse() {
		// TODO Auto-generated constructor stub
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	
	

}
