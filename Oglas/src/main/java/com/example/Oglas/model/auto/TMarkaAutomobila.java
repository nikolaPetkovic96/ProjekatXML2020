//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//

package com.example.Oglas.model.auto;

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



/**
 * <p>Java class for TMarka_automobila complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TMarka_automobila">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="naziv_marke" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Common_data" type="{http://www.ftn.uns.ac.rs/AdminKlijent}common_data"/>
 *         &lt;sequence>
 *           &lt;element name="Model_automobila" type="{http://www.ftn.uns.ac.rs/Automobil}TModel_automobila"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMarka_automobila", propOrder = {
    "id",
    "nazivMarke",
    "commonData",
    "modelAutomobila"
})
@Entity
public class TMarkaAutomobila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@Column(name = "naziv_marke", nullable = false, unique = true)
    @XmlElement(name = "naziv_marke", required = true)
    protected String nazivMarke;
	
    @XmlElement(name = "Common_data", required = true)
    protected Long commonDataId;
	
	//Jedna marka ima vise modela, id marke se dodaje kao nova kolona u tabeli TMarkaAutombila
	
	public TMarkaAutomobila() {
		
	}
	
    public TMarkaAutomobila(Long id, String nazivMarke, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonDataId = commonDataId;
	}


	public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
    }


    public String getNazivMarke() {
        return nazivMarke;
    }


    public void setNazivMarke(String value) {
        this.nazivMarke = value;
    }

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}