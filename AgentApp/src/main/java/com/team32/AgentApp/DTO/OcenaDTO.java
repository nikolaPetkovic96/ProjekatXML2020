package com.team32.AgentApp.DTO;

import com.team32.AgentApp.model.entitet.Ocena;

public class OcenaDTO {

	private Long id;
	private int vrednostOcene;
	private Long automobilId;
	private Long rezervacijaId;
	private Long commonDataId;
    private String username;
    
    
	public OcenaDTO() {
		super();
	}
	
	public OcenaDTO(Ocena o) {
		this.id = o.getId();
		this.vrednostOcene = o.getVrednostOcene();
		this.automobilId = o.getAutomobilId();
		this.rezervacijaId =  o.getRezervacijaId();
		this.commonDataId = o.getCommonDataId();
	}
	
	public OcenaDTO(Ocena o, String username) {
		this.id = o.getId();
		this.vrednostOcene = o.getVrednostOcene();
		this.automobilId = o.getAutomobilId();
		this.rezervacijaId =  o.getRezervacijaId();
		this.commonDataId = o.getCommonDataId();
		this.username = username;
	}

	public OcenaDTO(Long id, int vrednostOcene, Long rezervacijaId, Long automobilId, Long commonDataId, String username) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
		this.rezervacijaId = rezervacijaId;
		this.automobilId = automobilId;
		this.commonDataId = commonDataId;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVrednostOcene() {
		return vrednostOcene;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}
	
	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public void setVrednostOcene(int vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
