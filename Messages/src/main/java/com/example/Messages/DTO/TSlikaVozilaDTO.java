package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;

public class TSlikaVozilaDTO {
    private Long id;
    private byte[] slika;
    private Long commonDataId;
    private Long automobilId;
    
	public TSlikaVozilaDTO() {}
    
	public TSlikaVozilaDTO(Long id, byte[] slika, Long commonDataId, Long automobilId) {
		super();
		this.id = id;
		this.slika = slika;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
	}
    
	public TSlikaVozilaDTO(TSlikaVozila ts) {
		this(ts.getId(), ts.getSlika(), ts.getCommonDataId(), ts.getAutomobilId());
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

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	
}
