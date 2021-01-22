package com.example.sync.dto.adresa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresa", propOrder = { "id", "mesto","postanskiBroj","ulica","broj","commonDataId" })
@XmlRootElement(name = "Adresa")
public class Adresa {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "Mesto", required = true)
	protected String mesto;
	@XmlElement(name = "PostanskiBroj", required = true)
	protected String postanskiBroj;
	@XmlElement(name = "Ulica", required = true)
	protected String ulica;
	@XmlElement(name = "Broj", required = true)
	protected String broj;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;

	public Adresa() {
		// TODO Auto-generated constructor stub
		this.commonDataId=Long.parseLong("-1");
	}

	public Adresa(Long id,  String mesto, String postanskiBroj, String ulica, String broj) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.commonDataId=Long.parseLong("-1");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
