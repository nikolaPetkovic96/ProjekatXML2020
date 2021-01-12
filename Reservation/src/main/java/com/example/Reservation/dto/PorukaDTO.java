package com.example.Reservation.dto;

import com.example.Reservation.model.Poruka;

public class PorukaDTO {

	private Long id;
	private String tekstPoruke;
	private Long rezervacijaId;
	private Long commonDataId;
	private Long automobilId;
    private String username;
    private CommonDataDTO commonData;

	public PorukaDTO() {
		
	}
	
	public PorukaDTO(Poruka p, CommonDataDTO commonData) {
		this.id = p.getId();
		this.tekstPoruke = p.getTekstPoruke();
		this.rezervacijaId = p.getRezervacijaId();
		this.automobilId = p.getAutomobilId();
		this.commonDataId = p.getCommonDataId();
		this.username = p.getUsername();
		this.commonData = commonData;
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

	public CommonDataDTO getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
}
