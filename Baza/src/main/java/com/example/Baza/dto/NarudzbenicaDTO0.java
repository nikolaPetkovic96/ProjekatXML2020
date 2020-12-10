package com.example.Baza.dto;

import java.time.LocalDateTime;

public class NarudzbenicaDTO0 {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
	private Long userId;
	private Long oglasId;
	private Long rezervacijaId;
	private Long commonDataId;
	
	public NarudzbenicaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NarudzbenicaDTO0(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long userId, Long oglasId,
			Long rezervacijaId, Long commonDataId) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.userId = userId;
		this.oglasId = oglasId;
		this.rezervacijaId = rezervacijaId;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getOdDatuma() {
		return odDatuma;
	}
	public void setOdDatuma(LocalDateTime odDatuma) {
		this.odDatuma = odDatuma;
	}
	public LocalDateTime getDoDatuma() {
		return doDatuma;
	}
	public void setDoDatuma(LocalDateTime doDatuma) {
		this.doDatuma = doDatuma;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOglasId() {
		return oglasId;
	}
	public void setOglasId(Long oglasId) {
		this.oglasId = oglasId;
	}
	public Long getRezervacijaId() {
		return rezervacijaId;
	}
	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}	
}
