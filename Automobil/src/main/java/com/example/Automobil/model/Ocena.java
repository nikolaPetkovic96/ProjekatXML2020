
package com.example.Automobil.model;

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
	
	@Column(name = "tekst")
	private String tekst;
	
	@Column(name="odobren")
	private boolean odobren;

	public Ocena() {
		super();
	}

	public Ocena(Long id, int vrednostOcene, Long commonDataId, Long automobilId, Long rezervacijaId,String tekst, boolean odobren) {
		super();
		this.id = id;
		this.vrednostOcene = vrednostOcene;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.rezervacijaId = rezervacijaId;
		this.tekst=tekst;
		this.odobren=odobren;
		
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

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public boolean getOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
}
