package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;

public class TTipMenjacaDTO {
    private Long id;
    private String nazivMenjaca;
    private Long commonDataId;
    
    public TTipMenjacaDTO() {}
    
	public TTipMenjacaDTO(Long id, String nazivMenjaca, Long commonDataId) {
		super();
		this.id = id;
		this.nazivMenjaca = nazivMenjaca;
		this.commonDataId = commonDataId;
	}
    
	public TTipMenjacaDTO(TTipMenjaca tt) {
		this(tt.getId(),tt.getNazivMenjaca(), tt.getCommonDataId());
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
