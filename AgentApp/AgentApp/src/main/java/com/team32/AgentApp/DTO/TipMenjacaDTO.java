package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.TipMenjaca;

public class TipMenjacaDTO {
    private Long id;
    private String nazivMenjaca;
    private Long commonDataId;
    
    public TipMenjacaDTO() {}
    
	public TipMenjacaDTO(Long id, String nazivMenjaca, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMenjaca = nazivMenjaca;
		this.commonDataId = commonDataId;
	}
    
	public TipMenjacaDTO(TipMenjaca tm) {
		this(tm.getId(), tm.getNazivMenjaca(), tm.getCommonDataId());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivMenjaca() {
		return nazivMenjaca;
	}

	public void setNazivMenjaca(String nazivMenjaca) {
		this.nazivMenjaca = nazivMenjaca;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
