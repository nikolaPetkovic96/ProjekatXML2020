package com.team32.AgentApp.soap.dto.rezervacija;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Rezervacija;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRezervacijaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetRezervacijaResponse")
public class RezervacijaResponse {

	public RezervacijaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Rezervacija", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Rezervacija> types;

	public List<Rezervacija> getTypes() {
		if (types == null) {
			types = new ArrayList<Rezervacija>();
		}
		return this.types;
	}

	public void setTypes(List<Rezervacija> types) {
		this.types = types;
	}

}
