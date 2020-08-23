package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;

public class RegistrovaniKorisnikDTO {

	private Long id;
	
    private String ime;
    
    private String prezime;
 
    private String jmbg;

	public RegistrovaniKorisnikDTO() {
		super();
	}

	public RegistrovaniKorisnikDTO(Long id, String ime, String prezime, String jmbg) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	public RegistrovaniKorisnikDTO(RegistrovaniKorisnik rk) {
		
		this.id = rk.getId();
		this.ime = rk.getIme();
		this.prezime = rk.getPrezime();
		this.jmbg = rk.getJMBG();
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
