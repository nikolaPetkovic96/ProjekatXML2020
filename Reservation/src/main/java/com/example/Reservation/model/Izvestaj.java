package com.example.Reservation.model;

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
	
	@Column(name="automobil_id", nullable = false)
	private Long automobilId;
	
	@Column(name="rezervacija_id", nullable = false)
	private Long rezervacijaId;
	
	@Column(name="prekoracena_km", nullable = false)
	private Long prekoracenaKilometraza;
    
    @Column(name="dodatni_troskovi", nullable = false)
	private Long dodatniTroskovi;
	
	@Column(name="common_data_id", nullable = false)
	private Long commonDataId;

	public Izvestaj() {
		super();
	}

	public Izvestaj(Long id, float predjenaKilometraza, String tekstIzvestaja, Long narudzbenicaId, Long automobilId,
			Long rezervacijaId, Long prekoracenaKilometraza, Long dodatniTroskovi, Long commonDataId) {
		super();
		this.id = id;
		this.predjenaKilometraza = predjenaKilometraza;
		this.tekstIzvestaja = tekstIzvestaja;
		this.narudzbenicaId = narudzbenicaId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.prekoracenaKilometraza = prekoracenaKilometraza;
		this.dodatniTroskovi = dodatniTroskovi;
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

	public Long getPrekoracenaKilometraza() {
		return prekoracenaKilometraza;
	}

	public void setPrekoracenaKilometraza(Long prekoracenaKilometraza) {
		this.prekoracenaKilometraza = prekoracenaKilometraza;
	}

	public Long getDodatniTroskovi() {
		return dodatniTroskovi;
	}

	public void setDodatniTroskovi(Long dodatniTroskovi) {
		this.dodatniTroskovi = dodatniTroskovi;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}	
}