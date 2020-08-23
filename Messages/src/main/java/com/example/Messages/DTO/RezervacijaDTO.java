package com.example.Messages.DTO;

import java.time.LocalDateTime;
import java.util.Date;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;

public class RezervacijaDTO {

	private Long id;
	private double ukupnaCena;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
	private Boolean bundle;
	private String statusRezervacije;
	private Long commonDataId;
	private String username;
    
//	private List<OglasDTO> oglas;
	
	public RezervacijaDTO() {
		
	}
	
	public RezervacijaDTO(Rezervacija r) {
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.odDatuma = r.getOdDatuma();
		this.doDatuma = r.getDoDatuma();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		this.commonDataId = r.getCommonDataId();
	}
	
	public RezervacijaDTO(Long id, double ukupnaCena, LocalDateTime odDatuma, LocalDateTime doDatuma, Boolean bundle, Long commonDataId,
			String statusRezervacije, String username) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.commonDataId = commonDataId;
		this.username = username;
//		this.oglas = oglas;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<OglasDTO> getOglas() {
//		return oglas;
//	}
//
//	public void setOglas(List<OglasDTO> oglas) {
//		this.oglas = oglas;
//	}

}
