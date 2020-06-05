package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.entitet.Ocena;

public class OcenaDTO {

	private long id;
	private int vrednostOcene;
	
	public OcenaDTO() {
		
	}
	
	public OcenaDTO(Ocena o) {
		this(o.getId(), o.getVrednostOcene());
	}
	
	public OcenaDTO(long id, int vrednostOcene) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getVrednostOcene() {
		return vrednostOcene;
	}
	public void setVrednostOcene(int vrednostOcene) {
		this.vrednostOcene = vrednostOcene;
	}
	
	
}
