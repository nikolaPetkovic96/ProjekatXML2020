package com.example.sync.dto.rezervacija;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rezervacija", propOrder = { "id", "commonDataId", "ukupnaCena","bundle","statusRezervacije","username" })
@XmlRootElement(name = "Rezervacija")
public class Rezervacija {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;

	@XmlElement(name = "UkupnaCena", required = true)
	protected double ukupnaCena;
	@XmlElement(name = "Bundle", required = true)
	protected Boolean bundle;
	@XmlElement(name = "StatusRezervacije", required = true)
	protected String statusRezervacije;
	@XmlElement(name = "Username", required = true)
	protected String username;

	public Rezervacija() {
		// TODO Auto-generated constructor stub
	}

	public Rezervacija(Long id, Long commonDataId, double ukupnaCena, Boolean bundle, String statusRezervacije,
			String username) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Boolean getBundle() {
		return bundle;
	}

	public void setBundle(Boolean bundle) {
		this.bundle = bundle;
	}

	public String getStatusRezervacije() {
		return statusRezervacije;
	}

	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
