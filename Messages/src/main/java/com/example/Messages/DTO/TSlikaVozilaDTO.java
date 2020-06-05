package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;

public class TSlikaVozilaDTO {
    private Long id;
    private byte[] slika;
    private CommonDataDTO commonData;
    private TAutomobilaDTO tAutomobila;
    
	public TSlikaVozilaDTO() {}
    
	public TSlikaVozilaDTO(Long id, byte[] slika, CommonDataDTO commonData, TAutomobilaDTO tAutomobila) {
		super();
		this.id = id;
		this.slika = slika;
		this.commonData = commonData;
		this.tAutomobila = tAutomobila;
	}
    
	public TSlikaVozilaDTO(TSlikaVozila ts) {
		this(ts.getId(),ts.getSlika(),new CommonDataDTO(ts.getCommonData()),new TAutomobilaDTO(ts.gettAutomobila()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public CommonDataDTO getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}

	public TAutomobilaDTO gettAutomobila() {
		return tAutomobila;
	}

	public void settAutomobila(TAutomobilaDTO tAutomobila) {
		this.tAutomobila = tAutomobila;
	}
}
