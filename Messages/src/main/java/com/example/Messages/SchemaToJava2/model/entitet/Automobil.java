//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.entitet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.example.Messages.SchemaToJava2.model.tentitet.TAutomobila;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ftn.uns.ac.rs/Automobil}TAutomobila">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Komentar" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Ocena" maxOccurs="unbounded"/>
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
    "id",
    "komentar",
    "ocena"
})

@XmlRootElement(name = "Automobil")
@Entity
public class Automobil
    extends TAutomobila
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	//Jedan automobil ima vise komentara vezanih za sebe (u tabeli komentar se cuva id automobila na kojem se ona vrsi)
	@OneToMany(mappedBy="automobil",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Komentar", required = true)
    protected List<Komentar> komentar;
	
	//Jedan automobil ima vise ocena vezanih za sebe (u tabeli ocena se cuva id automobila na kojem se ona vrsi)
	@OneToMany(mappedBy="automobil",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Ocena", required = true)
    protected List<Ocena> ocena;


    public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
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


	public void setKomentar(List<Komentar> komentar) {
		this.komentar = komentar;
	}


	public void setOcena(List<Ocena> ocena) {
		this.ocena = ocena;
	}

    
}
