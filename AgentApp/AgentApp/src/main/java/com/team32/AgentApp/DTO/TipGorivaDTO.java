package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.tentitet.TipGoriva;

public class TipGorivaDTO {
	private Long id;
	private String nazivTipa;
	private Long commonDataId;
	
	public TipGorivaDTO() {}
    
	public TipGorivaDTO(Long id, String nazivTipa, Long commonDataId) {
		super();
		this.id = id;
		this.nazivTipa = nazivTipa;
		this.commonDataId = commonDataId;
	}
	public TipGorivaDTO(TipGoriva tg) {
		this(tg.getId(), tg.getNazivTipa(), tg.getCommonDataId());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivTipa() {
		return nazivTipa;
	}
	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

}
