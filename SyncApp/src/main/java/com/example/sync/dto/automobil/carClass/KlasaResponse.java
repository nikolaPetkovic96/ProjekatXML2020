package com.example.sync.dto.automobil.carClass;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetKlasaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetKlasaResponse")
public class KlasaResponse {

	public KlasaResponse() {
		// TODO Auto-generated constructor stub
	}@XmlElement(name = "Klasa", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Klasa> types;

	public List<Klasa> getKlase() {
		if (types == null) {
			types = new ArrayList<Klasa>();
		}
		return this.types;
	}

	public void setKlase(List<Klasa> types) {
		this.types = types;
	}

}
