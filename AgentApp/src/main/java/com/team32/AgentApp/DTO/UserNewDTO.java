package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.User;

public class UserNewDTO {
	
 	private Long id;
	
    protected String korisnickoIme;
	
    protected String lozinka;
    
    protected String lozinkaZaPotvrdu;

    protected String email;

    protected String status;

    protected Long adresaId;
    
	//za agenta osoba
    
    protected String ime;

    protected String prezime;

    protected String jmbg;
    
	//za agenta firma

    protected String naziv;

    protected String poslovniMaticniBroj;
    
    protected String pol;

    protected Long commonDataId;
    
	private AdresaDTO adresa;

	public UserNewDTO() {
		super();
	}

	public UserNewDTO(Long id, String korisnickoIme, String lozinka,String lozinkaZaPotvrdu, String email, String status, Long adresaId, String ime,
			String prezime, String jmbg, String naziv, String poslovniMaticniBroj, String pol, AdresaDTO adresa, Long commonDataId) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.status = status;
		this.adresaId = adresaId;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.naziv = naziv;
		this.poslovniMaticniBroj = poslovniMaticniBroj;
		this.pol = pol;
		this.commonDataId = commonDataId;
		
		this.lozinkaZaPotvrdu = lozinkaZaPotvrdu;
		this.adresa = adresa;

	}

	public UserNewDTO(User u, AdresaDTO adresa) {
		super();
		this.id = u.getId();
		this.korisnickoIme = u.getKorisnickoIme();
		this.lozinka = u.getLozinka();
		this.email = u.getEmail();
		this.status = u.getStatus();
		this.adresaId = u.getAdresaId();
		this.ime = u.getIme();
		this.prezime = u.getPrezime();
		this.jmbg = u.getJmbg();
		this.naziv = u.getNaziv();
		this.poslovniMaticniBroj = u.getPoslovniMaticniBroj();
		this.pol = u.getPol();
		this.commonDataId = u.getCommonDataId();
		
		this.adresa = adresa;
		
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

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPoslovniMaticniBroj() {
		return poslovniMaticniBroj;
	}

	public void setPoslovniMaticniBroj(String poslovniMaticniBroj) {
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public String getLozinkaZaPotvrdu() {
		return lozinkaZaPotvrdu;
	}

	public void setLozinkaZaPotvrdu(String lozinkaZaPotvrdu) {
		this.lozinkaZaPotvrdu = lozinkaZaPotvrdu;
	}

}
