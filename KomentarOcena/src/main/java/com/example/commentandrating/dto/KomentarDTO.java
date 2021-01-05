
package com.example.commentandrating.dto;

import java.time.LocalDateTime;

public class KomentarDTO {

	protected Long id;
	protected String tekstKomentara, autor;
	protected boolean odobren;
	private Long automobilId;
	private Long rezervacijaId;
	protected LocalDateTime datumIzmene, datumKreiranja;
	
	private long autorId; 
	
	public KomentarDTO(Long id, String tekstKomentara, String autor, boolean odobren, Long automobilId,
			Long rezervacijaId, LocalDateTime datumIzmene, LocalDateTime datumKreiranja, long autorId) {
		super();
		this.id = id;
		this.tekstKomentara = tekstKomentara;
		this.autor = autor;
		this.odobren = odobren;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.datumIzmene = datumIzmene;
		this.autor=autor;
		this.datumKreiranja = datumKreiranja;
		this.autorId = autorId;
	}

	public long getAutorId() {
		return autorId;
	}

	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTekstKomentara() {
		return tekstKomentara;
	}

	public void setTekstKomentara(String tekstKomentara) {
		this.tekstKomentara = tekstKomentara;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
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

	public KomentarDTO() {
	}
}