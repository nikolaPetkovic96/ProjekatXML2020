package com.team32.AgentApp.model.entitet;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;


//Tabela sa id i nazivom role: agent,admin,user
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorityType", propOrder = {"id", "name"})
@XmlRootElement(name = "AuthorityType")
@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="authority_id")
	@XmlElement(name = "Id", required = true)
	private Long id;

	@Column
	@XmlElement(name = "Authority", required = true)
	private String name;	
	
public Authority() {}
	
public Authority(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@JsonIgnore
	public String getName() {
		return name;
	}

	//@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
