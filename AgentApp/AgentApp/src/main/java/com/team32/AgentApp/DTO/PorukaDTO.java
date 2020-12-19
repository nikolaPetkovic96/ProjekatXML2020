package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;

import com.team32.AgentApp.model.entitet.Poruka;

public class PorukaDTO {

	private Long id;
	private String tekstPoruke;
	private Long rezervacijaId;
	private Long commonDataId;
	private Long automobilId;
    private String username;
    private LocalDateTime datumKreiranja;

	public PorukaDTO() {
		
	}
	
	public PorukaDTO(Poruka p, String username, LocalDateTime datumKreiranja) {
		this.id = p.getId();
		this.tekstPoruke = p.getTekstPoruke();
		this.rezervacijaId = p.getRezervacijaId();
		this.automobilId = p.getAutomobilId();
		this.commonDataId = p.getCommonDataId();
		this.username = username;
		this.datumKreiranja = datumKreiranja;
	}
	
	public PorukaDTO(Long id, String tekstPoruke, Long rezervacijaId, Long automobilId, Long commonDataId, String username, LocalDateTime datumKreiranja) {
		super();
		this.id = id;
		this.tekstPoruke = tekstPoruke;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
		this.username = username;
		this.datumKreiranja = datumKreiranja;
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
	
	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	
}
