//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 
//
//
//
//package com.example.Messages.SchemaToJava2.model.user;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.bind.annotation.XmlType;
//
//import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
//import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
//import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
//
//
//
///**
// * <p>Java class for TUser complex type.
// * 
// * <p>The following schema fragment specifies the expected content contained within this class.
// * 
// * <pre>
// * &lt;complexType name="TUser">
// *   &lt;complexContent>
// *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
// *       &lt;sequence>
// *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
// *         &lt;element name="Korisnicko_ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="Lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="Adresa" type="{http://www.ftn.uns.ac.rs/korisnici}TAdresa"/>
// *         &lt;element name="Email" type="{http://www.ftn.uns.ac.rs/korisnici}TEmail"/>
// *         &lt;element ref="{http://www.ftn.uns.ac.rs/korisnici}Status"/>
// *       &lt;/sequence>
// *     &lt;/restriction>
// *   &lt;/complexContent>
// * &lt;/complexType>
// * </pre>
// * 
// * 
// */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "TUser", namespace = "http://www.ftn.uns.ac.rs/korisnici", propOrder = {
//    "id",
//    "korisnickoIme",
//    "lozinka",
//    "adresa",
//    "email",
//    "status"
//})
//@XmlSeeAlso({
//    RegistrovaniKorisnik.class,
//    Administrator.class,
//    Agent.class
//})
//
////Tabela sa svim korisnicia koju treba povezati sa authority 
////jer svaki korisnik ima vise rola i svaku rolu moze vise authority;
//@Entity
//@Table(name="TUser")
//@Inheritance(strategy = InheritanceType.JOINED)
//public abstract class TUser /*implements UserDetails */ {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long id;
//	
//	@Column(name = "korisnicko_ime", unique = true, nullable = false)
//    @XmlElement(name = "Korisnicko_ime", required = true)
//    protected String korisnickoIme;
//	
//	@Column(name = "lozinka", nullable = false)
//    @XmlElement(name = "Lozinka", required = true)
//    protected String lozinka;
//	
//	@Column(name = "email", nullable = false)
//    @XmlElement(name = "Email", required = true)
//    protected String email;
//	
//	@Column(name = "status", nullable = false)
//    @XmlElement(name = "Status", required = true, defaultValue = "aktivan")
//    protected String status;
//	
//	@OneToOne(fetch = FetchType.LAZY)
//    @XmlElement(name = "Adresa", required = true)
//    protected TAdresa adresa;
//	
//	//Jedan korisnik moze da izvrsi vise izmena (commonData) (u tabeli common_data se cuva id korisnika koji je izmenu izvrsio)
//	@OneToMany(mappedBy="korisnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Rezervacija> rezervacije;
//	
//	
//
////DODATI KONSTURKTORE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//
//
//	public Long getId() {
//        return id;
//    }
//
//
//    public void setId(Long value) {
//        this.id = value;
//    }
//
//
//    public String getKorisnickoIme() {
//        return korisnickoIme;
//    }
//
//
//    public void setKorisnickoIme(String value) {
//        this.korisnickoIme = value;
//    }
//
//
//    public String getLozinka() {
//        return lozinka;
//    }
//
//
//    public void setLozinka(String value) {
//        this.lozinka = value;
//    }
//
//
//    public TAdresa getAdresa() {
//        return adresa;
//    }
//
//
//    public void setAdresa(TAdresa value) {
//        this.adresa = value;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
//
//
//    public void setEmail(String value) {
//        this.email = value;
//    }
//
//
//    public String getStatus() {
//        return status;
//    }
//
//
//    public void setStatus(String value) {
//        this.status = value;
//    }
//
//
//	public List<Rezervacija> getRezervacije() {
//		return rezervacije;
//	}
//
//
//	public void setRezervacije(List<Rezervacija> rezervacije) {
//		this.rezervacije = rezervacije;
//	}
//    
//	
//    
//
//}
