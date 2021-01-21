package com.team32.AgentApp.soap.dto.cenovnik;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Cenovnik;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCenovnikResponse", propOrder = { "types" })
@XmlRootElement(name = "GetCenovnikResponse")
public class CenovnikResponse {

	public CenovnikResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Cenovnik> types;

	public List<Cenovnik> getPrices() {
		if (types == null) {
			types = new ArrayList<Cenovnik>();
		}
		return this.types;
	}

	public void setPrice(List<Cenovnik> types) {
		this.types = types;
	}

}
