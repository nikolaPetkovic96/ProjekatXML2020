package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.SlikaVozila;

public class SlikaVozilaDTO {
    private Long id;
    private String[] slika;
    private Long automobilId;
    private Long commonDataId;
    
	public SlikaVozilaDTO() {}
    
	public SlikaVozilaDTO(Long id, String[] slika, Long automobilId, Long commonDataId) {
		super();
		this.id = id;
		this.slika = slika;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
	}
    
	public SlikaVozilaDTO(SlikaVozila s) {
		this(s.getId(), s.getSlika(), s.getAutomobilId(), s.getCommonDataId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getSlika() {
		return slika;
	}

	public void setSlika(String[] slika) {
		this.slika = slika;
	}
	
	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
