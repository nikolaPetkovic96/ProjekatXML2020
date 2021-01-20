package com.example.sync.dto.automobil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Model", propOrder = { "id", "commonDataId", "nazivModela","markaAutomobilaId" })
@XmlRootElement(name = "Model")
public class Model {

	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "Name", required = true)
	protected String nazivModela;

	@XmlElement(name = "CommonDataId", required = true)
	protected Long commonDataId;
	
	@XmlElement(name="MarkaAutomobilaId", required = true)
    private Long markaAutomobilaId;

	public Model() {
		
	}

	public Model(Long id, String nazivModela, Long commonDataId, Long markaAutomobilaId) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.commonDataId = commonDataId;
		this.markaAutomobilaId = markaAutomobilaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivModela() {
		return nazivModela;
	}

	public void setNazivModela(String nazivModela) {
		this.nazivModela = nazivModela;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public Long getMarkaAutomobilaId() {
		return markaAutomobilaId;
	}

	public void setMarkaAutomobilaId(Long markaAutomobilaId) {
		this.markaAutomobilaId = markaAutomobilaId;
	}
	
}
