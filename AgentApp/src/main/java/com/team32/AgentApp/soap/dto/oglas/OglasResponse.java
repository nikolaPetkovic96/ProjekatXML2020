package com.team32.AgentApp.soap.dto.oglas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Oglas;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOglasResponse", propOrder = { "types" })
@XmlRootElement(name = "GetOglasResponse")
public class OglasResponse {

	public OglasResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Oglas> types;

	public List<Oglas> getAds() {
		if (types == null) {
			types = new ArrayList<Oglas>();
		}
		return this.types;
	}

	public void setAd(List<Oglas> types) {
		this.types = types;
	}

}
