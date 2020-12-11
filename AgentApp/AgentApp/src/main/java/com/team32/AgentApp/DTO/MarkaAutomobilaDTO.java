package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.MarkaAutomobila;

public class MarkaAutomobilaDTO {    
	private Long id;
    private String nazivMarke;
    private Long commonDataId;
    
    public MarkaAutomobilaDTO() {}
    
    public MarkaAutomobilaDTO(Long id, String nazivMarke, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonDataId = commonDataId;
	
	}

	public MarkaAutomobilaDTO(MarkaAutomobila ma) {														
		this(
			ma.getId(),
			ma.getNazivMarke(),
			ma.getCommonDataId()
			);
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
