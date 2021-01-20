package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.Adresa;

public class AdresaDTO {
	private Long id;
	private String mesto;
	private String postanskiBroj;
	private String ulica;
	private String broj;
    private Long commonDataId;
	
	public AdresaDTO() {}
	
	public AdresaDTO(Long id, String mesto, String postanskiBroj, String ulica, String broj, Long commonDataId) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.commonDataId = commonDataId;
	}
	
	public AdresaDTO(Adresa a) {
		super();
		this.id = a.getId();
		this.mesto = a.getMesto();
		this.postanskiBroj = a.getPostanskiBroj();
		this.ulica = a.getUlica();
		this.broj = a.getBroj();
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
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
