package com.example.sync.dto.ocena;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "Ocena", propOrder = { "id", "commonDataId", "vrednostOcene","automobilId","rezervacijaId","autor" })
@XmlRootElement(name = "Ocena")
public class Ocena {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	@XmlElement(name = "VrednostOcene", required = true)
	protected int vrednostOcene;
	@XmlElement(name = "AutomobilId", required = true)
	private Long automobilId;
	@XmlElement(name = "RezervacijaId", required = true)
	private Long rezervacijaId;
	@XmlElement(name = "Autor", required = true)
	private String autor;
	
	public Ocena() {
		// TODO Auto-generated constructor stub
	}

	public Ocena(Long id, Long commonDataId, int vrednostOcene, Long automobilId, Long rezervacijaId,
			String autor) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.vrednostOcene = vrednostOcene;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.autor = autor;
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

	public int getVrednostOcene() {
		return vrednostOcene;
	}

	public void setVrednostOcene(int vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
