package com.team32.AgentApp.soap.dto.ocena;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Ocena;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOcecnaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetOcenaResponse")

public class OcenaResponse {

	public OcenaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Ocena", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Ocena> types;

	public List<Ocena> getTypes() {
		if (types == null) {
			types = new ArrayList<Ocena>();
		}
		return this.types;
	}

	public void setTypes(List<Ocena> types) {
		this.types = types;
	}

}
