package com.example.Oglas.dto;

import com.example.Oglas.model.Automobil;

public class AutomobilDTO {

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
	private Long commonDataId;//ne treba samo za testiranje CRUD
	
	public AutomobilDTO() {
		
	}

	public AutomobilDTO(Automobil a, String markaAut , String modelAut,
			 String klasaAut, String tipMenjaca, String tipGoriva) {	
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
	}
	
	public AutomobilDTO(Long id, float ukupnaOcena, float predjenaKilometraza, float planiranaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId,
			String markaAut , String modelAut, String klasaAut, String tipMenjaca, String tipGoriva) {
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

}
