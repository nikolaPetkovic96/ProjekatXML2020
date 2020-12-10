package com.example.Baza.dto;

import org.springframework.stereotype.Component;

@Component
public class CenovnikDTO0 {
	
	private Long id;
	private float cenaPoDanu;
	private String nazivCenovnika;
	private float cenaZaPreko30Dana;
	private float cenaCollisionDamageWaiver;
	private float cenaPoKm;
	
	public CenovnikDTO0() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CenovnikDTO0(Long id, float cenaPoDanu, String nazivCenovnika, float cenaZaPreko30Dana,
			float cenaCollisionDamageWaiver, float cenaPoKm) {
		super();
		this.id = id;
		this.cenaPoDanu = cenaPoDanu;
		this.nazivCenovnika = nazivCenovnika;
		this.cenaZaPreko30Dana = cenaZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKm = cenaPoKm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getCenaPoDanu() {
		return cenaPoDanu;
	}

	public void setCenaPoDanu(float cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public String getNazivCenovnika() {
		return nazivCenovnika;
	}

	public void setNazivCenovnika(String nazivCenovnika) {
		this.nazivCenovnika = nazivCenovnika;
	}

	public float getCenaZaPreko30Dana() {
		return cenaZaPreko30Dana;
	}

	public void setCenaZaPreko30Dana(float cenaZaPreko30Dana) {
		this.cenaZaPreko30Dana = cenaZaPreko30Dana;
	}

	public float getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}

	public void setCenaCollisionDamageWaiver(float cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}

	public float getCenaPoKm() {
		return cenaPoKm;
	}

	public void setCenaPoKm(float cenaPoKm) {
		this.cenaPoKm = cenaPoKm;
	}
}
