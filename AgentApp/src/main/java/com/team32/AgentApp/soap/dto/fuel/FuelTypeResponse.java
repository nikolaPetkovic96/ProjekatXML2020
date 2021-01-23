package com.team32.AgentApp.soap.dto.fuel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.tentitet.TipGoriva;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFuelTypeResponse", propOrder = { "types" })
@XmlRootElement(name = "GetFuelTypeResponse")
public class FuelTypeResponse {

	public FuelTypeResponse() {
	}
	@XmlElement(name = "FuelType", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<TipGoriva> types;

	public List<TipGoriva> getTypes() {
		if (types == null) {
			types = new ArrayList<TipGoriva>();
		}
		return this.types;
	}

	public void setTypes(List<TipGoriva> types) {
		this.types = types;
	}

}
