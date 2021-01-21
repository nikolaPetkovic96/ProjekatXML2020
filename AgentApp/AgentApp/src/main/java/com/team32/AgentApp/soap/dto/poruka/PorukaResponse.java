package com.team32.AgentApp.soap.dto.poruka;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Poruka;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPorukaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetPorukaResponse")

public class PorukaResponse {

	public PorukaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Poruka", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Poruka> types;

	public List<Poruka> getMessages() {
		if (types == null) {
			types = new ArrayList<Poruka>();
		}
		return this.types;
	}

	public void setMessage(List<Poruka> types) {
		this.types = types;
	}
}
