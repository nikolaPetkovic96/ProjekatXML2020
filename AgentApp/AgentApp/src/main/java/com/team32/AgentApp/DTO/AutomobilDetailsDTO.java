package com.team32.AgentApp.DTO;

import java.util.List;


public class AutomobilDetailsDTO {
	
	private Long id;
	private float ukupnaOcena;;
	private float predjenaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	
	private String markaAut;
	private String modelAut;
	private String klasaAut;
	private String tipMenjaca;
	private String tipGoriva;
	
	
	private SlikaVozilaDTO slikeVozila;
	private List<ReviewDTO> reviews;
	
	public AutomobilDetailsDTO() {
		
	}

	public AutomobilDetailsDTO(AutomobilDTO dto, List<ReviewDTO> reviews, SlikaVozilaDTO slikeVozila) {	
		this.id = dto.getId();	
		this.ukupnaOcena = dto.getUkupnaOcena();
		this.predjenaKilometraza = dto.getPredjenaKilometraza();
		this.collisionDamageWaiver = dto.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = dto.getBrojSedistaZaDecu();

		this.markaAut = dto.getMarkaAut();
		this.modelAut = dto.getModelAut();
		this.klasaAut = dto.getKlasaAut();
		this.tipMenjaca = dto.getTipMenjaca();
		this.tipGoriva = dto.getTipGoriva();
		this.reviews = reviews;
		
		this.slikeVozila = slikeVozila;
	}
	
	public AutomobilDetailsDTO(Long id, float ukupnaOcena, float predjenaKilometraza, float planiranaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu,
			String markaAut , String modelAut, String klasaAut, String tipMenjaca, String tipGoriva, List<ReviewDTO> reviews, SlikaVozilaDTO slikeVozila) {
		super();
		this.id = id;
		this.ukupnaOcena = ukupnaOcena;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		
		this.markaAut = markaAut;
		this.modelAut = modelAut;
		this.klasaAut = klasaAut;
		this.tipMenjaca = tipMenjaca;
		this.tipGoriva = tipGoriva;
		this.reviews = reviews;
		
		this.slikeVozila = slikeVozila;
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
	
	public float getUkupnaOcena() {
		return ukupnaOcena;
	}

	public void setUkupnaOcena(float ukupnaOcena) {
		this.ukupnaOcena = ukupnaOcena;
	}

	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}

	public boolean isCollisionDamageWaiver() {
		return collisionDamageWaiver;
	}

	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
		this.collisionDamageWaiver = collisionDamageWaiver;
	}

	public int getBrojSedistaZaDecu() {
		return brojSedistaZaDecu;
	}

	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}

	public String getMarkaAut() {
		return markaAut;
	}

	public void setMarkaAut(String markaAut) {
		this.markaAut = markaAut;
	}

	public String getModelAut() {
		return modelAut;
	}

	public void setModelAut(String modelAut) {
		this.modelAut = modelAut;
	}

	public String getKlasaAut() {
		return klasaAut;
	}

	public void setKlasaAut(String klasaAut) {
		this.klasaAut = klasaAut;
	}

	public String getTipMenjaca() {
		return tipMenjaca;
	}

	public void setTipMenjaca(String tipMenjaca) {
		this.tipMenjaca = tipMenjaca;
	}

	public String getTipGoriva() {
		return tipGoriva;
	}

	public void setTipGoriva(String tipGoriva) {
		this.tipGoriva = tipGoriva;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	public SlikaVozilaDTO getSlikeVozila() {
		return slikeVozila;
	}

	public void setSlikeVozila(SlikaVozilaDTO slikeVozila) {
		this.slikeVozila = slikeVozila;
	}
	
	

}
