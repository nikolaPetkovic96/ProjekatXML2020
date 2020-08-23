package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.user.Administrator;

public class AdministratorDTO {
	private Long id;
	private String role;
	private String ime;
	private String prezime;
	private String jmbg;
	
	public AdministratorDTO() {
		
	}
	
	public AdministratorDTO(Long id, String role, String ime, String prezime, String jmbg) {
		super();
		this.id = id;
		this.role = role;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
	}
	
	public AdministratorDTO(Administrator a) {
		this(a.getId(),a.getRole(), a.getIme(), a.getPrezime(),a.getJmbg());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
