package com.example.Messages.DTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.tentitet.TAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;

public class TAutomobilaDTO {		
	private Long id;
	private TMarkaAutomobilaDTO markaAutomobila;
	private TModelAutomobilaDTO modelAutomobila;
	private TKlasaAutomobilaDTO klasaAutomobila;
	private TTipGorivaDTO vrstaGoriva;
	private TTipMenjacaDTO tipMenjaca;
	private float predjenaKilometraza;
	private BigInteger planiranaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	private List<TSlikaVozilaDTO> slika;
	
	public TAutomobilaDTO() {}
	
	public TAutomobilaDTO(Long id, TMarkaAutomobilaDTO markaAutomobila, TModelAutomobilaDTO modelAutomobila,
			TKlasaAutomobilaDTO klasaAutomobila, TTipGorivaDTO vrstaGoriva, TTipMenjacaDTO tipMenjaca,
			float predjenaKilometraza, BigInteger planiranaKilometraza, boolean collisionDamageWaiver,
			int brojSedistaZaDecu, List<TSlikaVozilaDTO> slika) {
		super();
		this.id = id;
		this.markaAutomobila = markaAutomobila;
		this.modelAutomobila = modelAutomobila;
		this.klasaAutomobila = klasaAutomobila;
		this.vrstaGoriva = vrstaGoriva;
		this.tipMenjaca = tipMenjaca;
		this.predjenaKilometraza = predjenaKilometraza;
		this.planiranaKilometraza = planiranaKilometraza;
		this.collisionDamageWaiver = collisionDamageWaiver;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.slika = slika;
	}
	public TAutomobilaDTO(TAutomobila ta) {
		this.id=ta.getId();
		this.markaAutomobila=new TMarkaAutomobilaDTO(ta.getMarkaAutomobila());
		this.modelAutomobila=new TModelAutomobilaDTO(ta.getModelAutomobila());
		this.klasaAutomobila=new TKlasaAutomobilaDTO(ta.getKlasaAutomobila());
		this.vrstaGoriva=new TTipGorivaDTO(ta.getVrstaGoriva());
		this.tipMenjaca=new TTipMenjacaDTO(ta.getTipMenjaca());
		this.predjenaKilometraza=ta.getPredjenaKilometraza();
		this.planiranaKilometraza=ta.getPlaniranaKilometraza();
		this.collisionDamageWaiver=ta.isCollisionDamageWaiver();
		this.brojSedistaZaDecu=ta.getBrojSedistaZaDecu();
		
		List<TSlikaVozilaDTO> temp=new ArrayList<TSlikaVozilaDTO>();
		for(TSlikaVozila s: ta.getSlika()) 
			temp.add(new TSlikaVozilaDTO(s));
		
		this.slika=temp;	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TMarkaAutomobilaDTO getMarkaAutomobila() {
		return markaAutomobila;
	}
	public void setMarkaAutomobila(TMarkaAutomobilaDTO markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}
	public TModelAutomobilaDTO getModelAutomobila() {
		return modelAutomobila;
	}
	public void setModelAutomobila(TModelAutomobilaDTO modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}
	public TKlasaAutomobilaDTO getKlasaAutomobila() {
		return klasaAutomobila;
	}
	public void setKlasaAutomobila(TKlasaAutomobilaDTO klasaAutomobila) {
		this.klasaAutomobila = klasaAutomobila;
	}
	public TTipGorivaDTO getVrstaGoriva() {
		return vrstaGoriva;
	}
	public void setVrstaGoriva(TTipGorivaDTO vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}
	public TTipMenjacaDTO getTipMenjaca() {
		return tipMenjaca;
	}
	public void setTipMenjaca(TTipMenjacaDTO tipMenjaca) {
		this.tipMenjaca = tipMenjaca;
	}
	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}
	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}
	public BigInteger getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}
	public void setPlaniranaKilometraza(BigInteger planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
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
	public List<TSlikaVozilaDTO> getSlika() {
		return slika;
	}
	public void setSlika(List<TSlikaVozilaDTO> slika) {
		this.slika = slika;
	}
}
