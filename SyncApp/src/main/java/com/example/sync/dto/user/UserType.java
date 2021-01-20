package com.example.sync.dto.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = { "id", "korisnickoIme","lozinka","email","status","adresaId",
													"pol","ime","prezime","jmbg",
													"nazivFirme","poslovniMaticniBroj",
													"allowedToCommend","allowedToMessage","allowedToMakeReservation"})
@XmlRootElement(name = "UserType")
public class UserType {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;	
	
	@XmlElement(name = "KorisnickoIme", required = true)
	protected String korisnickoIme;
	@XmlElement(name = "Lozinka", required = true)
	protected String lozinka;
	@XmlElement(name = "Email", required = true)
	protected String email;
	@XmlElement(name = "Status", required = true)
	protected String status;
	@XmlElement(name = "AdresaId", required = true)
	protected Long adresaId;
	
	@XmlElement(name = "Pol", required = true)
	protected String pol;
	@XmlElement(name = "Ime", required = true)
	protected String ime;
	@XmlElement(name = "Prezime", required = true)
	protected String prezime;
	@XmlElement(name = "Jmbg", required = true)
	protected String jmbg;
	
	@XmlElement(name = "NazivFirme", required = true)
	protected String nazivFirme;
	@XmlElement(name = "PoslovniMaticniBroj", required = true)
	protected String poslovniMaticniBroj;
	
	@XmlElement(name = "AllowedToCommend", required = true)
	private boolean allowedToCommend;
	@XmlElement(name = "AllowedToMessage", required = true)
	private boolean allowedToMessage;
	@XmlElement(name = "AllowedToMakeReservation", required = true)
	private boolean allowedToMakeReservation;
	
	public UserType() {
		// TODO Auto-generated constructor stub
	}

	public UserType(Long id, String korisnickoIme, String lozinka, String email, String status,
			Long adresaId, String pol, String ime, String prezime, String jmbg, String nazivFirme,
			String poslovniMaticniBroj, boolean allowedToCommend, boolean allowedToMessage,
			boolean allowedToMakeReservation) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.status = status;
		this.adresaId = adresaId;
		this.pol = pol;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.nazivFirme = nazivFirme;
		this.poslovniMaticniBroj = poslovniMaticniBroj;
		this.allowedToCommend = allowedToCommend;
		this.allowedToMessage = allowedToMessage;
		this.allowedToMakeReservation = allowedToMakeReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAdresaId() {
		return adresaId;
	}

	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
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

	public String getNazivFirme() {
		return nazivFirme;
	}

	public void setNazivFirme(String nazivFirme) {
		this.nazivFirme = nazivFirme;
	}

	public String getPoslovniMaticniBroj() {
		return poslovniMaticniBroj;
	}

	public void setPoslovniMaticniBroj(String poslovniMaticniBroj) {
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}

	public boolean isAllowedToCommend() {
		return allowedToCommend;
	}

	public void setAllowedToCommend(boolean allowedToCommend) {
		this.allowedToCommend = allowedToCommend;
	}

	public boolean isAllowedToMessage() {
		return allowedToMessage;
	}

	public void setAllowedToMessage(boolean allowedToMessage) {
		this.allowedToMessage = allowedToMessage;
	}

	public boolean isAllowedToMakeReservation() {
		return allowedToMakeReservation;
	}

	public void setAllowedToMakeReservation(boolean allowedToMakeReservation) {
		this.allowedToMakeReservation = allowedToMakeReservation;
	}

}
