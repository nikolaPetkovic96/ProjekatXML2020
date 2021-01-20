package com.example.sync.dto.automobil.slika;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Slika", propOrder = { "id", "commonDataId", "automobilId", "slika" })
@XmlRootElement(name = "Slika")
public class Slika {
	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name = "AutomobilId", required = true)
    private Long automobilId;

	@XmlElement(name = "Slika", required = true)
	protected String[] slika;

	public Slika() {
		// TODO Auto-generated constructor stub
	}

	public Slika(Long id, String[] slika, Long commonDataId, Long automobilId) {
		super();
		this.id = id;
		this.slika = slika;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getSlika() {
		return slika;
	}

	public void setSlika(String[] slika) {
		this.slika = slika;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
}
