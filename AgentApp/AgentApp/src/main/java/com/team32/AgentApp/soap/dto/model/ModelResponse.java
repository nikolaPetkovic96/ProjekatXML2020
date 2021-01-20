package com.team32.AgentApp.soap.dto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.ui.Model;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetModelResponse", propOrder = { "types" })
@XmlRootElement(name = "GetModelResponse")
public class ModelResponse {

	public ModelResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Model", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<Model> types;

	public List<Model> getModels() {
		if (types == null) {
			types = new ArrayList<Model>();
		}
		return this.types;
	}

	public void setModels(List<Model> types) {
		this.types = types;
	}
}
