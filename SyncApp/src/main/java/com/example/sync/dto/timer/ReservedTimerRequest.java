package com.example.sync.dto.timer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservedTimerRequest", propOrder = { "rezId" })
@XmlRootElement(name = "ReservedTimerRequest")
public class ReservedTimerRequest {
	
	@XmlElement(name = "ResId", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected Long rezId;
	public ReservedTimerRequest() {
		// TODO Auto-generated constructor stub
	}
	public Long getRezId() {
		return rezId;
	}
	public void setRezId(Long rezId) {
		this.rezId = rezId;
	}
	public ReservedTimerRequest(Long rezId) {
		super();
		this.rezId = rezId;
	}

}
