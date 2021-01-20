package com.example.sync.dto.adresa;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAdresaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetAdresaResponse")
public class AdresaResponse {

	public AdresaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Adresa", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Adresa> types;

	public List<Adresa> getTypes() {
		if (types == null) {
			types = new ArrayList<Adresa>();
		}
		return this.types;
	}

	public void setTypes(List<Adresa> adrese) {
		this.types = adrese;
	}

}
