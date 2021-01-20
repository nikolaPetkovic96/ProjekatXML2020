
package com.example.LoginReg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@XmlType(name = "TAdresa", namespace = "http://www.ftn.uns.ac.rs/korisnici", propOrder = { "id", "mesto",
		"postanskiBroj", "ulica", "broj", })
public class TAdresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "mesto", nullable = false)
	@XmlElement(name = "Mesto", required = true)
	protected String mesto;

	@Column(name = "postanskiBroj", nullable = false)
	@XmlElement(name = "Postanski_broj")
	protected String postanskiBroj;

	@Column(name = "ulica", nullable = false)
	@XmlElement(name = "Ulica", required = true)
	protected String ulica;

	@Column(name = "broj")
	@XmlElement(name = "Broj")
	protected String broj;

	public TAdresa() {
		super();
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

}
