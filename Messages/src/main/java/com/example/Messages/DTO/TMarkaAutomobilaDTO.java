package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;

public class TMarkaAutomobilaDTO {    
	private Long id;
    private String nazivMarke;
    private CommonDataDTO commonData;
    
    public TMarkaAutomobilaDTO() {}
    
    public TMarkaAutomobilaDTO(Long id, String nazivMarke, CommonDataDTO commonData,
			List<TModelAutomobilaDTO> modelAutomobila) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonData = commonData;
	
	}

	public TMarkaAutomobilaDTO(TMarkaAutomobila ma) {														
		this.id=ma.getId();
		this.nazivMarke=ma.getNazivMarke();
		this.commonData=new CommonDataDTO(ma.getCommonData());	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivMarke() {
		return nazivMarke;
	}

	public void setNazivMarke(String nazivMarke) {
		this.nazivMarke = nazivMarke;
	}

	public CommonDataDTO getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}

}
