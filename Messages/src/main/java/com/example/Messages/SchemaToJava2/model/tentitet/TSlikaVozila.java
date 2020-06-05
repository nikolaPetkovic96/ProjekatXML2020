//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.tentitet;

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
import javax.xml.bind.annotation.XmlType;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;


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
    protected long id;
	
	@Column(name = "slika", nullable = false)
    @XmlElement(required = true)
    protected byte[] slika;
    
	@OneToOne(fetch = FetchType.LAZY)
    @XmlElement(name = "Common_data", required = true)
    protected CommonData commonData;

	 //Jedna slika se odnosi na samo jedan autombil(druga strana bidirekcije)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TAutomobila tAutomobila;


    public long getId() {
        return id;
    }

 
    public void setId(long value) {
        this.id = value;
    }


    public byte[] getSlika() {
        return slika;
    }


    public void setSlika(byte[] value) {
        this.slika = ((byte[]) value);
    }


    public CommonData getCommonData() {
        return commonData;
    }


    public void setCommonData(CommonData value) {
        this.commonData = value;
    }


	public TAutomobila gettAutomobila() {
		return tAutomobila;
	}


	public void settAutomobila(TAutomobila tAutomobila) {
		this.tAutomobila = tAutomobila;
	}
    

}
