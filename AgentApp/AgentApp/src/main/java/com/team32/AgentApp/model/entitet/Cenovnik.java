////
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

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CenaPoDanu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Naziv_cenovnika" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PopustZaPreko30Dana" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CenaCollisionDamageWaiver" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CenaPoKilometru" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/**
 * @author Maregenije
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/sync" , propOrder = {
		"id",
		"commonDataId" ,
		"cenaPoDanu",
		"nazivCenovnika" ,
		"popustZaPreko30Dana" ,
		"cenaCollisionDamageWaiver" ,
		"cenaPoKilometru" })

@XmlRootElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/sync")
@Entity
public class Cenovnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "Id", required = true)
    protected Long id;
	
	@Column(name = "naziv_cenovnika", nullable = false)
	@XmlElement(name = "NazivCenovnika", required = true)
    protected String nazivCenovnika;
	
	@Column(name = "cena_po_danu", nullable = false)
    @XmlElement(name = "CenaPoDanu", required = true)
    protected float cenaPoDanu;
    
	@Column(name = "popust_30_dan", nullable = false)
	@XmlElement(name = "PopustZaPreko30Dana", required = true)
    protected float popustZaPreko30Dana;
    
	@Column(name = "cenaColDmgeWaiver", nullable = false)
	@XmlElement(name = "CenaCollisionDamageWaiver", required = true)
    protected float cenaCollisionDamageWaiver;
    
	@Column(name = "cena_po_km", nullable = false)
	@XmlElement(name = "CenaPoKilometru", required = true)
    protected float cenaPoKilometru;
	
	@Column(name="common_data_id", nullable = false)
	@XmlElement(name = "CommonDataId", required = true)
	private Long commonDataId;
	
    public Cenovnik() {
		super();
	}

	public Cenovnik(Long id, String nazivCenovnika, float cenaPoDanu, float popustZaPreko30Dana,
			float cenaCollisionDamageWaiver, float cenaPoKilometru, Long commonDataId) {
		super();
		this.id = id;
		this.nazivCenovnika = nazivCenovnika;
		this.cenaPoDanu = cenaPoDanu;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivCenovnika() {
		return nazivCenovnika;
	}

	public void setNazivCenovnika(String nazivCenovnika) {
		this.nazivCenovnika = nazivCenovnika;
	}

	public float getCenaPoDanu() {
		return cenaPoDanu;
	}

	public void setCenaPoDanu(float cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public float getPopustZaPreko30Dana() {
		return popustZaPreko30Dana;
	}

	public void setPopustZaPreko30Dana(float popustZaPreko30Dana) {
		this.popustZaPreko30Dana = popustZaPreko30Dana;
	}

	public float getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}

	public void setCenaCollisionDamageWaiver(float cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}

	public float getCenaPoKilometru() {
		return cenaPoKilometru;
	}

	public void setCenaPoKilometru(float cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
  
}
