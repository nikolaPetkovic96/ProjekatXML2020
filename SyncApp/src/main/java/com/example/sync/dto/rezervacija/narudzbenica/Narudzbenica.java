package com.example.sync.dto.rezervacija.narudzbenica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Narudzbenica", propOrder = { "id", "commonDataId", "agentId",
											"userId","oglasId","rezervacijaId","odDatuma","doDatuma" })
@XmlRootElement(name = "Narudzbenica")
public class Narudzbenica {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "AgentId", required = true)
	private Long agentId;
	@XmlElement(name = "UserId", required = true)
	private Long userId;
	@XmlElement(name = "OglasId", required = true)
	private Long oglasId;
	@XmlElement(name = "RezervacijaId", required = true)
	private Long rezervacijaId;
	@XmlElement(name = "OdDatuma", required = true)
	private LocalDateTime odDatuma;
	@XmlElement(name = "DoDatuma", required = true)
	private LocalDateTime  doDatuma;

	
	public Narudzbenica() {
		// TODO Auto-generated constructor stub
	}

	public Narudzbenica(Long id, Long commonDataId, Long agentId, Long userId, Long oglasId, Long rezervacijaId,
			LocalDateTime odDatuma, LocalDateTime doDatuma) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.agentId = agentId;
		this.userId = userId;
		this.oglasId = oglasId;
		this.rezervacijaId = rezervacijaId;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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
	public void setOdDatuma(String odDatuma) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(odDatuma.replace('T',' ' ), formatter);
		this.odDatuma = dateTime;
	}
	
	public void setDoDatuma(String doDatuma) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(doDatuma.replace('T',' ' ), formatter);
		this.doDatuma = dateTime;
	}
}
