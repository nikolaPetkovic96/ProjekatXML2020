package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Cenovnik;
public class CenovnikDTO {

	private Long id;
	private int cenaPoDanu;
	private String nazivCenovnika;
	private int popustZaPreko30Dana;
	private int cenaCollisionDamageWaiver;
	private int cenaPoKilometru;
	
	public CenovnikDTO() {
		
	}

	public CenovnikDTO(Long id, Integer cenaPoDanu, String nazivCenovnika, Integer popustZaPreko30Dana,
			Integer cenaCollisionDamageWaiver, Integer cenaPoKilometru) {
		super();
		this.id = id;
		this.cenaPoDanu = cenaPoDanu;
		this.nazivCenovnika = nazivCenovnika;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;
	}
	
	public CenovnikDTO(Cenovnik c) {
		this.id = c.getId();
		this.cenaPoDanu = c.getCenaPoDanu();
		this.nazivCenovnika = c.getNazivCenovnika();
		this.popustZaPreko30Dana = c.getPopustZaPreko30Dana();
		this.cenaCollisionDamageWaiver = c.getCenaCollisionDamageWaiver();
		this.cenaPoKilometru = c.getCenaPoKilometru();
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCenaPoDanu() {
		return cenaPoDanu;
	}

	public void setCenaPoDanu(Integer cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public String getNazivCenovnika() {
		return nazivCenovnika;
	}

	public void setNazivCenovnika(String nazivCenovnika) {
		this.nazivCenovnika = nazivCenovnika;
	}

	public int getPopustZaPreko30Dana() {
		return popustZaPreko30Dana;
	}

	public void setPopustZaPreko30Dana(Integer popustZaPreko30Dana) {
		this.popustZaPreko30Dana = popustZaPreko30Dana;
	}

	public int getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}

	public void setCenaCollisionDamageWaiver(Integer cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}

	public int getCenaPoKilometru() {
		return cenaPoKilometru;
	}

	public void setCenaPoKilometru(Integer cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}
}
