package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Komentar;

public class KomentarNewDTO {
	
	private Long id;
	private String tekstKomentara;
	private boolean odobren;
	private Long automobilId;
	private Long rezervacijaId;

    private String username;
    
	public KomentarNewDTO() {
		
	}
	
	public KomentarNewDTO(Komentar k) {
		this.id = k.getId();
		this.tekstKomentara = k.getTekstKomentara();
		this.odobren = k.isOdobren();
		this.rezervacijaId = k.getRezervacijaId();
		this.automobilId = k.getAutomobilId();

	}
	
	public KomentarNewDTO(Long id, String tekstKomentara, boolean odobren, Long rezervacijaId,Long automobilId, String username) {
		super();
		this.id = id;
		this.tekstKomentara = tekstKomentara;
		this.odobren = odobren;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
		this.username = username;
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
	
	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	
}
