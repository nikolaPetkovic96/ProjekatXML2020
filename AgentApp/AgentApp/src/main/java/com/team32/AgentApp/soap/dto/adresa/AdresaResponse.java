package com.team32.AgentApp.soap.dto.adresa;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.Adresa;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAdresaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetAdresaResponse")
public class AdresaResponse {

	public AdresaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Adresa", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Adresa> list;

	public List<Adresa> get() {
		if (list == null) {
			list = new ArrayList<Adresa>();
		}
		return this.list;
	}

	public void set(List<Adresa> adrese) {
		this.list = adrese;
	}

}
