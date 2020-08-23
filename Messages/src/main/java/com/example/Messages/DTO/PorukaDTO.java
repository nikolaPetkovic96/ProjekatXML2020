package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Poruka;

public class PorukaDTO {

	private Long id;
	private String tekstPoruke;
	private Long rezervacijaId;
	private Long commonDataId;
	private Long automobilId;
	//Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
    private String username;

	public PorukaDTO() {
		
	}
	
	public PorukaDTO(Poruka p) {
		this.id =p.getId();
		this.tekstPoruke = p.getTekstPoruke();
		this.rezervacijaId = p.getRezervacijaId();
		this.commonDataId = p.getCommonDataId();
		this.automobilId = p.getAutomobilId();
	
	}
	
	public PorukaDTO(Long id, String tekstPoruke, Long rezervacijaId,
			Long commonDataId, Long automobilId, String username) {
		super();
		this.id = id;
		this.tekstPoruke = tekstPoruke;
		this.rezervacijaId = rezervacijaId;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTekstPoruke() {
		return tekstPoruke;
	}

	public void setTekstPoruke(String tekstPoruke) {
		this.tekstPoruke = tekstPoruke;
	}

	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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
	
}
