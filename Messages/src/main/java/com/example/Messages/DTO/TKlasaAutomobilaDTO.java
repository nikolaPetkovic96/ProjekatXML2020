package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;

public class TKlasaAutomobilaDTO {
    private Long id;
    private String nazivKlase;
    private CommonDataDTO commonData;
    
    public TKlasaAutomobilaDTO() {}
    
	public TKlasaAutomobilaDTO(Long id, String nazivKlase, CommonDataDTO commonData) {
		super();
		this.id = id;
		this.nazivKlase = nazivKlase;
		this.commonData = commonData;
	}
	public TKlasaAutomobilaDTO(TKlasaAutomobila tk) {
		this(tk.getId(),tk.getNazivKlase(),new CommonDataDTO(tk.getCommonData()));		
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
	public CommonDataDTO getCommonData() {
		return commonData;
	}
	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
}
