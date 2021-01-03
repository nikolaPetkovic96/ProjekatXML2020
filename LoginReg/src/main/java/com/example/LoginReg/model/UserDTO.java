package com.example.LoginReg.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	protected Long id;
	protected String korisnickoIme;
	protected String lozinka;
	protected String email;
	protected String status;
	protected String pol;
	protected String prezime;

	protected String ime;
	protected String jmbg;

	protected String nazivFirme;
	protected String poslovniMaticniBroj;
	protected String uloga;
	protected String staraLozinka;
	@JsonIgnore
	public String getStaraLozinka() {
		return staraLozinka;
	}

	
	@JsonProperty
	public void setStaraLozinka(String staraLozinka) {
		this.staraLozinka = staraLozinka;
	}

	private boolean allowedToCommend, allowedToMessage,allowedToMakeReservation=true;
	
	protected Map<String, String> TAdresa;

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
	
	@JsonIgnore
	public String getLozinka() {
		return lozinka;
	}
	@JsonProperty

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

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Map<String, String> getTAdresa() {
		return TAdresa;
	}

	public void setTAdresa(Map<String, String> tAdresa) {
		TAdresa = tAdresa;
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

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
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
