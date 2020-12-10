package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TKlasaAutomobilaDTO0 {
	private Long id;
	private String nazivKlase;
	private Long commonDataId;
	public TKlasaAutomobilaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TKlasaAutomobilaDTO0(Long id, String nazivKlase, Long commonDataId) {
		super();
		this.id = id;
		this.nazivKlase = nazivKlase;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivKlase() {
		return nazivKlase;
	}
	public void setNazivKlase(String nazivKlase) {
		this.nazivKlase = nazivKlase;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
