package com.example.Reservation.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

@Entity
public class Narudzbenica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/KreiranjeNarudzbenice")
    protected Long id; 

    @XmlElement(name = "Od_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime odDatuma;
    
    @XmlElement(name = "Do_datuma", namespace = "http://www.ftn.uns.ac.rs/KreiranjeOglasa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected LocalDateTime  doDatuma;
    
    @Column(name="user_id")
    protected Long userId;
    
    @Column(name="oglas_id")
    protected Long oglasId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="rez_id") //rezervacija kojoj pripada narudzenica
    protected Long rezId;
    
    @OneToOne(mappedBy = "narudzbenica_id", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    protected  Izvestaj izvestaj;
    
    public Narudzbenica() {
    	super();
    }

	public Narudzbenica(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long userId, Long oglasId, Long rezId,
			Izvestaj izvestaj) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.userId = userId;
		this.oglasId = oglasId;
		this.rezId = rezId;
		this.izvestaj = izvestaj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(LocalDateTime odDatuma) {
		this.odDatuma = odDatuma;
	}

	public LocalDateTime getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(LocalDateTime doDatuma) {
		this.doDatuma = doDatuma;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOglasId() {
		return oglasId;
	}

	public void setOglasId(Long oglasId) {
		this.oglasId = oglasId;
	}

	public Long getRezId() {
		return rezId;
	}

	public void setRezId(Long rezId) {
		this.rezId = rezId;
	}

	public Izvestaj getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(Izvestaj izvestaj) {
		this.izvestaj = izvestaj;
	}  
}
