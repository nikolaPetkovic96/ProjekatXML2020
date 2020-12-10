package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class KomentarDTO0 {
	
	private Long id;
	private String tekst;
	private boolean odobren;
	private Long commonDataId;
	private Long automobilId;
	private Long rezervacijaId;
	
	
	public KomentarDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KomentarDTO0(Long id, String tekst, boolean odobren, Long commonDataId, Long automobilId,
			Long rezervacijaId) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.odobren = odobren;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public boolean isOdobren() {
		return odobren;
	}
	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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
