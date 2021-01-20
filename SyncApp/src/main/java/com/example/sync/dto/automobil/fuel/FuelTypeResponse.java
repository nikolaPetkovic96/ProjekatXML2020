package com.example.sync.dto.automobil.fuel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFuelTypesResponse", propOrder = { "types" })
@XmlRootElement(name = "GetFuelTypesResponse")
public class FuelTypeResponse {

	public FuelTypeResponse() {
	}
	@XmlElement(name = "FuelType", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<FuelType> types;

	public List<FuelType> getTypes() {
		if (types == null) {
			types = new ArrayList<FuelType>();
		}
		return this.types;
	}

	public void setTypes(List<FuelType> types) {
		this.types = types;
	}

}
