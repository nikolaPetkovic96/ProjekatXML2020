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
 *         &lt;element name="Korisnik" type="{http://www.ftn.uns.ac.rs/AdminKlijent}common_data"/>
 *         &lt;element name="Tekst_poruke">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="480"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Poruka", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = {
		"id", "commonDataId", "tekstPoruke","rezervacijaId","automobilId" 
})
@XmlRootElement(name = "Poruka", namespace = "http://www.ftn.uns.ac.rs/sync")
@Entity
public class Poruka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "Id", required = true)
    protected Long id;
    
	@Column(name = "tekst_poruke", nullable = false)
	@XmlElement(name = "TekstPoruke", required = true)
    protected String tekstPoruke;

    //Jedan komentar se odnosi na samo jedan automobil(druga strana bidirekcije)
    @Column(name = "automobil_id", nullable = false)
    @XmlElement(name = "AutomobilId", required = true)
    private Long automobilId;
    
    //Jedna poruka se odnosi samo na jednu rezervaciju(druga strana bidirekcije))	
	@Column(name = "rezervacija_id", nullable = false)
	@XmlElement(name = "RezervacijaId", required = true)
    private Long rezervacijaId;
    
	@XmlElement(name = "CommonDataId", required = true)
    @Column(name = "common_data_id", nullable = false)
    protected Long commonDataId;
    
	public Poruka() {
		super();
	}
	

	public Poruka(Long id, String tekstPoruke, Long rezervacijaId, Long automobilId, Long commonDataId) {
		super();
		this.id = id;
		this.tekstPoruke = tekstPoruke;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTekstPoruke() {
		return tekstPoruke;
	}

	public void setTekstPoruke(String tekstPoruke) {
		this.tekstPoruke = tekstPoruke;
	}

	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
   
}