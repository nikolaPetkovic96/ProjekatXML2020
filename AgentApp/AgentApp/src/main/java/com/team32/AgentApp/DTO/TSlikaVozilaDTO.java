package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.SlikaVozila;

public class TSlikaVozilaDTO {
    private Long id;
    private byte[] slika;
    private Long automobilId;
    private Long commonDataId;
    
	public TSlikaVozilaDTO() {}
    
	public TSlikaVozilaDTO(Long id, byte[] slika, Long automobilId, Long commonDataId) {
		super();
		this.id = id;
		this.slika = slika;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
	}
    
	public TSlikaVozilaDTO(SlikaVozila s) {
		this(s.getId(), s.getSlika(), s.getCommonDataId(), s.getAutomobilId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
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
