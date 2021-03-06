//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 

package com.example.Messages.SchemaToJava2.model.entitet;

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
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Korisnik" type="{http://www.ftn.uns.ac.rs/AdminKlijent}common_data"/>
 *         &lt;element name="tekst_komentara">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="240"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="odobren" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "tekstKomentara",
    "odobren"
})

@XmlRootElement(name = "Komentar")
@Entity
public class Komentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "Id")
    protected Long id;
    
    @Column(name = "tekst_komentara", nullable = false)
    @XmlElement(name = "tekst_komentara", required = true)
    protected String tekstKomentara;
    
    @Column(name = "odobren")
    @XmlElement(defaultValue = "false")
    protected boolean odobren;
    
    @XmlElement(name = "Korisnik", required = true)
    @Column(name="common_data_id")
    protected Long commonDataId;
    
    @Column(name="automobil_id")
    private Long automobilId;
   
////    @Column(nullable = true)
//    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
//    private Firma firma;
//
//    //Jedan komentar se kreira od samo jednog registrovanog korisnika(druga strana bidirekcije)
//    private RegistrovaniKorisnik reg_korisnik;

    public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
    }


    public Long getCommonDataId() {
        return commonDataId;
    }


    public void setCommonDataId(Long commonDataId) {
        this.commonDataId = commonDataId;
    }
   
 
    public String getTekstKomentara() {
        return tekstKomentara;
    }


    public void setTekstKomentara(String value) {
        this.tekstKomentara = value;
    }


    public boolean isOdobren() {
        return odobren;
    }

    
    public void setOdobren(boolean value) {
        this.odobren = value;
    }

	public Long getAutomobilId() {
		return automobilId;
	}


	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	   
}