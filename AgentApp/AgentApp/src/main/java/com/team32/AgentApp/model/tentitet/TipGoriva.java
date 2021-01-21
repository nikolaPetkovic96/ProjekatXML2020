//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//

package com.team32.AgentApp.model.tentitet;

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
 * <p>Java class for TTip_goriva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTip_goriva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="naziv_tipa" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "FuelType", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = { "id", "commonDataId", "nazivTipa" })
@XmlRootElement(name = "FuelType", namespace = "http://www.ftn.uns.ac.rs/sync")
@Entity
public class TipGoriva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "Id", required = true)
    protected Long id;
    
    @Column(name = "naziv_tipa", nullable = false)
	@XmlElement(name = "Name", required = true)
    protected String nazivTipa;
    
    
    @Column(name = "common_data_id", nullable = false)
    @XmlElement(name = "CommonDataId", required = true)
    protected Long commonDataId;

    public TipGoriva() {
		super();
	}

	public TipGoriva(Long id, String nazivTipa, Long commonDataId) {
		super();
		this.id = id;
		this.nazivTipa = nazivTipa;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }
    
    public void setNazivTipa(String value) {
        this.nazivTipa = value;
    }

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}