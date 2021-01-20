package com.example.sync.dto.automobil.carClass;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Klasa", propOrder = { "id", "commonDataId", "nazivKlase" })
@XmlRootElement(name = "Klasa")
public class Klasa {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "Name", required = true)
	protected String nazivKlase;

	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	public Klasa() {
		// TODO Auto-generated constructor stub
	}
	public Klasa(Long id, String nazivKlase, Long commonDataId) {
		super();
		this.id = id;
		this.nazivKlase = nazivKlase;
		this.commonDataId = commonDataId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivKlase() {
		return nazivKlase;
	}
	public void setNazivKlase(String nazivKlase) {
		this.nazivKlase = nazivKlase;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
