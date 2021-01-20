package com.example.sync.dto.automobil.transmission;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransmissionTypesResponse", propOrder = { "types" })
@XmlRootElement(name = "GetTransmissionTypesResponse")
public class TransmissionTypesResponse {

	public TransmissionTypesResponse() {
	}
	@XmlElement(name = "TransmissionType", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<TransmissionType> types;

	public List<TransmissionType> getTypes() {
		if (types == null) {
			types = new ArrayList<TransmissionType>();
		}
		return this.types;
	}

	public void setTypes(List<TransmissionType> types) {
		this.types = types;
	}

}
