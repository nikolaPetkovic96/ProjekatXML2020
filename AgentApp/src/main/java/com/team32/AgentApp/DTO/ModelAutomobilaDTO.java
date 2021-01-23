package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.ModelAutomobila;

public class ModelAutomobilaDTO {
	private Long id;
	private String nazivModela;
    private Long markaAutomobilaId;
	private Long commonDataId;
    
	public ModelAutomobilaDTO() {}
	
	public ModelAutomobilaDTO(Long id, String nazivModela, Long markaAutomobilaId, Long commonDataId) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.markaAutomobilaId = markaAutomobilaId;
		this.commonDataId = commonDataId;
	}
	public ModelAutomobilaDTO(ModelAutomobila m) {
		this(m.getId(), m.getNazivModela(), m.getMarkaAutomobilaId(), m.getCommonDataId());
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
	
	public Long getMarkaAutomobilaId() {
		return markaAutomobilaId;
	}

	public void setMarkaAutomobilaId(Long markaAutomobilaId) {
		this.markaAutomobilaId = markaAutomobilaId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
