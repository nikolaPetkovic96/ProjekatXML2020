//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.entitet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "cenaPoDanu",
    "nazivCenovnika",
    "popustZaPreko30Dana",
    "cenaCollisionDamageWaiver",
    "cenaPoKilometru"
})

@XmlRootElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//@Entity
public class Cenovnik {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//    protected Long id;
//	
//	@Column(name = "cena_po_danu", nullable = false)
//    @XmlElement(name = "CenaPoDanu", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//    protected int cenaPoDanu;
//    
//	@Column(name = "naziv_cenovnika", nullable = false)
//    @XmlElement(name = "Naziv_cenovnika", namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
//    protected String nazivCenovnika;
//    
//	@Column(name = "popust30", nullable = false)
//    @XmlElement(name = "PopustZaPreko30Dana", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//    protected int popustZaPreko30Dana;
//    
//	@Column(name = "cenaColDmgeWaiver", nullable = false)
//    @XmlElement(name = "CenaCollisionDamageWaiver", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//    protected Integer cenaCollisionDamageWaiver;
//    
//	@Column(name = "cena_km", nullable = false)
//    @XmlElement(name = "CenaPoKilometru", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
//    protected Integer cenaPoKilometru;
//
//	//Jedan oglas moze da ima vise cenovnika (u tabeli cenovnik se cuva id oglasa)
//	@OneToMany(mappedBy="cenovnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Oglas> oglasi;
//	
//    public Long getId() {
//        return id;
//    }
//
//
//    public void setId(Long value) {
//        this.id = value;
//    }
//
//
//    public int getCenaPoDanu() {
//        return cenaPoDanu;
//    }
//
//
//    public void setCenaPoDanu(int value) {
//        this.cenaPoDanu = value;
//    }
//
//
//    public String getNazivCenovnika() {
//        return nazivCenovnika;
//    }
//
//
//    public void setNazivCenovnika(String value) {
//        this.nazivCenovnika = value;
//    }
//
//
//    public int getPopustZaPreko30Dana() {
//        return popustZaPreko30Dana;
//    }
//
//
//    public void setPopustZaPreko30Dana(int value) {
//        this.popustZaPreko30Dana = value;
//    }
//
//
//    public Integer getCenaCollisionDamageWaiver() {
//        return cenaCollisionDamageWaiver;
//    }
//
//
//    public void setCenaCollisionDamageWaiver(Integer value) {
//        this.cenaCollisionDamageWaiver = value;
//    }
//
//
//    public Integer getCenaPoKilometru() {
//        return cenaPoKilometru;
//    }
//
//
//    public void setCenaPoKilometru(Integer value) {
//        this.cenaPoKilometru = value;
//    }
//
//
//	public List<Oglas> getOglasi() {
//		return oglasi;
//	}
//
//
//	public void setOglasi(List<Oglas> oglasi) {
//		this.oglasi = oglasi;
//	}

    
}
