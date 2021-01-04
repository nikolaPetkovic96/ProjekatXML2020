package com.example.Reservation.dto;

import java.util.List;

import com.example.Reservation.model.Rezervacija;

public class RezervacijaNewDTO {

	private Long id;
	private double ukupnaCena;                   
	private Boolean bundle;                  
	private String statusRezervacije;   
	private String napomenaRezervacije; //napomena u rezerv
	private Long commonDataId;
	private List<NarudzbenicaNewDTO> narudzbenica;
  
	
	public RezervacijaNewDTO() {
		
	}

	public RezervacijaNewDTO(Rezervacija r, List<NarudzbenicaNewDTO> narudzbenica) {
		super();
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.napomenaRezervacije = r.getNapomena();
		this.commonDataId = r.getCommonDataId();
		
		this.narudzbenica = narudzbenica;
	}
	
	public RezervacijaNewDTO(Long id, double ukupnaCena, Boolean bundle, String napomenaRezervacije, String statusRezervacije, String poruka,
			Long commonDataId, List<NarudzbenicaNewDTO> narudzbenica) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.napomenaRezervacije = poruka;
		this.commonDataId = commonDataId;
		this.narudzbenica = narudzbenica;
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


	public String getNapomenaRezervacije() {
		return napomenaRezervacije;
	}


	public void setNapomenaRezervacije(String poruka) {
		this.napomenaRezervacije = poruka;
	}


	public Long getCommonDataId() {
		return commonDataId;
	}


	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}


	public List<NarudzbenicaNewDTO> getNarudzbenica() {
		return narudzbenica;
	}


	public void setNarudzbenica(List<NarudzbenicaNewDTO> narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

}
