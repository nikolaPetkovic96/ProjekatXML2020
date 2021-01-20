package com.example.sync.dto.poruka;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Poruka", propOrder = { "id", "commonDataId", "tekstPoruke","rezervacijaId","automobilId" })
@XmlRootElement(name = "Poruka")
public class Poruka {

	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "TekstPoruke", required = true)
	protected String tekstPoruke;
	@XmlElement(name = "RezervacijaId", required = true)
	private Long rezervacijaId;
	@XmlElement(name = "AutomobilId", required = true)
	private Long automobilId;
	
	public Poruka() {
		// TODO Auto-generated constructor stub
	}

	public Poruka(Long id, Long commonDataId, String tekstPoruke, Long rezervacijaId, Long automobilId) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.tekstPoruke = tekstPoruke;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
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

	public String getTekstPoruke() {
		return tekstPoruke;
	}

	public void setTekstPoruke(String tekstPoruke) {
		this.tekstPoruke = tekstPoruke;
	}

	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	
}
