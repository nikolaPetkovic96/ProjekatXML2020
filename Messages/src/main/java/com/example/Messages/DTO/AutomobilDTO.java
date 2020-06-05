package com.example.Messages.DTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;

public class AutomobilDTO {

	private Long id;
	private TMarkaAutomobila markaAutomobila;
	private TModelAutomobila modelAutomobila;
	private TKlasaAutomobila klasaAutomobila;
	private TTipGoriva vrstaGoriva;
	private TTipMenjaca tipMenjaca;
	private float predjenaKilometraza;
	private BigInteger planiranaKilometraza;
	private boolean collisionDamageWaiver;
	private int brojSedistaZaDecu;
	private	List<TSlikaVozilaDTO> slika;
	private List<KomentarDTO> komentar;
	private List<OcenaDTO> ocena;
	
	public AutomobilDTO() {
		
	}
	
	

	public AutomobilDTO(Long id, TMarkaAutomobila markaAutomobila, TModelAutomobila modelAutomobila,
			TKlasaAutomobila klasaAutomobila, TTipGoriva vrstaGoriva, TTipMenjaca tipMenjaca, float predjenaKilometraza,
			BigInteger planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu,
			List<TSlikaVozilaDTO> slika, List<KomentarDTO> komentar, List<OcenaDTO> ocena) {
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
		this.komentar = komentar;
		this.ocena = ocena;
	}



	public AutomobilDTO(Automobil a) {
		
		List<Komentar> tempKomentari = a.getKomentar();
		komentar = new ArrayList<KomentarDTO>();
		for(Komentar k : tempKomentari) {
			komentar.add(new KomentarDTO(k));
		}
		 
		List<Ocena> tempOcene = a.getOcena();
		ocena = new ArrayList<OcenaDTO>();
		for(Ocena o : tempOcene) {
			ocena.add(new OcenaDTO(o));
		}
		
		List<TSlikaVozila> tempSlike = a.getSlika();
		slika = new ArrayList<TSlikaVozilaDTO>();
		for(TSlikaVozila s : tempSlike) {
			slika.add(new TSlikaVozilaDTO(s));
		}
				
		this.id = a.getId();	
		this.markaAutomobila = a.getMarkaAutomobila();
		this.modelAutomobila = a.getModelAutomobila();
		this.klasaAutomobila = a.getKlasaAutomobila();
		this.vrstaGoriva = a.getVrstaGoriva();
		this.tipMenjaca = a.getTipMenjaca();
		this.predjenaKilometraza = a.getPredjenaKilometraza();
		this.planiranaKilometraza = a.getPlaniranaKilometraza();
		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<KomentarDTO> getKomentar() {
		return komentar;
	}

	public void setKomentar(List<KomentarDTO> komentar) {
		this.komentar = komentar;
	}

	public List<OcenaDTO> getOcena() {
		return ocena;
	}

	public void setOcena(List<OcenaDTO> ocena) {
		this.ocena = ocena;
	}

	public TMarkaAutomobila getMarkaAutomobila() {
		return markaAutomobila;
	}

	public void setMarkaAutomobila(TMarkaAutomobila markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}

	public TModelAutomobila getModelAutomobila() {
		return modelAutomobila;
	}

	public void setModelAutomobila(TModelAutomobila modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}

	public TKlasaAutomobila getKlasaAutomobila() {
		return klasaAutomobila;
	}

	public void setKlasaAutomobila(TKlasaAutomobila klasaAutomobila) {
		this.klasaAutomobila = klasaAutomobila;
	}

	public TTipGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(TTipGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public TTipMenjaca getTipMenjaca() {
		return tipMenjaca;
	}

	public void setTipMenjaca(TTipMenjaca tipMenjaca) {
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
