package com.example.Baza.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class OglasDTO0 {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
	private Long cenovnikId;
	private Long commonDataId;
	private Long automobilId;
	private int planiranaKm;
	
	public OglasDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OglasDTO0(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long commonDataId,
			Long automobilId, int planiranaKm) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.planiranaKm = planiranaKm;
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
	public Long getCenovnikId() {
		return cenovnikId;
	}
	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
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
	public int getPlaniranaKm() {
		return planiranaKm;
	}
	public void setPlaniranaKm(int planiranaKm) {
		this.planiranaKm = planiranaKm;
	}	
}
