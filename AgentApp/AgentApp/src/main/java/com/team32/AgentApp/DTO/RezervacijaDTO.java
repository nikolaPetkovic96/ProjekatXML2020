package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Rezervacija;

public class RezervacijaDTO {

	private Long id;
	private double ukupnaCena;
	private Boolean bundle;
	private String statusRezervacije;
	private Long commonDataId;
	private String username; // dodato u DTO
	
	public RezervacijaDTO() {
		
	}
	//Dodat String username kako bi se u returnu
	//POST I PUT zahteva vratila i vrednost username korisnika koji je kreirao/izmeno rezervaciju
	public RezervacijaDTO(Rezervacija r,String username) {
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.commonDataId = r.getCommonDataId();
		this.username = username;
	}
	
	public RezervacijaDTO(Long id, double ukupnaCena, Boolean bundle, String statusRezervacije, Long commonDataId, String username) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
