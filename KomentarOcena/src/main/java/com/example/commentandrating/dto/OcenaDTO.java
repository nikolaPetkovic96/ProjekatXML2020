package com.example.commentandrating.dto;

import java.time.LocalDateTime;

public class OcenaDTO {

	private Long id;
	private int vrednostOcene;
	private Long automobilId;
	private Long rezervacijaId;
	private String username;
	protected LocalDateTime datumIzmene, datumKreiranja;

	public OcenaDTO() {
	}

	public OcenaDTO(Long id, int vrednostOcene, Long automobilId, Long rezervacijaId, String username,
			LocalDateTime datumIzmene, LocalDateTime datumKreiranja) {
		this.id = id;
		this.vrednostOcene = vrednostOcene;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.username = username;
		this.datumIzmene = datumIzmene;
		this.datumKreiranja = datumKreiranja;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDatumIzmene() {
		return datumIzmene;
	}

	public void setDatumIzmene(LocalDateTime datumIzmene) {
		this.datumIzmene = datumIzmene;
	}

	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
}
