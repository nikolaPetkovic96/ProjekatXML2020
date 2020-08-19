//package com.example.Messages.DTO;
//
//import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
//
//public class TSlikaVozilaDTO {
//    private Long id;
//    private byte[] slika;
//    private CommonDataDTO commonData;
//    private AutomobilDTO automobil;
//    
//	public TSlikaVozilaDTO() {}
//    
//	public TSlikaVozilaDTO(Long id, byte[] slika, CommonDataDTO commonData, AutomobilDTO automobil) {
//		super();
//		this.id = id;
//		this.slika = slika;
//		this.commonData = commonData;
//		this.automobil = automobil;
//	}
//    
//	public TSlikaVozilaDTO(TSlikaVozila ts) {
//		this(ts.getId(),ts.getSlika(),new CommonDataDTO(ts.getCommonData()),new AutomobilDTO(ts.getAutomobil()));
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public byte[] getSlika() {
//		return slika;
//	}
//
//	public void setSlika(byte[] slika) {
//		this.slika = slika;
//	}
//
//	public CommonDataDTO getCommonData() {
//		return commonData;
//	}
//
//	public void setCommonData(CommonDataDTO commonData) {
//		this.commonData = commonData;
//	}
//
//	public AutomobilDTO getAutomobil() {
//		return automobil;
//	}
//
//	public void setAutomobil(AutomobilDTO automobil) {
//		this.automobil = automobil;
//	}
//
//
//}
