package com.example.sync.dto.oglas.cenovnik;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCenovnikResponse", propOrder = { "types" })
@XmlRootElement(name = "GetCenovnikResponse")
public class CenovnikResponse {

	public CenovnikResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Cenovnik> types;

	public List<Cenovnik> getTypes() {
		if (types == null) {
			types = new ArrayList<Cenovnik>();
		}
		return this.types;
	}

	public void setTypes(List<Cenovnik> types) {
		this.types = types;
	}

}
