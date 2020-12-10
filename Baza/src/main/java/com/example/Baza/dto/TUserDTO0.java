package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class TUserDTO0 {
	private Long id;
	private String korisnickoIme;
	private String lozinka;
	private String email;
	private String status;
	private Long adresaId;
	
	public TUserDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TUserDTO0(Long id, String korisnickoIme, String lozinka, String email, String status, Long adresaId) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.status = status;
		this.adresaId = adresaId;
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
}
