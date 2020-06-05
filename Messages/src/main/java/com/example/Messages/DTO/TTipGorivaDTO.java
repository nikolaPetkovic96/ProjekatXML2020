package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;

public class TTipGorivaDTO {
	private long id;
	private String nazivTipa;
	private CommonDataDTO commonData;
    
	public TTipGorivaDTO(long id, String nazivTipa, CommonDataDTO commonData) {
		super();
		this.id = id;
		this.nazivTipa = nazivTipa;
		this.commonData = commonData;
	}
	public TTipGorivaDTO(TTipGoriva tt) {
		this(tt.getId(),tt.getNazivTipa(),new CommonDataDTO(tt.getCommonData()));
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNazivTipa() {
		return nazivTipa;
	}
	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}
	public CommonDataDTO getCommonData() {
		return commonData;
	}
	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
}
