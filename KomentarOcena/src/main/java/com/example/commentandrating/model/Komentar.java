
package com.example.commentandrating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Komentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "tekst_komentara", nullable = false)
	protected String tekstKomentara;

	@Column(name = "odobren")
	protected boolean odobren;

	@Column(name = "common_data_id")
	protected Long commonDataId;

	@Column(name = "automobil_id")
	private Long automobilId;
	

	@Column(name = "rezervacija_id")
	private Long rezervacijaId;


	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		this.id = value;
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

	public void setTekstKomentara(String value) {
		this.tekstKomentara = value;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean value) {
		this.odobren = value;
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

}