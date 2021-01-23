package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.KlasaAutomobila;

public class KlasaAutomobilaDTO {
    private Long id;
    private String nazivKlase;
    private Long commonDataId;
    
    public KlasaAutomobilaDTO() {}
    
	public KlasaAutomobilaDTO(Long id, String nazivKlase, Long commonDataId) {
		super();
		this.id = id;
		this.nazivKlase = nazivKlase;
		this.commonDataId = commonDataId;
	}
	public KlasaAutomobilaDTO(KlasaAutomobila k) {
		this(k.getId(),k.getNazivKlase(), k.getCommonDataId());		
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
