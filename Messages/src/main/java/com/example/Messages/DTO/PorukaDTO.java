package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Poruka;

public class PorukaDTO {

	
	private Long id;
	private CommonDataDTO commonData;
	private String tekstPoruke;
	
	public PorukaDTO() {
		
	}
	
	public PorukaDTO(Poruka p) {
		this.id =p.getId();
		this.tekstPoruke = p.getTekstPoruke();
		this.commonData = new CommonDataDTO(p.getCommonData()); 
	}
	
	public PorukaDTO(Long id, CommonDataDTO commonData, String tekstPoruke) {
		super();
		this.id = id;
		this.commonData = commonData;
		this.tekstPoruke = tekstPoruke;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CommonDataDTO getCommonData() {
		return commonData;
	}
	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
	public String getTekstPoruke() {
		return tekstPoruke;
	}
	public void setTekstPoruke(String tekstPoruke) {
		this.tekstPoruke = tekstPoruke;
	}
	
	
}
