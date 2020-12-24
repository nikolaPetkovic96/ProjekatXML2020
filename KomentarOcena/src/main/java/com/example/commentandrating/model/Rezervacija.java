
package com.example.commentandrating.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Rezervacija {

	@Id
	@XmlElement(namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
	protected Long id;

	@Column(name = "ukupna_cena")
	protected double ukupnaCena;

	@Column(name = "od_datuma")
	protected LocalDateTime odDatuma;

	@Column(name = "do_datuma")
	protected LocalDateTime doDatuma;

	@Column(name = "bundle")
	@XmlElement(name = "Bundle", namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
	protected Boolean bundle;

	@Column(name = "status_rezerv")
	protected String statusRezervacije;

	@Column(name = "commonDataId")
	protected Long commonDataId;

	public Rezervacija() {
		super();
	}

	public Rezervacija(Long id, double ukupnaCena, LocalDateTime odDatuma, LocalDateTime doDatuma, Boolean bundle,
			String statusRezervacije, Long commonDataId) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public LocalDateTime getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(LocalDateTime odDatuma) {
		this.odDatuma = odDatuma;
	}

	public LocalDateTime getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(LocalDateTime doDatuma) {
		this.doDatuma = doDatuma;
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

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}