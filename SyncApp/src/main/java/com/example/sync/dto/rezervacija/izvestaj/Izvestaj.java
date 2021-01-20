package com.example.sync.dto.rezervacija.izvestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Izvestaj", propOrder = { "id", "commonDataId","predjenaKilometraza","tekstIzvestaja","narudzbenicaId","automobilId",
												"rezervacijaId","prekoracenaKilometraza","dodatniTroskovi"})
@XmlRootElement(name = "Izvestaj")
public class Izvestaj {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "PredjenaKilometraza", required = true)
	private float predjenaKilometraza;
	@XmlElement(name = "TekstIzvestaja", required = true)
	private String tekstIzvestaja;
	@XmlElement(name = "NarudzbenicaId", required = true)
	private Long narudzbenicaId;
	@XmlElement(name = "Automobilid", required = true)
	private Long automobilId;
	@XmlElement(name = "RezervacijaId", required = true)
	private Long rezervacijaId;
	@XmlElement(name = "PrekoracenaKilometraza", required = true)
	private Long prekoracenaKilometraza;
	@XmlElement(name = "DodataniTroskovi", required = true)
	private Long dodatniTroskovi;
	
	public Izvestaj() {
		// TODO Auto-generated constructor stub
	}

	public Izvestaj(Long id, Long commonDataId, float predjenaKilometraza, String tekstIzvestaja,
			Long narudzbenicaId, Long automobilId, Long rezervacijaId, Long prekoracenaKilometraza,
			Long dodatniTroskovi) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.tekstIzvestaja = tekstIzvestaja;
		this.narudzbenicaId = narudzbenicaId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.prekoracenaKilometraza = prekoracenaKilometraza;
		this.dodatniTroskovi = dodatniTroskovi;
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

}
