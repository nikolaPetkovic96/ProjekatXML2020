package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class IzvestajDTO0 {
	
	private Long id;
	private Long narudzbenicaId;
	private Long predjenaKm;
	private String poruka;
	private Long commonDataId;
		
	public IzvestajDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IzvestajDTO0(Long id, Long narudzbenicaId, Long predjenaKm, String poruka, Long commonDataId) {
		super();
		this.id = id;
		this.narudzbenicaId = narudzbenicaId;
		this.predjenaKm = predjenaKm;
		this.poruka = poruka;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNarudzbenicaId() {
		return narudzbenicaId;
	}
	public void setNarudzbenicaId(Long narudzbenicaId) {
		this.narudzbenicaId = narudzbenicaId;
	}
	public Long getPredjenaKm() {
		return predjenaKm;
	}
	public void setPredjenaKm(Long predjenaKm) {
		this.predjenaKm = predjenaKm;
	}
	public String getPoruka() {
		return poruka;
	}
	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
