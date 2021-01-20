package com.example.sync.dto.automobil.slika;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSlikaResponse", propOrder = { "types" })
@XmlRootElement(name = "GetSlikaResponse")
public class SlikaResponse {

	public SlikaResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Slika", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Slika> types;

	public List<Slika> getSlika() {
		if (types == null) {
			types = new ArrayList<Slika>();
		}
		return this.types;
	}

	public void setSlika(List<Slika> types) {
		this.types = types;
	}

}
