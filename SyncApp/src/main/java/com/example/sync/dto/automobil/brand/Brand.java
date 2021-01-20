package com.example.sync.dto.automobil.brand;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Brand", propOrder = { "id", "commonDataId", "nazivMarke" })
@XmlRootElement(name = "Brand")
public class Brand {
	
	@XmlElement(name = "Id", required = true)
    protected Long id;
	
    @XmlElement(name = "Name", required = true)
    protected String nazivMarke;
	
    @XmlElement(name = "CommonDataId", required = true)
    protected Long commonDataId;

	public Brand(Long id, String nazivMarke, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonDataId = commonDataId;
	}

	public Brand() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivMarke() {
		return nazivMarke;
	}

	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
}
