package com.example.sync.dto.automobil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Automobil", propOrder = { "id", "commonDataId", "markaAutomobilaId","modelAutomobilaId","klasaAutomobilaId",
											"vrstaGorivaId","tipMenjacaId","predjenaKilometraza","collisionDamageWaiver", 
											"brojSedistaZaDecu","ukupnaOcena"})
@XmlRootElement(name = "Automobil")
public class Automobil {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	@XmlElement(name = "MarkaAutomobilaId", required = true)
    protected Long markaAutomobilaId;
	@XmlElement(name = "ModelAutomobilaId", required = true)
    protected Long modelAutomobilaId;
	@XmlElement(name = "KlasaAutomobilaId", required = true)
    protected Long klasaAutomobilaId;
	@XmlElement(name = "VrstaGorivaId", required = true)
    protected Long vrstaGorivaId;
	@XmlElement(name = "TipMenjacaId", required = true)
    protected Long tipMenjacaId;
	@XmlElement(name = "PredjenaKilometraza", required = true)
    protected float predjenaKilometraza;
	@XmlElement(name = "CollisionDamageWaiver", required = true)
    protected boolean collisionDamageWaiver;
	@XmlElement(name = "BrojSedistaZaDecu", required = true)
    protected int brojSedistaZaDecu;
	@XmlElement(name = "UkupnaOcena", required = true)
	private float ukupnaOcena;

	public Automobil() {
	}

	public Automobil(Long id, Long commonDataId, Long markaAutomobilaId, Long modelAutomobilaId,
			Long klasaAutomobilaId, Long vrstaGorivaId, Long tipMenjacaId, float predjenaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu, float ukupnaOcena) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.vrstaGorivaId = vrstaGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.ukupnaOcena = ukupnaOcena;
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

	public float getUkupnaOcena() {
		return ukupnaOcena;
	}

	public void setUkupnaOcena(float ukupnaOcena) {
		this.ukupnaOcena = ukupnaOcena;
	}

}
