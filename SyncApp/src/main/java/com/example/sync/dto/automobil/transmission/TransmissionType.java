package com.example.sync.dto.automobil.transmission;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransmissionType", propOrder = { "id", "commonDataId", "nazivTipa" })
@XmlRootElement(name = "TransmissionType")
public class TransmissionType {

	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "Name", required = true)
	protected String nazivTipa;

	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;

	public TransmissionType() {
	}

	public TransmissionType(Long id, String nazivTipa, Long commonDataId) {
		super();
		this.id = id;
		this.nazivTipa = nazivTipa;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public String getNazivTipa() {
		return nazivTipa;
	}

	public void setNazivTipa(String value) {
		this.nazivTipa = value;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
