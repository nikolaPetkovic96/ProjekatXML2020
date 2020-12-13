package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Automobil;

public class AutomobilNewDTO {

	private Long id;
	private Long markaAutomobilaId;
	private Long modelAutomobilaId;
	private Long klasaAutomobilaId;
	private Long tipGorivaId;
	private Long tipMenjacaId;
	private float ukupnaOcena;
	private float predjenaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	
	private Long commonDataId;//ne treba samo za testiranje CRUD
	
	public AutomobilNewDTO() {
		
	}
	
	public AutomobilNewDTO(Long id, Long markaAutomobilaId, Long modelAutomobilaId,
			Long klasaAutomobilaId, Long tipGorivaId, Long tipMenjacaId, float ukupnaOcena, float predjenaKilometraza,
			float planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId) {
		super();
		this.id = id;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.tipGorivaId = tipGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.ukupnaOcena = ukupnaOcena;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		
		this.commonDataId = commonDataId;
	}

	public AutomobilNewDTO(Automobil a) {	
		this.id = a.getId();	
		this.markaAutomobilaId = a.getMarkaAutomobilaId();
		this.modelAutomobilaId = a.getModelAutomobilaId();
		this.klasaAutomobilaId = a.getKlasaAutomobilaId();
		this.tipGorivaId = a.getTipGorivaId();
		this.tipMenjacaId = a.getTipMenjacaId();
		this.ukupnaOcena = a.getUkupnaOcena();
		this.predjenaKilometraza = a.getPredjenaKilometraza();
		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
		
		this.commonDataId =  a.getCommonDataId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMarkaAutomobilaId() {
		return markaAutomobilaId;
	}

	public void setMarkaAutomobilaId(Long markaAutomobilaId) {
		this.markaAutomobilaId = markaAutomobilaId;
	}

	public Long getModelAutomobilaId() {
		return modelAutomobilaId;
	}

	public void setModelAutomobilaId(Long modelAutomobilaId) {
		this.modelAutomobilaId = modelAutomobilaId;
	}

	public Long getKlasaAutomobilaId() {
		return klasaAutomobilaId;
	}

	public void setKlasaAutomobilaId(Long klasaAutomobilaId) {
		this.klasaAutomobilaId = klasaAutomobilaId;
	}

	public Long getTipGorivaId() {
		return tipGorivaId;
	}

	public void setTipGorivaId(Long tipGorivaId) {
		this.tipGorivaId = tipGorivaId;
	}

	public Long getTipMenjacaId() {
		return tipMenjacaId;
	}

	public void setTipMenjacaId(Long tipMenjacaId) {
		this.tipMenjacaId = tipMenjacaId;
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
	
	
	
}
