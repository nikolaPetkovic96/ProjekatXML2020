package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;

public class TMarkaAutomobilaDTO {    
	private long id;
    private String nazivMarke;
    private CommonDataDTO commonData;
    private List<TModelAutomobilaDTO> modelAutomobila;
    
    public TMarkaAutomobilaDTO(long id, String nazivMarke, CommonDataDTO commonData,
			List<TModelAutomobilaDTO> modelAutomobila) {
		super();
		this.id = id;
		this.nazivMarke = nazivMarke;
		this.commonData = commonData;
		this.modelAutomobila = modelAutomobila;
	}

	public TMarkaAutomobilaDTO(TMarkaAutomobila ma) {
		List<TModelAutomobilaDTO> temp=new ArrayList<TModelAutomobilaDTO>();	//popunjava listu TmodelAutommobilaDTO 
		for(TModelAutomobila t : ma.getModelAutomobila()){						//iz liste tipa TModelAutomobila
			temp.add(new TModelAutomobilaDTO(t));								//ako je potrebno jos negde, treba  izdvojiti ove 4 linije u posebnu metodu,
		}																		// al mislim da nece trebati nigde vise. Nikola
		this.id=ma.getId();
		this.nazivMarke=ma.getNazivMarke();
		this.commonData=new CommonDataDTO(ma.getCommonData());
		this.modelAutomobila=temp;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<TModelAutomobilaDTO> getModelAutomobila() {
		return modelAutomobila;
	}

	public void setModelAutomobila(List<TModelAutomobilaDTO> modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}
}
