package com.example.Messages2.dto;

import com.example.Messages2.model.Poruka;

public class PorukaNewDTO {

	private Long id;
	private String tekstPoruke;
	private Long rezervacijaId;
	private Long automobilId;
	private Long commonDataId;
 
	public PorukaNewDTO() {
		
	}
	
	public PorukaNewDTO(Poruka p) {
		this.id = p.getId();
		this.tekstPoruke = p.getTekstPoruke();
		this.rezervacijaId = p.getRezervacijaId();
		this.automobilId = p.getAutomobilId();
		this.commonDataId = p.getCommonDataId();
 	}
	
	public PorukaNewDTO(Long id, String tekstPoruke, Long rezervacijaId, Long automobilId, Long commonDataId) {
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