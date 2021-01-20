package com.team32.AgentApp.soap.dto.user;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.team32.AgentApp.model.entitet.User;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUserTypesResponse", propOrder = { "types" })
@XmlRootElement(name = "GetUserTypesResponse")
public class UserTypesResponse {

	public UserTypesResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "UserType", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected List<User> types;

	public List<User> getTypes() {
		if (types == null) {
			types = new ArrayList<User>();
		}
		return this.types;
	}

	public void setTypes(List<User> types) {
		this.types = types;
	}

}
