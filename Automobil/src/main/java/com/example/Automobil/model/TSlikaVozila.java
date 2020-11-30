//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//

package com.example.Automobil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for TSlika_vozila complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSlika_vozila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="slika" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
@XmlType(name = "TSlika_vozila", propOrder = {
    "id",
    "slika",
    "commonData"
})

@Entity
public class TSlikaVozila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@Column(name = "slika", nullable = false)
    @XmlElement(required = true)
    protected byte[] slika;
    
	
    @XmlElement(name = "Common_data", required = true)
    @Column(name = "common_data_id", nullable = false)
    protected Long commonDataId;

	 //Jedna slika se odnosi na samo jedan autombil(druga strana bidirekcije)
    @Column(name = "automobil_id", nullable = false)
    private Long automobilId;


	public TSlikaVozila() {
		super();
	}

	public TSlikaVozila(Long id, byte[] slika, Long commonDataId, Long automobilId) {
		super();
		this.id = id;
		this.slika = slika;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] value) {
        this.slika = ((byte[]) value);
    }

    
	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}


	public Long getAutomobilId() {
		return automobilId;
	}


	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}



}
