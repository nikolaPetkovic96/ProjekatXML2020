//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.team32.AgentApp.model.entitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/Automobil}TAutomobila">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Komentar" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Ocena" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Automobil", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = { "id", "commonDataId", "markaAutomobilaId","modelAutomobilaId","klasaAutomobilaId",
											"vrstaGorivaId","tipMenjaca","predjenaKilometraza","collisionDamageWaiver", 
											"brojSedistaZaDecu","ukupnaOcena"})

@XmlRootElement(name = "Automobil", namespace = "http://www.ftn.uns.ac.rs/sync")
@Entity
public class Automobil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "Id", required = true)
    protected Long id;
	
	@Column(name = "marka_aut_id", nullable = false)
	@XmlElement(name = "MarkaAutomobilaId", required = true)
    protected Long markaAutomobilaId;
    
	@Column(name = "model_aut_id", nullable = false)
	@XmlElement(name = "ModelutomobilaId", required = true)
    protected Long modelAutomobilaId;
    
	@Column(name = "klasa_aut_id", nullable = false)
	@XmlElement(name = "KlasaAutomobilaId", required = true)
    protected Long klasaAutomobilaId;

	@Column(name = "tip_goriva_id", nullable = false)
	@XmlElement(name = "VrstaGorivaId", required = true)
    protected Long tipGorivaId;
    
	@Column(name = "tip_menjaca_id", nullable = false)
	@XmlElement(name = "TipMenjacaId", required = true)
    protected Long tipMenjacaId;
    
	@Column(name = "predj_kilom", nullable = false)
	@XmlElement(name = "PredjenaKilometraza", required = true)
    protected float predjenaKilometraza;
	
	@Column(name = "ukupna_ocena", nullable = false)
	@XmlElement(name = "UkupnaOcena", required = true)
    protected float ukupnaOcena;
    
	@Column(name = "col_dmg_waiver", nullable = false)
	@XmlElement(name = "CollisionDamageWaiver", required = true)
    protected boolean collisionDamageWaiver;
    
	@Column(name = "br_sedista_za_decu", nullable = false)
	@XmlElement(name = "BrojSedistaZaDecu", required = true)
    protected int brojSedistaZaDecu;
	
	@Column(name="common_data_id", nullable = false)
	@XmlElement(name = "CommonDataId", required = true)
    private Long commonDataId;
  

	public Automobil() {
		super();
	}


	public Automobil(Long id, Long markaAutomobilaId,Long modelAutomobilaId,
			Long klasaAutomobilaId, Long tipGorivaId,Long tipMenjacaId, float predjenaKilometraza, float ukupnaOcena, boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId) {
		super();
		this.id = id;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.tipGorivaId = tipGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.ukupnaOcena = ukupnaOcena;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.commonDataId = commonDataId;
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


	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}


	public float getUkupnaOcena() {
		return ukupnaOcena;
	}


	public void setUkupnaOcena(float ukupnaOcena) {
		this.ukupnaOcena = ukupnaOcena;
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
