//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.entitet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.example.Messages.SchemaToJava2.model.user.Firma;


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
@XmlType(name = "", propOrder = {
    "id",
    "korisnik",
    "tekstPoruke"
})
@XmlRootElement(name = "Poruka")
@Entity
public class Poruka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @XmlElement(name = "Korisnik", required = true)
    protected CommonData commonData;
    
	@Column(name = "tekst_poruke", nullable = false)
    @XmlElement(name = "Tekst_poruke", required = true)
    protected String tekstPoruke;
    
    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Firma firma;
    
  //Jedna poruka se odnosi samo na jednu rezervaciju(druga strana bidirekcije)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Rezervacija rezervacija;


    public long getId() {
        return id;
    }


    public void setId(long value) {
        this.id = value;
    }


    public CommonData getCommonData() {
        return commonData;
    }


    public void setCommonData(CommonData value) {
        this.commonData = value;
    }


    public String getTekstPoruke() {
        return tekstPoruke;
    }


    public void setTekstPoruke(String value) {
        this.tekstPoruke = value;
    }


	public Firma getFirma() {
		return firma;
	}


	public void setFirma(Firma firma) {
		this.firma = firma;
	}


	public Rezervacija getRezervacija() {
		return rezervacija;
	}


	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
    
    

}
