package com.example.Reservation.dto;

import java.util.List;

import com.example.Reservation.model.Rezervacija;

public class RezervacijaNewDTO {

	private Long id;
	private double ukupnaCena;                   
	private Boolean bundle;                  
	private String statusRezervacije;   
	private Long commonDataId;
	private List<NarudzbenicaNewDTO> narudzbenice;
  
	
	public RezervacijaNewDTO() {
		
	}

	public RezervacijaNewDTO(Rezervacija r, List<NarudzbenicaNewDTO> narudzbenice) {
		super();
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.commonDataId = r.getCommonDataId();
		
		this.narudzbenice = narudzbenice;
	}
	
	public RezervacijaNewDTO(Long id, double ukupnaCena, Boolean bundle, String napomenaRezervacije, String statusRezervacije, 
			Long commonDataId, List<NarudzbenicaNewDTO> narudzbenice) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.commonDataId = commonDataId;
		this.narudzbenice = narudzbenice;
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

	public List<NarudzbenicaNewDTO> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(List<NarudzbenicaNewDTO> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}

}
