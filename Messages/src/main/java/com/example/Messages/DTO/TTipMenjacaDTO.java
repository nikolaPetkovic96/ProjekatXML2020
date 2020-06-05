package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;

public class TTipMenjacaDTO {
    private long id;
    private String nazivMenjaca;
    private CommonDataDTO commonData;
    
	public TTipMenjacaDTO(long id, String nazivMenjaca, CommonDataDTO commonData) {
		super();
		this.id = id;
		this.nazivMenjaca = nazivMenjaca;
		this.commonData = commonData;
	}
    
	public TTipMenjacaDTO(TTipMenjaca tt) {
		this(tt.getId(),tt.getNazivMenjaca(),new CommonDataDTO(tt.getCommonData()));
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazivMenjaca() {
		return nazivMenjaca;
	}

	public void setNazivMenjaca(String nazivMenjaca) {
		this.nazivMenjaca = nazivMenjaca;
	}

	public CommonDataDTO getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}	
}
