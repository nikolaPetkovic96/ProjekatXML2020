//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.user;

import java.util.ArrayList;
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

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/korisnici}TUser">
 *       &lt;sequence>
 *         &lt;element name="Ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMBG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Komentar" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Ocena" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Poruka" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Rezervacija}Rezervacija" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/KreiranjeOglasa}Oglas" maxOccurs="3"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ime",
    "jmbg",
    "prezime",
    "komentar",
    "ocena",
    "poruka",
//    "rezervacija",
    "oglas"
})
@XmlRootElement(name = "Registrovani_korisnik", namespace = "http://www.ftn.uns.ac.rs/korisnici")
@Entity
public class RegistrovaniKorisnik
//    extends TUser

{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@Column(name = "ime", nullable = false)
    @XmlElement(name = "Ime", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
    protected String ime;
    
    @Column(name = "prezime", nullable = false)
    @XmlElement(name = "Prezime", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
    protected String prezime;
    
	@Column(name = "jmbg", nullable = false)
    @XmlElement(name = "JMBG", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
    protected String jmbg;
	
	@OneToMany(mappedBy="reg_korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Komentar", required = true)
    protected List<Komentar> komentar;
    
	@OneToMany(mappedBy="reg_korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Ocena", required = true)
    protected List<Ocena> ocena;
    
	@OneToMany(mappedBy="reg_korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Poruka", required = true)
    protected List<Poruka> poruka;
    
//	@OneToMany(mappedBy="reg_korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @XmlElement(name = "Rezervacija", namespace = "http://www.ftn.uns.ac.rs/Rezervacija", required = true)
//    protected List<Rezervacija> rezervacija;
    
	
	
	@OneToMany(mappedBy="reg_korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
    protected List<Oglas> oglas;

  
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIme() {
        return ime;
    }

   
    public void setIme(String value) {
        this.ime = value;
    }

  
    public String getJMBG() {
        return jmbg;
    }

  
    public void setJMBG(String value) {
        this.jmbg = value;
    }

 
    public String getPrezime() {
        return prezime;
    }

  
    public void setPrezime(String value) {
        this.prezime = value;
    }

   
    public List<Komentar> getKomentar() {
        if (komentar == null) {
            komentar = new ArrayList<Komentar>();
        }
        return this.komentar;
    }

  
    public List<Ocena> getOcena() {
        if (ocena == null) {
            ocena = new ArrayList<Ocena>();
        }
        return this.ocena;
    }

  
    public List<Poruka> getPoruka() {
        if (poruka == null) {
            poruka = new ArrayList<Poruka>();
        }
        return this.poruka;
    }

//  
//    public List<Rezervacija> getRezervacija() {
//        if (rezervacija == null) {
//            rezervacija = new ArrayList<Rezervacija>();
//        }
//        return this.rezervacija;
//    }

   
    public List<Oglas> getOglas() {
        if (oglas == null) {
            oglas = new ArrayList<Oglas>();
        }
        return this.oglas;
    }

}
