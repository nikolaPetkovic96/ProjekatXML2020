package com.example.Baza.dto;

public class AdministratorDTO0 {

	private String id;
	private String role;
	private String ime;
	private String prezime;
	
	public AdministratorDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdministratorDTO0(String id, String role, String ime, String prezime) {
		super();
		this.id = id;
		this.role = role;
		this.ime = ime;
		this.prezime = prezime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
}
