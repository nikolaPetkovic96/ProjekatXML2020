package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Rezervacija;

public class RezervacijaDTO {

	private Long id;
	private double ukupnaCena;
	private Boolean bundle;
	private String statusRezervacije;
	private Long commonDataId;
	
	public RezervacijaDTO() {
		
	}
	
	public RezervacijaDTO(Rezervacija r) {
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.commonDataId = r.getCommonDataId();
	}
	
	public RezervacijaDTO(Long id, double ukupnaCena, Boolean bundle, String statusRezervacije, Long commonDataId) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.commonDataId = commonDataId;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
