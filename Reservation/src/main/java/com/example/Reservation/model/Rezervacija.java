//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Reservation.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.persistence.JoinColumn;
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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/KreiranjeOglasa}Oglas" maxOccurs="unbounded"/>
 *         &lt;element name="Korisnik" type="{http://www.ftn.uns.ac.rs/korisnici}TUser"/>
 *         &lt;element name="Ukupna_cena" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Od_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Do_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Bundle" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Status_rezervacije">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="PENDING|RESERVED|PAID|CANCELED"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Poruka" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "oglas",
    "korisnik",
    "ukupnaCena",
    "odDatuma",
    "doDatuma",
    "bundle",
    "statusRezervacije",
    "poruka"
})
@XmlRootElement(name = "Rezervacija", namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
@Entity 
public class Rezervacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
    protected Long id;
    
    @Column(name="ukupna_cena")
    @XmlElement(name = "Ukupna_cena", namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
    protected double ukupnaCena;
    
    @Column(name="bundle")
    @XmlElement(name = "Bundle", namespace = "http://www.ftn.uns.ac.rs/Rezervacija")
    protected Boolean bundle;
    
    @Column(name="status_rezerv")
    @XmlElement(name = "Status_rezervacije", namespace = "http://www.ftn.uns.ac.rs/Rezervacija", required = true, defaultValue = "PENDING")
    protected String statusRezervacije;
    
    //Jedna rezervacija se odnosi samo na jednog korisnika(druga strana bidirekcije)
    @XmlElement(name = "Korisnik", namespace = "http://www.ftn.uns.ac.rs/Rezervacija", required = true)
    @Column(name="commonDataId")
    protected Long commonDataId;
    
    @Column(name="napomena")
	private String napomena;

    
    
    
	//   @XmlElement(name = "Korisnik", namespace = "http://www.ftn.uns.ac.rs/Rezervacija", required = true)
	//   protected TUser firma; obrsati 
    
	//    @ManyToMany(mappedBy="rezervacije")
	//    @XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
	//    protected List<Oglas> oglas;
	//    protected List<Poruka> poruka;
    
//    @ManyToMany
//	@JoinTable(
//	  name = "rezervacije_oglasi", 
//	  joinColumns = @JoinColumn(name = "rezervacija_id"), 
//	  inverseJoinColumns = @JoinColumn(name = "oglas_id"))
//    protected List<Oglas> oglasi;
    

	public Rezervacija() {
		super();
	}

	public Rezervacija(Long id, double ukupnaCena,  Boolean bundle,
			String statusRezervacije,String napomena, Long commonDataId) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.commonDataId = commonDataId;
		this.napomena=napomena;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Boolean getBundle() {
		return bundle;
	}

	public void setBundle(Boolean bundle) {
		this.bundle = bundle;
	}

	public String getStatusRezervacije() {
		return statusRezervacije;
	}

	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

//	public List<Oglas> getOglasi() {
//		return oglasi;
//	}
//
//	public void setOglasi(List<Oglas> oglasi) {
//		this.oglasi = oglasi;
//	}

}