package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TSlikaVozilaDTO0 {
	private Long id;
	private byte[] slika;
	private Long automoobilId;
	private Long commonDataId;
	public TSlikaVozilaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TSlikaVozilaDTO0(Long id, byte[] slika, Long automoobilId, Long commonDataId) {
		super();
		this.id = id;
		this.slika = slika;
		this.automoobilId = automoobilId;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getSlika() {
		return slika;
	}
	public void setSlika(byte[] slika) {
		this.slika = slika;
	}
	public Long getAutomoobilId() {
		return automoobilId;
	}
	public void setAutomoobilId(Long automoobilId) {
		this.automoobilId = automoobilId;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
