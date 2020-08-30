//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.entitet;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
//import com.example.Messages.SchemaToJava2.model.user.Firma;
//import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/Automobil}Automobil"/>
 *         &lt;element name="Od_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Do_datuma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/cenovnik}Cenovnik"/>
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
    "automobil",
    "odDatuma",
    "doDatuma",
    "cenovnik"
})
@XmlRootElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa")
@Entity 
public class Oglas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa")
    protected Long id; 
    
    @XmlElement(name = "Od_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime odDatuma;
    
    @XmlElement(name = "Do_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime  doDatuma;
    
    //Jedan oglas se kreira sa samo jednim cenovnikom(druga strana bidirekcije)w
    @XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
    @Column(name="cenovnik_id")
    protected Long cenovnikId;
    
    @Column(name="common_data_id")
	private Long commonDataId;
	
    @Column(name="automobil_id")
	private Long automobilId;
    
    
    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
	//private Firma firma;
	//private RegistrovaniKorisnik reg_korisnik;
    @ManyToMany
    @JoinTable(
    		  name = "rezervacije_oglasi", 
    		  joinColumns = @JoinColumn(name = "oglas_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "rezervacija_id"))
	private List<Rezervacija> rezervacije;

    public Oglas() {
		super();
	}
    
    public Oglas(Long id, LocalDateTime  odDatuma, LocalDateTime  doDatuma, Long cenovnikId, Long commonDataId, Long automobilId) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
	}

	public Long getId() {
        return id;
    }

	public void setId(Long value) {
        this.id = value;
    }


    public LocalDateTime  getOdDatuma() {
        return odDatuma;
    }


    public void setOdDatuma(LocalDateTime value) {
        this.odDatuma = value;
    }

    
    public LocalDateTime getDoDatuma() {
        return doDatuma;
    }


    public void setDoDatuma(LocalDateTime value) {
        this.doDatuma = value;
    }


	public Long getCenovnikId() {
		return cenovnikId;
	}


	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
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
