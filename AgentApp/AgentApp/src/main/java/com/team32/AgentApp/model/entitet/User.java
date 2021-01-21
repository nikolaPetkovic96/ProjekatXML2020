
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.02 at 07:25:52 PM CEST 

package com.team32.AgentApp.model.entitet;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Java class for TUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Korisnicko_ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Adresa" type="{http://www.ftn.uns.ac.rs/korisnici}TAdresa"/>
 *         &lt;element name="Email" type="{http://www.ftn.uns.ac.rs/korisnici}TEmail"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/korisnici}Status"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = { "id", "commonDataId", "nazivTipa", "korisnickoIme","Loznika","email","status","adresaId",
		"pol","ime","prezime","jmbg",
		"nazivFirme","poslovniMaticniBroj",
		"allowedToCommend","allowedToMessage","allowedToMakeReservation"})
@XmlRootElement(name = "UserType", namespace = "http://www.ftn.uns.ac.rs/sync")
@Entity
@Table(name="Users")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "Id", required = true)
    protected Long id;
	
	@Column(name = "korisnicko_ime", unique = true, nullable = false)
	@XmlElement(name = "KorisnickoIme", required = true)
    protected String korisnickoIme;
	
	@Column(name = "lozinka", nullable = false)
	@XmlElement(name = "Lozinka", required = true)
    protected String lozinka;
	
	@Column(name = "email", nullable = false)
	@XmlElement(name = "Email", required = true)
    protected String email;
	
	@Column(name = "status", nullable = false)
//  @XmlElement(name = "Status", required = true, defaultValue = "aktivan")
	@XmlElement(name = "Status", required = true)
    protected String status;
	
    @Column(name = "adresa_id", nullable = false)
    @XmlElement(name = "AdresaId", required = true)
    protected Long adresaId;
    
	//za agenta osoba
    
	@Column(name = "ime",  nullable = true)
	@XmlElement(name = "Ime", required = true)
    protected String ime;
    
	@Column(name = "prezime",  nullable = true)
	@XmlElement(name = "Prezime", required = true)
    protected String prezime;
    
	@Column(name = "jmbg",  nullable = true)
	@XmlElement(name = "Jmbg", required = true)
    protected String jmbg;
	
	@Column(name = "pol",  nullable = true)
	@XmlElement(name = "Pol", required = true)
	protected String pol;
    
	//za agenta firma
	
    @Column(name = "naziv",  nullable = true)
	@XmlElement(name = "NazivFirme", required = true)
    protected String naziv;
	
	@Column(name = "pib", unique = true, nullable = true)
	@XmlElement(name = "PoslovniMaticniBroj", required = true)
    protected String poslovniMaticniBroj;
	
    @Column(name="common_data_id", nullable = false)
    @XmlElement(name = "CommonDataId", required = true)
    protected Long commonDataId;
    
	@XmlElement(name = "AllowedToCommend")
	@Column(name="allowed_to_commend", nullable = true)
	private boolean allowedToCommend;
	
	@XmlElement(name = "AllowedToMessage")
	@Column(name="allowed_to_message", nullable = true)
	private boolean allowedToMessage;
	
	@XmlElement(name = "AllowedToMakeReservation")
	@Column(name="allowed_to_make_reserv", nullable = true)
	private boolean allowedToMakeReservation;

	
    
    //ZA SECURITY
	
	//U token utilsu se nalazi... iskoristiti samo ako se menja password
//	@Column(name = "last_password_reset_date")
	private Timestamp lastPasswordResetDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "authority_id"))
	private List<Authority> authorities;
	
	
	//ZA SOPA dodato	
	@XmlElement(name = "Token", required = true)
	protected String token;
	
	public User() {
		super();
	}

	public User(Long id, String korisnickoIme, String lozinka, String email, String status, Long adresaId, String ime,
			String prezime, String jmbg, String naziv, String poslovniMaticniBroj, String pol, Long commonDataId, 
			List<Authority> authorities) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.status = status;
		this.adresaId = adresaId;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.naziv = naziv;
		this.poslovniMaticniBroj = poslovniMaticniBroj;
		this.pol = pol;
		this.commonDataId = commonDataId;
		this.authorities = authorities;
	
	}

	public Long getId() {
        return id;
    }

	public void setId(Long value) {
        this.id = value;
    }


    public String getKorisnickoIme() {
        return korisnickoIme;
    }


    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
    }


    public String getLozinka() {
        return lozinka;
    }


    public void setLozinka(String value) {
        this.lozinka = value;
    }

    public Long getAdresaId() {
		return adresaId;
	}


	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}


    public String getEmail() {
        return email;
    }


    public void setEmail(String value) {
        this.email = value;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String value) {
        this.status = value;
    }
    
    public String getPoslovniMaticniBroj() {
        return poslovniMaticniBroj;
    }

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public void setPoslovniMaticniBroj(String value) {
        this.poslovniMaticniBroj = value;
    }
	
	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
	//DODATO ZA SECURITY

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return lozinka;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return korisnickoIme;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		
		return status.equals("aktivan");
	}
	
  @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

  	//Mozemo ovde da zabranjujemo account useru 
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}


	//Za SOAP
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



}
