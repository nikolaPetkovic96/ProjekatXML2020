////
//// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
//// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//// Any modifications to this file will be lost upon recompilation of the source schema. 
//// Generated on: 2020.06.02 at 07:25:52 PM CEST 
////
//
//
//package com.example.Messages.SchemaToJava2.model.entitet;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.*;
//import javax.persistence.ManyToOne;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlSchemaType;
//import javax.xml.bind.annotation.XmlType;
//
////import com.example.Messages.SchemaToJava2.model.user.Firma;
////import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;
//
//
///**
// * <p>Java class for anonymous complex type.
// * 
// * <p>The following schema fragment specifies the expected content contained within this class.
// * 
// * <pre>
// * &lt;complexType>
// *   &lt;complexContent>
// *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
// *       &lt;sequence>
// *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
// *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Automobil"/>
// *         &lt;element name="Od_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
// *         &lt;element name="Do_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
// *         &lt;element ref="{http://www.ftn.uns.ac.rs/cenovnik}Cenovnik"/>
// *       &lt;/sequence>
// *     &lt;/restriction>
// *   &lt;/complexContent>
// * &lt;/complexType>
// * </pre>
// * 
// * 
// */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//    "id",
//    "automobil",
//    "odDatuma",
//    "doDatuma",
//    "cenovnik"
//})
//@XmlRootElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa")
////@Entity 
//public class Oglas {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa")
//    protected Long id;
//    
//    //Jedan oglas se kreira za samo jedan automobil(druga strana bidirekcije)
//    @XmlElement(name = "Automobil", required = true)
//    protected Automobil automobil;
//    
//    
//    @XmlElement(name = "Od_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
//    @XmlSchemaType(name = "dateTime")
//    protected Date odDatuma;
//    
//    
//    @XmlElement(name = "Do_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
//    @XmlSchemaType(name = "dateTime")
//    protected Date doDatuma;
//    
//    //Jedan oglas se kreira sa samo jednim cenovnikom(druga strana bidirekcije)w
//    @XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
//    protected Cenovnik cenovnik;
//    
//    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
//    private Firma firma;
//   
//    private List<Rezervacija> rezervacije;
//
//    //Jedan oglas se kreira od samo jednog registrovanog korisnika(druga strana bidirekcije)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private RegistrovaniKorisnik reg_korisnik;
//
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
//    public Automobil getAutomobil() {
//        return automobil;
//    }
//
//
//    public void setAutomobil(Automobil value) {
//        this.automobil = value;
//    }
//
//
//    public Date getOdDatuma() {
//        return odDatuma;
//    }
//
//
//    public void setOdDatuma(Date value) {
//        this.odDatuma = value;
//    }
//
//    
//    public Date getDoDatuma() {
//        return doDatuma;
//    }
//
//
//    public void setDoDatuma(Date value) {
//        this.doDatuma = value;
//    }
//
//
//    public Cenovnik getCenovnik() {
//        return cenovnik;
//    }
//
//
//    public void setCenovnik(Cenovnik value) {
//        this.cenovnik = value;
//    }
//
//	public Firma getFirma() {
//		return firma;
//	}
//
//	public void setFirma(Firma firma) {
//		this.firma = firma;
//	}
//
//
//	public List<Rezervacija> getRezervacije() {
//		return rezervacije;
//	}
//
//
//	public void setRezervacije(List<Rezervacija> rezervacije) {
//		this.rezervacije = rezervacije;
//	}
//
//}
