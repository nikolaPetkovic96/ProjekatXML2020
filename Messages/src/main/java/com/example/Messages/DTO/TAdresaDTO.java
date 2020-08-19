package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;

public class TAdresaDTO {
	private Long id;
	private String mesto;
	private int postanskiBroj;
	private String ulica;
	private int broj;
	private float longitude;
	private float latitude;
	
	public TAdresaDTO() {}
	
	public TAdresaDTO(Long id, String mesto, int postanskiBroj, String ulica, int broj, float longitude, float latitude) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public TAdresaDTO(TAdresa a) {
		super();
		this.id = a.getId();
		this.mesto = a.getMesto();
		this.postanskiBroj = a.getPostanskiBroj();
		this.ulica = a.getUlica();
		this.broj = a.getBroj();
		this.longitude = a.getLongitude();
		this.latitude = a.getLatitude();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
}
