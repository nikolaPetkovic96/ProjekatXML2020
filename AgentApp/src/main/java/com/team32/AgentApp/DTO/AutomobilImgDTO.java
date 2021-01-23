package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Automobil;

public class AutomobilImgDTO {

	private Long id;
	private float ukupnaOcena;
	private float predjenaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	
	private String markaAut;
	private String modelAut;
	private String klasaAut;
	private String tipMenjaca;
	private String tipGoriva;
	private Long commonDataId;//ne treba, samo za testiranje CRUD
	
	private SlikaVozilaDTO slikeVozila;
	
	public AutomobilImgDTO() {
		
	}

	public AutomobilImgDTO(Automobil a, String markaAut , String modelAut,
			 String klasaAut, String tipMenjaca, String tipGoriva, SlikaVozilaDTO slikeVozila) {	
		this.id = a.getId();	
		this.ukupnaOcena = a.getUkupnaOcena();
		this.predjenaKilometraza = a.getPredjenaKilometraza();
		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
		
		this.commonDataId =  a.getCommonDataId();

		this.markaAut = markaAut;
		this.modelAut = modelAut;
		this.klasaAut = klasaAut;
		this.tipMenjaca = tipMenjaca;
		this.tipGoriva = tipGoriva;
		
		this.slikeVozila = slikeVozila;
	}
	
	public AutomobilImgDTO(AutomobilDTO a, SlikaVozilaDTO slikeVozila) {	
		this.id = a.getId();	
		this.ukupnaOcena = a.getUkupnaOcena();
		this.predjenaKilometraza = a.getPredjenaKilometraza();
		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
		
		this.commonDataId =  a.getCommonDataId();

		this.markaAut = a.getMarkaAut();
		this.modelAut = a.getModelAut();
		this.klasaAut = a.getKlasaAut();
		this.tipMenjaca = a.getTipMenjaca();
		this.tipGoriva = a.getTipGoriva();
		
		this.slikeVozila = slikeVozila;
	}
	
	public AutomobilImgDTO(Long id, float ukupnaOcena, float predjenaKilometraza, float planiranaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId,
			String markaAut , String modelAut, String klasaAut, String tipMenjaca, String tipGoriva, SlikaVozilaDTO slikeVozila) {
		super();
		this.id = id;
		this.ukupnaOcena = ukupnaOcena;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		
		this.commonDataId = commonDataId;
		this.markaAut = markaAut;
		this.modelAut = modelAut;
		this.klasaAut = klasaAut;
		this.tipMenjaca = tipMenjaca;
		this.tipGoriva = tipGoriva;
		
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

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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

	public SlikaVozilaDTO getSlikeVozila() {
		return slikeVozila;
	}

	public void setSlikeVozila(SlikaVozilaDTO slikeVozila) {
		this.slikeVozila = slikeVozila;
	}
	

}
