package com.example.Baza.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class RezervacijaDTO0 {
	private Long id;
	private double ukupnaCena;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
	private boolean bundle;
	private String statusRezervacije;
	private Long commonDataId;
	
	public RezervacijaDTO0(Long id, double ukupnaCena, LocalDateTime odDatuma, LocalDateTime doDatuma, boolean bundle,
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

	public RezervacijaDTO0() {
		super();
		// TODO Auto-generated constructor stub
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

	public boolean isBundle() {
		return bundle;
	}

	public void setBundle(boolean bundle) {
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
