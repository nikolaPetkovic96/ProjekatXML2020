package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;

public class KomentarDTO {
	
	private Long id;
	private String tekstKomentara;
	private boolean odobren;
	private Long commonDataId;
	private Long automobilId;
    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
    private String username;

    
	public KomentarDTO() {
		
	}
	
	public KomentarDTO(Long id, String tekstKomentara, boolean odobren, Long commonDataId,Long automobilId, String username) {
		super();
		this.id = id;
		this.tekstKomentara = tekstKomentara;
		this.odobren = odobren;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.username = username;
	}

	public KomentarDTO(Komentar k) {
		this.id = k.getId();
		this.tekstKomentara = k.getTekstKomentara();
		this.odobren = k.isOdobren();
		this.commonDataId = k.getCommonDataId();
		this.automobilId = k.getAutomobilId();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public Long getCommonDataId() {
		return commonDataId;
	}
	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
}
