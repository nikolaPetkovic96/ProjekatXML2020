package com.example.sync.dto.komentar;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Komentar", propOrder = { "id", "commonDataId", "tekstKomentara", "odobren", "automobilId","rezervacijaId","autor" })
@XmlRootElement(name = "Komentar")
public class Komentar {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "Tekstkomentara", required = true)
	protected String tekstKomentara;

	@XmlElement(name = "Odobren", required = true)
	protected boolean odobren;

	@XmlElement(name = "AutomobilId", required = true)
	private Long automobilId;
	

	@XmlElement(name = "RezervacijaId", required = true)
	private Long rezervacijaId;
	
	@XmlElement(name = "Autor", required = true)
	protected String autor;

	public Komentar() {
		// TODO Auto-generated constructor stub
	}

	public Komentar(Long id, Long commonDataId, String tekstKomentara, boolean odobren, Long automobilId,
			Long rezervacijaId, String autor) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.tekstKomentara = tekstKomentara;
		this.odobren = odobren;
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

	public String getTekstKomentara() {
		return tekstKomentara;
	}

	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
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
