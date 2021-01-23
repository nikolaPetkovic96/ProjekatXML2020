package com.team32.AgentApp.soap.dto.narudzbenica;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Narudzbenica;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetNarudzbenicaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetNarudzbenicaResponse")
public class NarudzbenicaResponse {

	public NarudzbenicaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Narudzbenica", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Narudzbenica> types;

	public List<Narudzbenica> getNarudzbenice() {
		if (types == null) {
			types = new ArrayList<Narudzbenica>();
		}
		return this.types;
	}

	public void setNarudzbenica(List<Narudzbenica> types) {
		this.types = types;
	}

}
