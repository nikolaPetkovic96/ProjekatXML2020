package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.user.Firma;

public class FirmaAgentDTO {
	
 	private Long id;
	
 	private String ime;
    
 	private String prezime;
 
 	private String jmbg;
    
 	
	public FirmaAgentDTO() {
		super();
	}

	public FirmaAgentDTO(Long id, String naziv, String poslovniMaticniBroj, String ime, String prezime, String jmbg) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}

	public FirmaAgentDTO(Firma firma) {
		super();
		this.id = firma.getId();
		this.ime = firma.getIme();
		this.prezime = firma.getPrezime();
		this.jmbg = firma.getJmbg();
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
