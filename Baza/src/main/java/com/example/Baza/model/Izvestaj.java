package com.example.Baza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
@Entity
public class Izvestaj {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/KreiranjeIzvestaja")
    protected Long id; 
	
	@Column(name="narudzbenica_id")
	protected Long nar_id;
	
	@Column(name="predjena_km")
    private Long predjenaKm;
	
	@Column(name="poruka")
	private String poruka;
	
	@Column(name="common_data_id")
	private Long commonDataId;
	
//	@OneToOne
//    @MapsId
//    @JoinColumn(name = "narudzbenica_id")
//	private Narudzbenica narudzbenica;
	
	
	
	public Izvestaj() {
		super();
		
	}

	public Izvestaj(Long id, Long nar_id ,Long predjenaKm, String poruka, Long commonDataId) {
		super();
		this.id = id;
		this.nar_id=nar_id;
		this.predjenaKm = predjenaKm;
		this.poruka = poruka;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNar_id() {
		return nar_id;
	}

	public void setNar_id(Long nar_id) {
		this.nar_id = nar_id;
	}

	public Long getPredjenaKm() {
		return predjenaKm;
	}

	public void setPredjenaKm(Long predjenaKm) {
		this.predjenaKm = predjenaKm;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}	
}
