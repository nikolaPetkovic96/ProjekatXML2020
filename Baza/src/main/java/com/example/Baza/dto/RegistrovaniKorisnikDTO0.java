package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class RegistrovaniKorisnikDTO0 {
	private Long id;
	private String ime;
	private String Prezime;
	private String jmbg;
	
	public RegistrovaniKorisnikDTO0(Long id, String ime, String prezime, String jmbg) {
		super();
		this.id = id;
		this.ime = ime;
		Prezime = prezime;
		this.jmbg = jmbg;
	}

	public RegistrovaniKorisnikDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
}
