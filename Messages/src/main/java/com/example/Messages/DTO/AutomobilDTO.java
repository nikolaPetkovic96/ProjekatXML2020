package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Automobil;


public class AutomobilDTO {

	private Long id;
	private Long markaAutomobilaId;
	private Long modelAutomobilaId;
	private Long klasaAutomobilaId;
	private Long vrstaGorivaId;
	private Long tipMenjacaId;
	private float predjenaKilometraza;
	private float planiranaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	
	public AutomobilDTO() {
		
	}
	
	public AutomobilDTO(Long id, Long markaAutomobilaId, Long modelAutomobilaId,
			Long klasaAutomobilaId, Long vrstaGorivaId, Long tipMenjacaId, float predjenaKilometraza,
			float planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu) {
		super();
		this.id = id;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.vrstaGorivaId = vrstaGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.planiranaKilometraza = planiranaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}

	public AutomobilDTO(Automobil a) {	
		this.id = a.getId();	
		this.markaAutomobilaId = a.getMarkaAutomobilaId();
		this.modelAutomobilaId = a.getModelAutomobilaId();
		this.klasaAutomobilaId = a.getKlasaAutomobilaId();
		this.vrstaGorivaId = a.getVrstaGorivaId();
		this.tipMenjacaId = a.getTipMenjacaId();
		this.predjenaKilometraza = a.getPredjenaKilometraza();
		this.planiranaKilometraza = a.getPlaniranaKilometraza();
		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
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

	public Long getVrstaGorivaId() {
		return vrstaGorivaId;
	}

	public void setVrstaGorivaId(Long vrstaGorivaId) {
		this.vrstaGorivaId = vrstaGorivaId;
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

	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}

	public float getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}

	public void setPlaniranaKilometraza(float planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
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
	
	
}
