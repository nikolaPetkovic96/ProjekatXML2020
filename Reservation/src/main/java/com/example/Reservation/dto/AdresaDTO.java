package com.example.Reservation.dto;

import com.example.Reservation.model.TAdresa;

public class AdresaDTO {
	private Long id;
	private String mesto;
	private int postanskiBroj;
	private String ulica;
	private int broj;
    private Long commonDataId;
	
	public AdresaDTO() {}
	
	public AdresaDTO(Long id, String mesto, int postanskiBroj, String ulica, int broj, Long commonDataId) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.commonDataId = commonDataId;
	}
	
	public AdresaDTO(TAdresa a) {
		super();
		this.id = a.getId();
		this.mesto = a.getMesto();
		this.postanskiBroj = Integer.valueOf(a.getPostanskiBroj());
		this.ulica = a.getUlica();
		this.broj = Integer.valueOf(a.getBroj());
		this.commonDataId = a.getCommonDataId();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
