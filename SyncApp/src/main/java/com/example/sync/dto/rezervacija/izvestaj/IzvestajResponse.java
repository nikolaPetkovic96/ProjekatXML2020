package com.example.sync.dto.rezervacija.izvestaj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IzvestajResponse", propOrder = { "types" })
@XmlRootElement(name = "IzvestajResponse")

public class IzvestajResponse {

	public IzvestajResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Izvestaj", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Izvestaj> types;

	public List<Izvestaj> getTypes() {
		if (types == null) {
			types = new ArrayList<Izvestaj>();
		}
		return this.types;
	}

	public void setTypes(List<Izvestaj> types) {
		this.types = types;
	}

}
