package com.team32.AgentApp.soap.dto.carClass;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.KlasaAutomobila;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetKlasaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetKlasaResponse")
public class KlasaResponse {

	public KlasaResponse() {
		// TODO Auto-generated constructor stub
	}@XmlElement(name = "Klasa", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<KlasaAutomobila> types;

	public List<KlasaAutomobila> getKlase() {
		if (types == null) {
			types = new ArrayList<KlasaAutomobila>();
		}
		return this.types;
	}

	public void setKlase(List<KlasaAutomobila> types) {
		this.types = types;
	}

}
