package com.example.Automobil.dto;

import java.util.List;
public class AutomobilPomDTO {

	private Long id;
	private Long markaAutomobilaId;
	private Long modelAutomobilaId;
	private Long klasaAutomobilaId;
	private Long vrstaGorivaId;
	private Long tipMenjacaId;
	private float predjenaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	private Long commonDataId;

	private List<byte[]> slike;
	private String MarkaNaziv;
	private String modelNaziv;
	private String klasaNaziv;

	private Long user_id;
	private String username;
	
	private float ukupnaOcena;

	public AutomobilPomDTO(Long id, Long markaAutomobilaId, Long modelAutomobilaId, Long klasaAutomobilaId,
			Long vrstaGorivaId, Long tipMenjacaId, float predjenaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu, Long commonDataId, List<byte[]> slike,
			String markaNaziv, String modelNaziv, String klasaNaziv, Long string, String username, float ukupnaOcena) {
		super();
		this.id = id;
		this.markaAutomobilaId = markaAutomobilaId;
		this.modelAutomobilaId = modelAutomobilaId;
		this.klasaAutomobilaId = klasaAutomobilaId;
		this.vrstaGorivaId = vrstaGorivaId;
		this.tipMenjacaId = tipMenjacaId;
		this.predjenaKilometraza = predjenaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.commonDataId = commonDataId;
		this.slike = slike;
		MarkaNaziv = markaNaziv;
		this.modelNaziv = modelNaziv;
		this.klasaNaziv = klasaNaziv;
		this.user_id = string;
		this.username = username;
		this.ukupnaOcena = ukupnaOcena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMarkaAutomobilaId() {
		return markaAutomobilaId;
	}

	public void setMarkaAutomobilaId(Long markaAutomobilaId) {
		this.markaAutomobilaId = markaAutomobilaId;
	}

	public Long getModelAutomobilaId() {
		return modelAutomobilaId;
	}

	public void setModelAutomobilaId(Long modelAutomobilaId) {
		this.modelAutomobilaId = modelAutomobilaId;
	}

	public Long getKlasaAutomobilaId() {
		return klasaAutomobilaId;
	}

	public void setKlasaAutomobilaId(Long klasaAutomobilaId) {
		this.klasaAutomobilaId = klasaAutomobilaId;
	}

	public Long getVrstaGorivaId() {
		return vrstaGorivaId;
	}

	public void setVrstaGorivaId(Long vrstaGorivaId) {
		this.vrstaGorivaId = vrstaGorivaId;
	}

	public Long getTipMenjacaId() {
		return tipMenjacaId;
	}

	public void setTipMenjacaId(Long tipMenjacaId) {
		this.tipMenjacaId = tipMenjacaId;
	}

	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}

	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}

	public boolean isCollisionDamageWaiver() {
		return collisionDamageWaiver;
	}

	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
		this.collisionDamageWaiver = collisionDamageWaiver;
	}

	public int getBrojSedistaZaDecu() {
		return brojSedistaZaDecu;
	}

	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
		this.brojSedistaZaDecu = brojSedistaZaDecu;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public List<byte[]> getSlike() {
		return slike;
	}

	public void setSlike(List<byte[]> slike) {
		this.slike = slike;
	}

	public String getMarkaNaziv() {
		return MarkaNaziv;
	}

	public void setMarkaNaziv(String markaNaziv) {
		MarkaNaziv = markaNaziv;
	}

	public String getModelNaziv() {
		return modelNaziv;
	}

	public void setModelNaziv(String modelNaziv) {
		this.modelNaziv = modelNaziv;
	}

	public String getKlasaNaziv() {
		return klasaNaziv;
	}

	public void setKlasaNaziv(String klasaNaziv) {
		this.klasaNaziv = klasaNaziv;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getUkupnaOcena() {
		return ukupnaOcena;
	}

	public void setUkupnaOcena(float ukupnaOcena) {
		this.ukupnaOcena = ukupnaOcena;
	}


}
