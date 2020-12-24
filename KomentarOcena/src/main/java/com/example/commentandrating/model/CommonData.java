
package com.example.commentandrating.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommonData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "datum_kreiranja", nullable = false)
	protected LocalDateTime datumKreiranja;

	@Column(name = "datum_izmene")
	protected LocalDateTime datumIzmene;

	@Column(name = "korisnik_id")
	protected Long userId;

	public CommonData() {
		datumKreiranja = LocalDateTime.now();
		datumIzmene = datumKreiranja;
	}

	public CommonData(Long id, LocalDateTime datumKreiranja, LocalDateTime datumIzmene, Long userId) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime value) {
		this.datumKreiranja = value;
	}

	public LocalDateTime getDatumIzmene() {
		return datumIzmene;
	}

	public void setDatumIzmene(LocalDateTime value) {
		this.datumIzmene = value;
	}

	public Long getUserid() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
