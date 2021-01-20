package com.team32.AgentApp.soap.dto.slika;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.SlikaVozila;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSlikaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetSlikaResponse")
public class SlikaResponse {

	public SlikaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Slika", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<SlikaVozila> types;

	public List<SlikaVozila> getSlika() {
		if (types == null) {
			types = new ArrayList<SlikaVozila>();
		}
		return this.types;
	}

	public void setSlika(List<SlikaVozila> types) {
		this.types = types;
	}

}
