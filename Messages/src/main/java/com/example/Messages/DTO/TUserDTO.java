package com.example.Messages.DTO;

import java.util.List;


import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
import com.example.Messages.SchemaToJava2.model.user.TUser;

//Mozda i nece trebati sada samo za proveru da li radi CRUD:
public class TUserDTO {

	private Long id;
		
	private String korisnickoIme;
	
	private String lozinka;

	private String email;

	private String status;
	
	private TAdresa adresa;
	
	private List<CommonData> commonData;
	
	private List<Rezervacija> rezervacije;
	

	public TUserDTO() {
		super();
	}
	
	public TUserDTO(TUser tUser) {
		this(
				tUser.getId(),
				tUser.getKorisnickoIme(),
				tUser.getLozinka(),
				tUser.getEmail(),
				tUser.getStatus(),
				tUser.getAdresa(),
				tUser.getCommonData(),
				tUser.getRezervacije()
			);
	}

	public TUserDTO(Long id, String korisnickoIme, String lozinka, String email, String status, TAdresa adresa,
			List<CommonData> commonData, List<Rezervacija> rezervacije) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.status = status;
		this.adresa = adresa;
		this.commonData = commonData;
		this.rezervacije = rezervacije;
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

	public TAdresa getAdresa() {
		return adresa;
	}

	public void setAdresa(TAdresa adresa) {
		this.adresa = adresa;
	}

	public List<CommonData> getCommonData() {
		return commonData;
	}

	public void setCommonData(List<CommonData> commonData) {
		this.commonData = commonData;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	
}
