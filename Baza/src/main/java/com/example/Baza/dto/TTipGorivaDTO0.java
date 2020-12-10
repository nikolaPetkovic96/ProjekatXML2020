package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TTipGorivaDTO0 {

	private Long id;
	private String nazivGoriva;
	private Long commonDataId;
	
	public TTipGorivaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TTipGorivaDTO0(Long id, String nazivGoriva, Long commonDataId) {
		super();
		this.id = id;
		this.nazivGoriva = nazivGoriva;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivGoriva() {
		return nazivGoriva;
	}
	public void setNazivGoriva(String nazivGoriva) {
		this.nazivGoriva = nazivGoriva;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
