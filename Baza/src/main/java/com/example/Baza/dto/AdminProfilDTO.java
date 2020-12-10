package com.example.Baza.dto;

public class AdminProfilDTO {

	private Long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String pol;
	private String korisnickoIme;
	private String email;
	private String lozinka;
	private String status;
	private TAdresaDTO Tadresa;
	public AdminProfilDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminProfilDTO(Long id, String ime, String prezime, String jmbg, String pol, String korisnickoIme,
			String email, String lozinka, String status, TAdresaDTO tadresa) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.korisnickoIme = korisnickoIme;
		this.email = email;
		this.lozinka = lozinka;
		this.status = status;
		Tadresa = tadresa;
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
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TAdresaDTO getTadresa() {
		return Tadresa;
	}
	public void setTadresa(TAdresaDTO tadresa) {
		Tadresa = tadresa;
	}
	
	
}
