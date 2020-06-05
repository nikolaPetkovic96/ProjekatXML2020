package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.Cenovnik;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;

public class CenovnikDTO {

	private Long id;
	private Integer cenaPoDanu;
	private String nazivCenovnika;
	private Integer popustZaPreko30Dana;
	private Integer cenaCollisionDamageWaiver;
	private Integer cenaPoKilometru;
	private List<OglasDTO> oglasi;
	
	public CenovnikDTO() {
		
	}

	public CenovnikDTO(Cenovnik c) {
		this.id = c.getId();
		this.cenaPoDanu = c.getCenaPoDanu();
		this.nazivCenovnika = c.getNazivCenovnika();
		this.popustZaPreko30Dana = c.getPopustZaPreko30Dana();
		this.cenaCollisionDamageWaiver = c.getCenaCollisionDamageWaiver();
		this.cenaPoKilometru = c.getCenaPoKilometru();
		List<Oglas> tempOglasi = c.getOglasi();
		oglasi = new ArrayList<OglasDTO>();
		for(Oglas o : tempOglasi) {
			oglasi.add(new OglasDTO(o));
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCenaPoDanu() {
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

	public Integer getPopustZaPreko30Dana() {
		return popustZaPreko30Dana;
	}

	public void setPopustZaPreko30Dana(Integer popustZaPreko30Dana) {
		this.popustZaPreko30Dana = popustZaPreko30Dana;
	}

	public Integer getCenaCollisionDamageWaiver() {
		return cenaCollisionDamageWaiver;
	}

	public void setCenaCollisionDamageWaiver(Integer cenaCollisionDamageWaiver) {
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
	}

	public Integer getCenaPoKilometru() {
		return cenaPoKilometru;
	}

	public void setCenaPoKilometru(Integer cenaPoKilometru) {
		this.cenaPoKilometru = cenaPoKilometru;
	}

	public List<OglasDTO> getOglasi() {
		return oglasi;
	}

	public void setOglasi(List<OglasDTO> oglasi) {
		this.oglasi = oglasi;
	}

	public CenovnikDTO(Long id, Integer cenaPoDanu, String nazivCenovnika, Integer popustZaPreko30Dana,
			Integer cenaCollisionDamageWaiver, Integer cenaPoKilometru, List<OglasDTO> oglasi) {
		super();
		this.id = id;
		this.cenaPoDanu = cenaPoDanu;
		this.nazivCenovnika = nazivCenovnika;
		this.popustZaPreko30Dana = popustZaPreko30Dana;
		this.cenaCollisionDamageWaiver = cenaCollisionDamageWaiver;
		this.cenaPoKilometru = cenaPoKilometru;
		this.oglasi = oglasi;
	}
	
	
	
	

	
	
	
}
