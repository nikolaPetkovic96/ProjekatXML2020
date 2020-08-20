//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
//import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
//import com.example.Messages.SchemaToJava2.model.entitet.Poruka;


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
 *         &lt;element name="Prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JMBG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Komentar" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/KreiranjeOglasa}Oglas" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Poruka" maxOccurs="unbounded"/>
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
    "prezime",
    "jmbg",
    "komentar",
    "oglas",
    "poruka"
})
@XmlRootElement(name = "Agent", namespace = "http://www.ftn.uns.ac.rs/korisnici")
//@Entity
public class Agent {
//    extends TUser
//{
//
////	@Column(name = "role")
////	private static final String role = "agent";
//	
////	@Column(name = "ime", nullable = false)
//    @XmlElement(name = "Ime", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
//    protected String ime;
//    
////	@Column(name = "prezime", nullable = false)
//    @XmlElement(name = "Prezime", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
//    protected String prezime;
//    
////	@Column(name = "jmbg", nullable = false)
//    @XmlElement(name = "JMBG", namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
//    protected String jmbg;
//    
////    @XmlElement(name = "Komentar", required = true)
//    protected List<Komentar> komentar;
//    
////    @XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
//    protected List<Oglas> oglas;
//    
////    @XmlElement(name = "Poruka", required = true)
//    protected List<Poruka> poruka;
//
//    /**
//     * Gets the value of the ime property.
//     * 
//     * @return
//     *     possible object is
//     *     {@link String }
//     *     
//     */
//    public String getIme() {
//        return ime;
//    }
//
//    /**
//     * Sets the value of the ime property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *     
//     */
//    public void setIme(String value) {
//        this.ime = value;
//    }
//
//    /**
//     * Gets the value of the prezime property.
//     * 
//     * @return
//     *     possible object is
//     *     {@link String }
//     *     
//     */
//    public String getPrezime() {
//        return prezime;
//    }
//
//    /**
//     * Sets the value of the prezime property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *     
//     */
//    public void setPrezime(String value) {
//        this.prezime = value;
//    }
//
//    /**
//     * Gets the value of the jmbg property.
//     * 
//     * @return
//     *     possible object is
//     *     {@link String }
//     *     
//     */
//    public String getJMBG() {
//        return jmbg;
//    }
//
//    /**
//     * Sets the value of the jmbg property.
//     * 
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *     
//     */
//    public void setJMBG(String value) {
//        this.jmbg = value;
//    }
//
//    /**
//     * Gets the value of the komentar property.
//     * 
//     * <p>
//     * This accessor method returns a reference to the live list,
//     * not a snapshot. Therefore any modification you make to the
//     * returned list will be present inside the JAXB object.
//     * This is why there is not a <CODE>set</CODE> method for the komentar property.
//     * 
//     * <p>
//     * For example, to add a new item, do as follows:
//     * <pre>
//     *    getKomentar().add(newItem);
//     * </pre>
//     * 
//     * 
//     * <p>
//     * Objects of the following type(s) are allowed in the list
//     * {@link Komentar }
//     * 
//     * 
//     */
//    public List<Komentar> getKomentar() {
//        if (komentar == null) {
//            komentar = new ArrayList<Komentar>();
//        }
//        return this.komentar;
//    }
//
//    /**
//     * Gets the value of the oglas property.
//     * 
//     * <p>
//     * This accessor method returns a reference to the live list,
//     * not a snapshot. Therefore any modification you make to the
//     * returned list will be present inside the JAXB object.
//     * This is why there is not a <CODE>set</CODE> method for the oglas property.
//     * 
//     * <p>
//     * For example, to add a new item, do as follows:
//     * <pre>
//     *    getOglas().add(newItem);
//     * </pre>
//     * 
//     * 
//     * <p>
//     * Objects of the following type(s) are allowed in the list
//     * {@link Oglas }
//     * 
//     * 
//     */
//    public List<Oglas> getOglas() {
//        if (oglas == null) {
//            oglas = new ArrayList<Oglas>();
//        }
//        return this.oglas;
//    }
//
//    /**
//     * Gets the value of the poruka property.
//     * 
//     * <p>
//     * This accessor method returns a reference to the live list,
//     * not a snapshot. Therefore any modification you make to the
//     * returned list will be present inside the JAXB object.
//     * This is why there is not a <CODE>set</CODE> method for the poruka property.
//     * 
//     * <p>
//     * For example, to add a new item, do as follows:
//     * <pre>
//     *    getPoruka().add(newItem);
//     * </pre>
//     * 
//     * 
//     * <p>
//     * Objects of the following type(s) are allowed in the list
//     * {@link Poruka }
//     * 
//     * 
//     */
//    public List<Poruka> getPoruka() {
//        if (poruka == null) {
//            poruka = new ArrayList<Poruka>();
//        }
//        return this.poruka;
//    }

}
