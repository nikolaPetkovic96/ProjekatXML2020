package com.team32.AgentApp.soap.dto.transmission;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransmissionTypesRequest", namespace = "http://www.ftn.uns.ac.rs/sync")
@XmlRootElement(name = "GetTransmissionTypesRequest", namespace = "http://www.ftn.uns.ac.rs/sync")
public class TransmissionTypesRequest {

	public TransmissionTypesRequest() {
	}

}
