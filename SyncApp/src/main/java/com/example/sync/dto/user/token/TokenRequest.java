package com.example.sync.dto.user.token;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTokenRequest", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = {
	    "username",
	    "password"})
@XmlRootElement(name = "GetTokenRequest", namespace = "http://www.ftn.uns.ac.rs/sync")
public class TokenRequest {

	@XmlElement(name = "Username",namespace = "http://www.ftn.uns.ac.rs/sync", required = true)
	protected String username;
	@XmlElement(name = "Password", namespace = "http://www.ftn.uns.ac.rs/sync", required = true)
	protected String password;

	public TokenRequest() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String value) {
		this.username = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

}

