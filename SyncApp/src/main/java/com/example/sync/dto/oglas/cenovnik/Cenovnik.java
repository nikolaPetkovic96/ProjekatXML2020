package com.example.sync.dto.oglas.cenovnik;    

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cenovnik", propOrder = { "id", "commonDataId", "cenaPoDanu","nazivCenovnika",
											"popustZaPreko30Dana","cenaCollisionDamageWaiver","cenaPoKilometru" })
@XmlRootElement(name = "Cenovnik")
public class Cenovnik {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;
	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	@XmlElement(name = "CenaPoDanu", required = true)
    protected float cenaPoDanu;
	@XmlElement(name = "NazivCenovnika", required = true)
    protected String nazivCenovnika;
	@XmlElement(name = "PopustZaPreko30Dana", required = true)
	protected float popustZaPreko30Dana;
	@XmlElement(name = "CenaCollisionDamageWaiver", required = true)
	protected float cenaCollisionDamageWaiver;
	@XmlElement(name = "CenaPoKilometru", required = true)
	protected float cenaPoKilometru;


	public Cenovnik() {
		// TODO Auto-generated constructor stub
	}

	public Cenovnik(Long id, Long commonDataId, float cenaPoDanu, String nazivCenovnika, float popustZaPreko30Dana,
			float cenaCollisionDamageWaiver, float cenaPoKilometru) {
		super();
		this.id = id;
		this.commonDataId = commonDataId;
		this.cenaPoDanu = cenaPoDanu;
		this.nazivCenovnika = nazivCenovnika;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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

}
