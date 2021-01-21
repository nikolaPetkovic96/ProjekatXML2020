package com.example.sync.dto.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorityType", propOrder = {"authority"})
@XmlRootElement(name = "AuthorityType")
public class Authority {
	
	@XmlElement(name = "Authority", required = true)
	private String authority;


	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Authority() {
		// TODO Auto-generated constructor stub
	}

}
