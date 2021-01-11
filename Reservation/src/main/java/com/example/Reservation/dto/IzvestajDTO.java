package com.example.Reservation.dto;

import com.example.Reservation.model.Izvestaj;

public class IzvestajDTO {
	
	private Long id;
	
	private float predjenaKilometraza;

	private String tekstIzvestaja;

	private Long narudzbenicaId;

	private Long automobilId;

	private Long rezervacijaId;
	
	private Long prekoracenaKilometraza;
   
	private Long dodatniTroskovi;
	
	private Long commonDataId;

	public IzvestajDTO() {
		super();
	}
	
	public IzvestajDTO(Izvestaj i) {
		super();
		this.id = i.getId();
		this.predjenaKilometraza = i.getPredjenaKilometraza();
		this.tekstIzvestaja =  i.getTekstIzvestaja();
		this.narudzbenicaId = i.getNarudzbenicaId();
		this.automobilId = i.getAutomobilId();
		this.rezervacijaId = i.getRezervacijaId();
		this.prekoracenaKilometraza = i.getPrekoracenaKilometraza();
		this.dodatniTroskovi = i.getDodatniTroskovi();
		this.commonDataId = i.getCommonDataId();
	}

	public IzvestajDTO(Long id, float predjenaKilometraza, String tekstIzvestaja, Long narudzbenicaId, Long automobilId,
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
