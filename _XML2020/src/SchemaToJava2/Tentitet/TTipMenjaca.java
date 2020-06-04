//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.Tentitet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.example.Messages.SchemaToJava2.mode.entitet.CommonData;


/**
 * <p>Java class for TTip_menjaca complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTip_menjaca">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="naziv_menjaca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Common_data" type="{http://www.ftn.uns.ac.rs/AdminKlijent}common_data"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTip_menjaca", propOrder = {
    "id",
    "nazivMenjaca",
    "commonData"
})

@Entity
public class TTipMenjaca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
	
	@Column(name = "naziv_menjaca", nullable = false)
    @XmlElement(name = "naziv_menjaca", required = true)
    protected String nazivMenjaca;
    
	@OneToOne(fetch = FetchType.LAZY)
    @XmlElement(name = "Common_data", required = true)
    protected CommonData commonData;

	 //Jedan TModelAutomobilaa se odnosi na samo jednu TAutomobila(druga strana bidirekcije)
//  @OneToOne(fetch = FetchType.LAZY)
//  private TAutomobila tAutomobila;

    public long getId() {
        return id;
    }


    public void setId(long value) {
        this.id = value;
    }


    public String getNazivMenjaca() {
        return nazivMenjaca;
    }


    public void setNazivMenjaca(String value) {
        this.nazivMenjaca = value;
    }

    
    public CommonData getCommonData() {
        return commonData;
    }


    public void setCommonData(CommonData value) {
        this.commonData = value;
    }

}
