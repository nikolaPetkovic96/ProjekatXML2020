package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class FirmaDTO0 {

	private Long id;
	//firma
	private Long naziv;
	private String pib;
	//agent
	private String ime;
	private String prezime;
	private String jmbg;	
	
	public FirmaDTO0(Long id, Long naziv, String pib, String ime, String prezime, String jmbg) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pib = pib;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	public FirmaDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNaziv() {
		return naziv;
	}
	public void setNaziv(Long naziv) {
		this.naziv = naziv;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
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
	
	
	
}
