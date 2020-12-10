package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TMarkaAutomobilaDTO0 {
	private Long id;
	private String nazivMarke;
	private Long commonDataId;
	public TMarkaAutomobilaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TMarkaAutomobilaDTO0(Long id, String nazivMarke, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivMarke() {
		return nazivMarke;
	}
	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
