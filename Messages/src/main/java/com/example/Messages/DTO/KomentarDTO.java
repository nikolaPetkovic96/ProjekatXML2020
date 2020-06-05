package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;

public class KomentarDTO {
	
	private long id;
	private String tekstKomentara;
	private boolean odobren;
	private CommonDataDTO commonData;
	
	public KomentarDTO() {
		
	}
	
	public KomentarDTO(long id, String tekstKomentara, boolean odobren, CommonDataDTO commonData) {
		super();
		this.id = id;
		this.tekstKomentara = tekstKomentara;
		this.odobren = odobren;
		this.commonData = commonData;
	}

	public KomentarDTO(Komentar k) {
		this.id = k.getId();
		this.tekstKomentara = k.getTekstKomentara();
		this.odobren = k.isOdobren();
		this.commonData = new CommonDataDTO(k.getCommonData());
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getTekstKomentara() {
		return tekstKomentara;
	}
	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}
	public boolean isOdobren() {
		return odobren;
	}
	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	public CommonDataDTO getCommonData() {
		return commonData;
	}
	public void setCommonData(CommonDataDTO commonData) {
		this.commonData = commonData;
	}
	
}
