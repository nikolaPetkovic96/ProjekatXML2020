package com.example.sync.dto.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorityType", propOrder = {"id","authority"})
@XmlRootElement(name = "AuthorityType")
public class Authority {
	
	@XmlElement(name = "Id", required = true)
	private Long id;
	@XmlElement(name = "Authority", required = true)
	private String authority;


	public Authority(String authority) {
		super();
		this.authority = authority;
		if(authority.toLowerCase().equals("role_admin")) { this.id=(long) 1;}
		if(authority.toLowerCase().equals("role_agent")) { this.id=(long) 3;}
		if(authority.toLowerCase().equals("role_user")) { this.id=(long) 2;}
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

}
