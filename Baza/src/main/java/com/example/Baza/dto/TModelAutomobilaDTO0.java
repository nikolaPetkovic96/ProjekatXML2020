package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TModelAutomobilaDTO0 {
	private Long id;
	private String nazivModela;
	private Long markaId;
	private Long commonDataId;
	public TModelAutomobilaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TModelAutomobilaDTO0(Long id, String nazivModela, Long markaId, Long commonDataId) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.markaId = markaId;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivModela() {
		return nazivModela;
	}
	public void setNazivModela(String nazivModela) {
		this.nazivModela = nazivModela;
	}
	public Long getMarkaId() {
		return markaId;
	}
	public void setMarkaId(Long markaId) {
		this.markaId = markaId;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
