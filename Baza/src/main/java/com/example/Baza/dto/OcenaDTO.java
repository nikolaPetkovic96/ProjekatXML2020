package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class OcenaDTO {
	private Long id;
	private int vrednostOcene;
	private Long CommonDataId;
	private Long automobilId;
	private Long rezervacijaId;
	
	public OcenaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OcenaDTO(Long id, int vrednostOcene, Long commonDataId, Long automobilId, Long rezervacijaId) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
		CommonDataId = commonDataId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVrednostOcene() {
		return vrednostOcene;
	}
	public void setVrednostOcene(int vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}
	public Long getCommonDataId() {
		return CommonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		CommonDataId = commonDataId;
	}
	public Long getAutomobilId() {
		return automobilId;
	}
	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	public Long getRezervacijaId() {
		return rezervacijaId;
	}
	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}	
}
