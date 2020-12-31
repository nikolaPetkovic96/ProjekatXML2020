
package com.example.commentandrating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ocena {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "vredn_ocene")
	protected int vrednostOcene;

	@Column(name = "common_data_id")
	protected Long commonDataId;

	@Column(name = "automobil_id")
	private Long automobilId;

	@Column(name = "rezervacija_id")
	private Long rezervacijaId;

	private String autor;

	public Ocena() {
		super();
	}

	public Ocena(Long id, int vrednostOcene, Long commonDataId, Long automobilId, Long rezervacijaId) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public int getVrednostOcene() {
		return vrednostOcene;
	}

	public void setVrednostOcene(int value) {
		this.vrednostOcene = value;
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

	public Long getRezervacijaId() {
		return rezervacijaId;
	}

	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
