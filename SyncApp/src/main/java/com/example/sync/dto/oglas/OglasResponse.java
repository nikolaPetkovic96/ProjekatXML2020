package com.example.sync.dto.oglas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOglasResponse", propOrder = { "types" })
@XmlRootElement(name = "GetOglasResponse")
public class OglasResponse {

	public OglasResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Oglas> types;

	public List<Oglas> getTypes() {
		if (types == null) {
			types = new ArrayList<Oglas>();
		}
		return this.types;
	}

	public void setTypes(List<Oglas> types) {
		this.types = types;
	}

}
