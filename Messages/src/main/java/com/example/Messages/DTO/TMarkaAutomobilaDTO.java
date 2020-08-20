package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;

public class TMarkaAutomobilaDTO {    
	private Long id;
    private String nazivMarke;
    private Long commonDataId;
    
    public TMarkaAutomobilaDTO() {}
    
    public TMarkaAutomobilaDTO(Long id, String nazivMarke, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonDataId = commonDataId;
	
	}

	public TMarkaAutomobilaDTO(TMarkaAutomobila ma) {														
		this.id=ma.getId();
		this.nazivMarke=ma.getNazivMarke();
		this.commonDataId= ma.getCommonDataId();	
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
