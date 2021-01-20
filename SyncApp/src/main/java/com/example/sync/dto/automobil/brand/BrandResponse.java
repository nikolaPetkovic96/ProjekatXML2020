package com.example.sync.dto.automobil.brand;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBrandResponse", propOrder = { "types" })
@XmlRootElement(name = "GetBrandResponse")
public class BrandResponse {

	public BrandResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Brand", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Brand> types;

	public List<Brand> getBrands() {
		if (types == null) {
			types = new ArrayList<Brand>();
		}
		return this.types;
	}

	public void setBrands(List<Brand> types) {
		this.types = types;
	}

}
