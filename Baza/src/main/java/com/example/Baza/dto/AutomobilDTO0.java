package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class AutomobilDTO0 {
	
	private Long id;
	private Long markaId;
	private Long modelId;
	private Long klasaId;
	private Long vrstaGorivaId;
	private Long tipMenjacaId;
	private Long predjenaKm;
	private boolean collisionDamageWaiver;
	private int brSedistaZaDecu;
	private Long commonDataId;	
	
	public AutomobilDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AutomobilDTO0(Long id, Long markaId, Long modelId, Long klasaId, Long vrstaGorivaId, Long tipMenjacaId,
			Long predjenaKm, boolean collisionDamageWaiver, int brSedistaZaDecu, Long commonDataId) {
		super();
		this.id = id;
		this.markaId = markaId;
		this.modelId = modelId;
		this.klasaId = klasaId;
		this.vrstaGorivaId = vrstaGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKm = predjenaKm;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brSedistaZaDecu = brSedistaZaDecu;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMarkaId() {
		return markaId;
	}
	public void setMarkaId(Long markaId) {
		this.markaId = markaId;
	}
	public Long getModelId() {
		return modelId;
	}
	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public Long getKlasaId() {
		return klasaId;
	}
	public void setKlasaId(Long klasaId) {
		this.klasaId = klasaId;
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
	public Long getPredjenaKm() {
		return predjenaKm;
	}
	public void setPredjenaKm(Long predjenaKm) {
		this.predjenaKm = predjenaKm;
	}
	public boolean isCollisionDamageWaiver() {
		return collisionDamageWaiver;
	}
	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
		this.collisionDamageWaiver = collisionDamageWaiver;
	}
	public int getBrSedistaZaDecu() {
		return brSedistaZaDecu;
	}
	public void setBrSedistaZaDecu(int brSedistaZaDecu) {
		this.brSedistaZaDecu = brSedistaZaDecu;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}	
}
