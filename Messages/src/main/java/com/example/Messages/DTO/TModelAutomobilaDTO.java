package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;

public class TModelAutomobilaDTO {
	private Long id;
	private String nazivModela;
	private Long commonDataId;
    private Long markaAutomobilaId;
    
	public TModelAutomobilaDTO() {}
	
	public TModelAutomobilaDTO(Long id, String nazivModela, Long commonDataId, Long markaAutomobilaId) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.commonDataId = commonDataId;
		this.markaAutomobilaId = markaAutomobilaId;
	}
	public TModelAutomobilaDTO(TModelAutomobila tm) {
		this(tm.getId(),tm.getNazivModela(),tm.getCommonDataId(), tm.getMarkaAutomobilaId());
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
