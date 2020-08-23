package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;

public class OcenaDTO {

	private Long id;
	private int vrednostOcene;
	private Long commonDataId;
	private Long automobilId;
    //Jedan komentar se kreira od samo jedne firme(druga strana bidirekcije)
    private String username;
    
    
	public OcenaDTO() {
		super();
	}
	
	public OcenaDTO(Ocena o) {
		this.id = o.getId();
		this.vrednostOcene = o.getVrednostOcene();
		this.automobilId = o.getAutomobilId();
		this.commonDataId = o.getCommonDataId();
	}

	public OcenaDTO(Long id, int vrednostOcene, Long commonDataId, Long automobilId, String username) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
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

	public int getVrednostOcene() {
		return vrednostOcene;
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
