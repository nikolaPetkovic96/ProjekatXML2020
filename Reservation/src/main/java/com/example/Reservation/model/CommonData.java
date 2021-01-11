//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//

package com.example.Reservation.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for common_data complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="common_data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Datum_kreiranja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Datum_izmene" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Korisnik" type="{http://www.ftn.uns.ac.rs/korisnici}TUser"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "common_data", namespace = "http://www.ftn.uns.ac.rs/AdminKlijent", propOrder = { "datumKreiranja",
		"datumIzmene", "korisnik" })
@Entity
public class CommonData {

	@Id
	@XmlElement(namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "datum_kreiranja", nullable = false)
	@XmlElement(name = "Datum_kreiranja", required = true)
	@XmlSchemaType(name = "dateTime")
	protected LocalDateTime datumKreiranja;

	@Column(name = "datum_izmene")
	@XmlElement(name = "Datum_izmene", required = true)
	@XmlSchemaType(name = "dateTime")
	protected LocalDateTime datumIzmene;

	// Jedna promena(commonData) se odnosi na samo jednog korisnika
	@XmlElement(name = "Korisnik", required = true)
	@Column(name = "korisnik_id")
	protected Long userId;
	

	public CommonData() {
		super();
	}
	

	public CommonData(Long id, LocalDateTime datumKreiranja, LocalDateTime datumIzmene, Long userId) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.userId = userId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime  getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime  value) {
		this.datumKreiranja = value;
	}

	public LocalDateTime  getDatumIzmene() {
		return datumIzmene;
	}

	public void setDatumIzmene(LocalDateTime  value) {
		this.datumIzmene = value;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
