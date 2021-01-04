package com.example.LoginReg.DTO;

public class TAdresaDTO {
	private String mesto;
	private String ulica;
	private String broj;
	private String postanskiBroj;
	
	public TAdresaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TAdresaDTO(String mesto, String ulica, String broj, String postanskiBroj) {
		super();
		this.mesto = mesto;
		this.ulica = ulica;
		this.broj = broj;
		this.postanskiBroj = postanskiBroj;
	}
	public TAdresaDTO(TAdresaDTO adresa) {
		this.broj=adresa.broj;
		this.mesto=adresa.mesto;
		this.postanskiBroj=adresa.postanskiBroj;
		this.ulica=adresa.ulica;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}	
}
