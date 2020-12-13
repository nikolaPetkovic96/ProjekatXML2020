package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;

import com.team32.AgentApp.model.entitet.Narudzbenica;


public class NarudzbenicaDTO {
	
	private Long id;

	private Long agentId;
	
	private Long userId;
	
	private Long oglasId;
	
	private Long rezervacijaId;
	
    private LocalDateTime odDatuma;
    
    private LocalDateTime  doDatuma;

    private Long commonDataId;

	public NarudzbenicaDTO() {
		super();
	}
	
	public NarudzbenicaDTO(Narudzbenica n) {
		this(
			n.getId(),
			n.getAgentId(),
			n.getUserId(),
			n.getOglasId(),
			n.getRezervacijaId(),
			n.getOdDatuma(),
			n.getDoDatuma(),
			n.getCommonDataId()
			);
	}

	public NarudzbenicaDTO(Long id, Long agentId, Long userId, Long oglasId, Long rezervacijaId, LocalDateTime odDatuma,
			LocalDateTime doDatuma, Long commonDataId) {
		super();
		this.id = id;
		this.agentId = agentId;
		this.userId = userId;
		this.oglasId = oglasId;
		this.rezervacijaId = rezervacijaId;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
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

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
  
}