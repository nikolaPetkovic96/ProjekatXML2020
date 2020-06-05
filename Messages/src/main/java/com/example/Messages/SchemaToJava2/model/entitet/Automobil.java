//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//


package com.example.Messages.SchemaToJava2.model.entitet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;


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
public class Automobil {
	
	public Automobil() {
		super();
	}


	public Automobil(Long id, TMarkaAutomobila markaAutomobila, TModelAutomobila modelAutomobila,
			TKlasaAutomobila klasaAutomobila, TTipGoriva vrstaGoriva, TTipMenjaca tipMenjaca, float predjenaKilometraza,
			BigInteger planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu,
			List<TSlikaVozila> slika, List<Komentar> komentar, List<Ocena> ocena) {
		super();
		this.id = id;
		this.markaAutomobila = markaAutomobila;
		this.modelAutomobila = modelAutomobila;
		this.klasaAutomobila = klasaAutomobila;
		this.vrstaGoriva = vrstaGoriva;
		this.tipMenjaca = tipMenjaca;
		this.predjenaKilometraza = predjenaKilometraza;
		this.planiranaKilometraza = planiranaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.slika = slika;
		this.komentar = komentar;
		this.ocena = ocena;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Marka_automobila", required = true)
    protected TMarkaAutomobila markaAutomobila;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Model_automobila", required = true)
    protected TModelAutomobila modelAutomobila;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Klasa_automobila", required = true)
    protected TKlasaAutomobila klasaAutomobila;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Vrsta_goriva", required = true)
    protected TTipGoriva vrstaGoriva;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Tip_menjaca", required = true)
    protected TTipMenjaca tipMenjaca;
    
	@Column(name = "predj_kilom", nullable = false)
    @XmlElement(name = "Predjena_kilometraza")
    protected float predjenaKilometraza;
    
	@Column(name = "plan_kilom", nullable = false)
    @XmlElement(name = "Planirana_kilometraza", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger planiranaKilometraza;
    
	@Column(name = "col_dmg_waiver", nullable = false)
    @XmlElement(name = "Collision_Damage_Waiver")
    protected boolean collisionDamageWaiver;
    
	@Column(name = "br_sedista_za_decu", nullable = false)
    @XmlElement(name = "Broj_sedista_za_decu")
    protected int brojSedistaZaDecu;
    
    @OneToMany(mappedBy = "automobil", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement(name = "Slika", required = true)
    protected List<TSlikaVozila> slika;
	
	
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
    
    

    
    public TMarkaAutomobila getMarkaAutomobila() {
		return markaAutomobila;
	}


	public void setMarkaAutomobila(TMarkaAutomobila markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}


	public TModelAutomobila getModelAutomobila() {
		return modelAutomobila;
	}


	public void setModelAutomobila(TModelAutomobila modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}


	public TKlasaAutomobila getKlasaAutomobila() {
		return klasaAutomobila;
	}


	public void setKlasaAutomobila(TKlasaAutomobila klasaAutomobila) {
		this.klasaAutomobila = klasaAutomobila;
	}


	public TTipGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}


	public void setVrstaGoriva(TTipGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}


	public TTipMenjaca getTipMenjaca() {
		return tipMenjaca;
	}


	public void setTipMenjaca(TTipMenjaca tipMenjaca) {
		this.tipMenjaca = tipMenjaca;
	}


	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}


	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}


	public BigInteger getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}


	public void setPlaniranaKilometraza(BigInteger planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
	}


	public boolean isCollisionDamageWaiver() {
		return collisionDamageWaiver;
	}


	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
		this.collisionDamageWaiver = collisionDamageWaiver;
	}


	public int getBrojSedistaZaDecu() {
		return brojSedistaZaDecu;
	}


	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}


	public List<TSlikaVozila> getSlika() {
		return slika;
	}


	public void setSlika(List<TSlikaVozila> slika) {
		this.slika = slika;
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
