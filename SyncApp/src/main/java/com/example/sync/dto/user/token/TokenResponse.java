package com.example.sync.dto.user.token;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTokenResponse", propOrder = { "token" })
@XmlRootElement(name = "GetTokenResponse")
public class TokenResponse {

	public TokenResponse() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name = "Token", namespace = "http://www.ftn.uns.ac.rs/sync")
	protected String token;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
