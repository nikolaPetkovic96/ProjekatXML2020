package com.example.Baza.dto;

public class TTIpMenjacaDTO0 {
	private Long id;
	private String nazivMenjaca;
	private Long commonDataId;
	public TTIpMenjacaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TTIpMenjacaDTO0(Long id, String nazivMenjaca, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMenjaca = nazivMenjaca;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivMenjaca() {
		return nazivMenjaca;
	}
	public void setNazivMenjaca(String nazivMenjaca) {
		this.nazivMenjaca = nazivMenjaca;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
