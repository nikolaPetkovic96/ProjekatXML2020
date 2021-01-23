//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//

package com.example.commentandrating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "komentar",
    "ocena"
})

@XmlRootElement(name = "Automobil")
@Entity
public class Automobil {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
    @XmlElement(name = "Marka_automobila", required = true)
    protected Long markaAutomobilaId;
    
    @XmlElement(name = "Model_automobila", required = true)
    protected Long modelAutomobilaId;
    
    @XmlElement(name = "Klasa_automobila", required = true)
    protected Long klasaAutomobilaId;

    @XmlElement(name = "Vrsta_goriva", required = true)
    protected Long vrstaGorivaId;
    
    @XmlElement(name = "Tip_menjaca", required = true)
    protected Long tipMenjacaId;
    
	@Column(name = "predj_kilom", nullable = false)
    @XmlElement(name = "Predjena_kilometraza")
    protected float predjenaKilometraza;
    
    
	@Column(name = "col_dmg_waiver", nullable = false)
    @XmlElement(name = "Collision_Damage_Waiver")
    protected boolean collisionDamageWaiver;
    
	@Column(name = "br_sedista_za_decu", nullable = false)
    @XmlElement(name = "Broj_sedista_za_decu")
    protected int brojSedistaZaDecu;

	@Column(name = "common_data_id", nullable = false)
	protected Long commonDataId;
	
	@Column(name = "ukupna_ocena", nullable = false)
	private float ukupnaOcena;
	
//	private String agentUsername;
	
	public Automobil() {
		super();
	}

	public Automobil(Long id, Long markaAutomobilaId,Long modelAutomobilaId,
			Long klasaAutomobilaId, Long vrstaGorivaId,Long tipMenjacaId, float predjenaKilometraza,
			float ukupnaOcena, boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId) {
		super();
		this.id = id;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.vrstaGorivaId = vrstaGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.commonDataId=commonDataId;
		this.ukupnaOcena = ukupnaOcena;
	}

    public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
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


	public Long getCommonDataId() {
		return commonDataId;
	}


	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
	public float getUkupnaOcena() {
		return ukupnaOcena;
	}


	public void setUkupnaOcena(float ukupnaOcena) {
		this.ukupnaOcena = ukupnaOcena;
	}
	
	
}