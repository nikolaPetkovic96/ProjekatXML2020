package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class PorukaDTO0 {
	private Long id;
	private String tekstPoruke;
	private Long rezervacijaId;
	private Long automobilId;
	private Long commonDataId;
	
	public PorukaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PorukaDTO0(Long id, String tekstPoruke, Long rezervacijaId, Long automobilId, Long commonDataId) {
		super();
		this.id = id;
		this.tekstPoruke = tekstPoruke;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTekstPoruke() {
		return tekstPoruke;
	}
	public void setTekstPoruke(String tekstPoruke) {
		this.tekstPoruke = tekstPoruke;
	}
	public Long getRezervacijaId() {
		return rezervacijaId;
	}
	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}
	public Long getAutomobilId() {
		return automobilId;
	}
	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
