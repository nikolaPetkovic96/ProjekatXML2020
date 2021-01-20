package com.example.sync.dto.oglas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Oglas", propOrder = { "id", "commonDataId", "odDatuma","doDatuma",
										"cenovnikId","automobilId","planiranaKm","adresaId","username" })
@XmlRootElement(name = "Oglas")
public class Oglas {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "OdDatuma", required = true)
	protected LocalDateTime odDatuma;
	@XmlElement(name = "DoDatuma", required = true)
	protected LocalDateTime doDatuma;
	@XmlElement(name = "CenovnikId", required = true)
	protected Long cenovnikId;
	@XmlElement(name = "AutomobilId", required = true)
	private Long automobilId;
	@XmlElement(name = "PlaniranaKm", required = true)
	private float planiranaKm;
	@XmlElement(name = "AdresaId", required = true)
	private Long adresaId;
	@XmlElement(name = "Username", required = true)
	private String username;

	public Oglas() {
		// TODO Auto-generated constructor stub
	}

	public Oglas(Long id, Long commonDataId, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId,
			Long automobilId, float planiranaKm, Long adresaId, String username) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.automobilId = automobilId;
		this.planiranaKm = planiranaKm;
		this.adresaId = adresaId;
		this.username = username;
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

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public float getPlaniranaKm() {
		return planiranaKm;
	}

	public void setPlaniranaKm(float planiranaKm) {
		this.planiranaKm = planiranaKm;
	}

	public Long getAdresaId() {
		return adresaId;
	}

	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
