package com.example.Reservation.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.Reservation.model.Rezervacija;

public class RezervacijaDTO {

	private Long id;
	private double ukupnaCena;
	private Boolean bundle;
	private String statusRezervacije;
	private Long commonDataId; 			//Moze se i obrisati jer treba samo za new;
	private String username; 			//Dodato u DTO- kreirao rezervaciju
	private Long agentId;				//kreirao oglas
										//fali napomena
	public RezervacijaDTO() {
		
	}
	//Dodat String username kako bi se u returnu
	//POST I PUT zahteva vratila i vrednost username korisnika koji je kreirao/izmeno rezervaciju
	public RezervacijaDTO(Rezervacija r, Long agentId) {
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.commonDataId = r.getCommonDataId();
		this.username=r.getUsername();
		this.agentId = agentId;
	}
	
	public RezervacijaDTO(Long id, double ukupnaCena, Boolean bundle, String statusRezervacije, Long commonDataId, String username,Long agentId) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		
		this.commonDataId = commonDataId;
		this.username = username;
		this.agentId = agentId;
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
	public Long getAgentId() {
		return agentId;
	}
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}
}
