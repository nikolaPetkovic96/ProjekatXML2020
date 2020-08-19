package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;

public class TKlasaAutomobilaDTO {
    private Long id;
    private String nazivKlase;
    private Long commonDataId;
    
    public TKlasaAutomobilaDTO() {}
    
	public TKlasaAutomobilaDTO(Long id, String nazivKlase, Long commonDataId) {
		super();
		this.id = id;
		this.nazivKlase = nazivKlase;
		this.commonDataId = commonDataId;
	}
	public TKlasaAutomobilaDTO(TKlasaAutomobila tk) {
		this(tk.getId(),tk.getNazivKlase(), tk.getCommonDataId());		
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
