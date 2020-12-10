package com.example.LoginReg.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Tabela sa svim korisnicia koju treba povezati sa authority 
//jer svaki korisnik ima vise rola i svaku rolu moze vise authority;
@Entity
@Table(name = "TUser")
public /* abstract */ class TUser /* implements UserDetails */ {
	@ManyToMany
	protected List<Authority> authorities = new LinkedList<Authority>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "korisnicko_ime", unique = true, nullable = false)
	@XmlElement(name = "Korisnicko_ime", required = true)
	protected String korisnickoIme;

	@Column(name = "lozinka", nullable = false)
	@XmlElement(name = "Lozinka", required = true)
	protected String lozinka;

	/*
	 * @Column(name = "email", nullable = false)
	 * 
	 * @XmlElement(name = "Email", required = true) protected String email;
	 * 
	 * @Column(name = "status", nullable = false)
	 * 
	 * @XmlElement(name = "Status", required = true, defaultValue = "aktivan")
	 * protected String status;
	 * 
	 * @XmlElement(name = "Adresa", required = true)
	 * 
	 * @Column(name = "adresa_id", nullable = false) protected Long adresaId;
	 */
	public Long getId() {
		return id;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public TUser() {
		

		//authorities.add(tset);
	}

	public TUser(Long id, String korisnickoIme, String lozinka, String email, String status, Long adresaId) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		/*
		 * this.email = email; this.status = status; this.adresaId = adresaId;
		 */
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

	/*
	 * public Long getAdresaId() { return adresaId; }
	 * 
	 * public void setAdresaId(Long adresaId) { this.adresaId = adresaId; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String value) { this.email = value; }
	 * 
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String value) { this.status = value; }
	 */

}
