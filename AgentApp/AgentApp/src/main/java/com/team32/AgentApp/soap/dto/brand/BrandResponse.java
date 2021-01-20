package com.team32.AgentApp.soap.dto.brand;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.MarkaAutomobila;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBrandResponse", propOrder = { "types" })
@XmlRootElement(name = "GetBrandResponse")
public class BrandResponse {

	public BrandResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Brand", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<MarkaAutomobila> types;

	public List<MarkaAutomobila> getBrands() {
		if (types == null) {
			types = new ArrayList<MarkaAutomobila>();
		}
		return this.types;
	}

	public void setBrands(List<MarkaAutomobila> types) {
		this.types = types;
	}

}
