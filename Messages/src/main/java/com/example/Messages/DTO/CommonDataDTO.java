package com.example.Messages.DTO;

import java.util.Date;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;

public class CommonDataDTO {

	private long id;
	private Date datumKreiranja;
	private Date datumIzmene;
	
	public CommonDataDTO() {
		
	}
	
	
	
	public CommonDataDTO(long id, Date datumKreiranja, Date datumIzmene) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
	}

	public CommonDataDTO(CommonData c) {
		this(c.getId(), c.getDatumKreiranja(), c.getDatumIzmene());
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public Date getDatumIzmene() {
		return datumIzmene;
	}
	public void setDatumIzmene(Date datumIzmene) {
		this.datumIzmene = datumIzmene;
	}
	
	
	
}
