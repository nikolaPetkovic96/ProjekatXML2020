package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;

public class TTipGorivaDTO {
	private Long id;
	private String nazivTipa;
	private Long commonDataId;
	
	public TTipGorivaDTO() {}
    
	public TTipGorivaDTO(Long id, String nazivTipa, Long commonDataId) {
		super();
		this.id = id;
		this.nazivTipa = nazivTipa;
		this.commonDataId = commonDataId;
	}
	public TTipGorivaDTO(TTipGoriva tt) {
		this(tt.getId(),tt.getNazivTipa(), tt.getCommonDataId());
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
