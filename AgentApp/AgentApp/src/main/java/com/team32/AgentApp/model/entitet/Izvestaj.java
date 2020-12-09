package com.team32.AgentApp.model.entitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Izvestaj {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="predjena_km", nullable = false)
	private float predjenaKilometraza;
	
	@Column(name="tekst_izvestaja")
	private String tekstIzvestaja;
	
	@Column(name="narudzbenica_id", nullable = false)
	private Long narudzbenicaId;
	
	@Column(name="common_data_id", nullable = false)
	private Long commonDataId;

	public Izvestaj() {
		super();
	}

	public Izvestaj(Long id, float predjenaKilometraza, String tekstIzvestaja, Long narudzbenicaId, Long commonDataId) {
		super();
		this.id = id;
		this.predjenaKilometraza = predjenaKilometraza;
		this.tekstIzvestaja = tekstIzvestaja;
		this.narudzbenicaId = narudzbenicaId;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}

	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}

	public String getTekstIzvestaja() {
		return tekstIzvestaja;
	}

	public void setTekstIzvestaja(String tekstIzvestaja) {
		this.tekstIzvestaja = tekstIzvestaja;
	}

	public Long getNarudzbenicaId() {
		return narudzbenicaId;
	}

	public void setNarudzbenicaId(Long narudzbenicaId) {
		this.narudzbenicaId = narudzbenicaId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	
}
