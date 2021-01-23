package com.team32.AgentApp.soap.dto.automobil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.Automobil;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAutomobilResponse", propOrder = { "types" })
@XmlRootElement(name = "GetAutomobilResponse")
public class AutomobilResponse {

	public AutomobilResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Automobil", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Automobil> types;

	public List<Automobil> getAutomobils() {
		if (types == null) {
			types = new ArrayList<Automobil>();
		}
		return this.types;
	}

	public void setAutomobils(List<Automobil> types) {
		this.types = types;
	}

}
