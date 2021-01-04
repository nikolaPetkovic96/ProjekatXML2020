package com.example.Automobil.dto;

import com.example.Automobil.model.Ocena;

public class RecenzijaDTO {
	Long id;
	String username;
	String text;
	int star;
	boolean odobren;
	
	public RecenzijaDTO() {
		super();
	}

	public RecenzijaDTO(Long id, String username, String text, int star, boolean odobren) {
		super();
		this.id = id;
		this.username = username;
		this.text = text;
		this.star = star;
		this.odobren = odobren;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
}
