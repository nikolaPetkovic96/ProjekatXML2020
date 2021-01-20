package com.team32.AgentApp.soap.dto.transmission;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.TipMenjaca;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTransmissionTypesResponse", propOrder = { "types" })
@XmlRootElement(name = "GetTransmissionTypesResponse")
public class TransmissionTypesResponse {

	public TransmissionTypesResponse() {
	}
	@XmlElement(name = "TransmissionType", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<TipMenjaca> types;

	public List<TipMenjaca> getTypes() {
		if (types == null) {
			types = new ArrayList<TipMenjaca>();
		}
		return this.types;
	}

	public void setTypes(List<TipMenjaca> types) {
		this.types = types;
	}

}
