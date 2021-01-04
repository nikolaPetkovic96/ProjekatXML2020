package com.example.Oglas.dto;

import com.example.Oglas.model.Cenovnik;

public class CenovnikDTO {

	private Long id;
	private String nazivCenovnika;
	private float cenaPoDanu;
	private float popustZaPreko30Dana;
	private float cenaCollisionDamageWaiver;
	private float cenaPoKilometru;
	
	private Long commonDataId;//ne treba samo za testiranje CRUD
	
	public CenovnikDTO() {
		
	}

	public CenovnikDTO(Long id, String nazivCenovnika, float cenaPoDanu, float popustZaPreko30Dana,
			float cenaCollisionDamageWaiver, float cenaPoKilometru,  Long commonDataId) {
		super();
		this.id = id;
		this.cenaPoDanu = cenaPoDanu;
		this.nazivCenovnika = nazivCenovnika;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;

		this.commonDataId = commonDataId;
	}
	
	public CenovnikDTO(Cenovnik c) {
		this.id = c.getId();
		this.cenaPoDanu = c.getCenaPoDanu();
		this.nazivCenovnika = c.getNazivCenovnika();
		this.popustZaPreko30Dana = c.getPopustZaPreko30Dana();
		this.cenaCollisionDamageWaiver = c.getCenaCollisionDamageWaiver();
		this.cenaPoKilometru = c.getCenaPoKilometru();
		
		this.commonDataId =  c.getCommonDataId();
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivCenovnika() {
		return nazivCenovnika;
	}

	public void setNazivCenovnika(String nazivCenovnika) {
		this.nazivCenovnika = nazivCenovnika;
	}

	public float getCenaPoDanu() {
		return cenaPoDanu;
	}

	public void setCenaPoDanu(float cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public float getPopustZaPreko30Dana() {
		return popustZaPreko30Dana;
	}

	public void setPopustZaPreko30Dana(float popustZaPreko30Dana) {
		this.popustZaPreko30Dana = popustZaPreko30Dana;
	}

	public float getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}

	public void setCenaCollisionDamageWaiver(float cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}

	public float getCenaPoKilometru() {
		return cenaPoKilometru;
	}

	public void setCenaPoKilometru(float cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
