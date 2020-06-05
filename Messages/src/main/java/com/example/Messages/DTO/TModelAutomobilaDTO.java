package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;

public class TModelAutomobilaDTO {
	private long id;
	private String nazivModela;
	private CommonDataDTO commonData;
    private TMarkaAutomobilaDTO markaAutomobila;
    
	public TModelAutomobilaDTO(long id, String nazivModela, CommonDataDTO commonData,
			TMarkaAutomobilaDTO markaAutomobila) {
		super();
		this.id = id;
		this.nazivModela = nazivModela;
		this.commonData = commonData;
		this.markaAutomobila = markaAutomobila;
	}
	public TModelAutomobilaDTO(TModelAutomobila tm) {
		this(tm.getId(),tm.getNazivModela(),new CommonDataDTO(tm.getCommonData()),new TMarkaAutomobilaDTO(tm.getMarkaAutomobila()));
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNazivModela() {
		return nazivModela;
	}
	public void setNazivModela(String nazivModela) {
		this.nazivModela = nazivModela;
	}
	public CommonDataDTO getCommonData() {
		return commonData;
	}
	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
	public TMarkaAutomobilaDTO getMarkaAutomobila() {
		return markaAutomobila;
	}
	public void setMarkaAutomobila(TMarkaAutomobilaDTO markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}	
}
