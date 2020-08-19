//package com.example.Messages.DTO;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
//import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
//import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
//import com.example.Messages.SchemaToJava2.model.tentitet.TKlasaAutomobila;
//import com.example.Messages.SchemaToJava2.model.tentitet.TMarkaAutomobila;
//import com.example.Messages.SchemaToJava2.model.tentitet.TModelAutomobila;
//import com.example.Messages.SchemaToJava2.model.tentitet.TSlikaVozila;
//import com.example.Messages.SchemaToJava2.model.tentitet.TTipGoriva;
//import com.example.Messages.SchemaToJava2.model.tentitet.TTipMenjaca;
//
//public class AutomobilDTO {
//
//	private Long id;
//	private Long markaAutomobilaId;
//	private Long modelAutomobilaId;
//	private Long klasaAutomobilaId;
//	private Long vrstaGorivaId;
//	private Long tipMenjacaId;
//	private float predjenaKilometraza;
//	private BigInteger planiranaKilometraza;
//	private boolean collisionDamageWaiver;
//	private int brojSedistaZaDecu;
//	private	List<TSlikaVozilaDTO> slika;
//	private List<KomentarDTO> komentar;
//	private List<OcenaDTO> ocena;
//	
//	public AutomobilDTO() {
//		
//	}
//	
//	public AutomobilDTO(Long id, Long markaAutomobilaId, Long modelAutomobilaId,
//			Long klasaAutomobilaId, Long vrstaGorivaId, Long tipMenjacaId, float predjenaKilometraza,
//			BigInteger planiranaKilometraza, boolean collisionDamageWaiver, int brojSedistaZaDecu,
//			List<TSlikaVozilaDTO> slika, List<KomentarDTO> komentar, List<OcenaDTO> ocena) {
//		super();
//		this.id = id;
//		this.markaAutomobilaId = markaAutomobilaId;
//		this.modelAutomobilaId = modelAutomobilaId;
//		this.klasaAutomobilaId = klasaAutomobilaId;
//		this.vrstaGorivaId = vrstaGorivaId;
//		this.tipMenjacaId = tipMenjacaId;
//		this.predjenaKilometraza = predjenaKilometraza;
//		this.planiranaKilometraza = planiranaKilometraza;
//		this.collisionDamageWaiver = collisionDamageWaiver;
//		this.brojSedistaZaDecu = brojSedistaZaDecu;
//		this.slika = slika;
//		this.komentar = komentar;
//		this.ocena = ocena;
//	}
//
//	public AutomobilDTO(Automobil a) {
//		
//		List<Komentar> tempKomentari = a.getKomentar();
//		komentar = new ArrayList<KomentarDTO>();
//		for(Komentar k : tempKomentari) {
//			komentar.add(new KomentarDTO(k));
//		}
//		 
//		List<Ocena> tempOcene = a.getOcena();
//		ocena = new ArrayList<OcenaDTO>();
//		for(Ocena o : tempOcene) {
//			ocena.add(new OcenaDTO(o));
//		}
//		
//		List<TSlikaVozila> tempSlike = a.getSlika();
//		slika = new ArrayList<TSlikaVozilaDTO>();
//		for(TSlikaVozila s : tempSlike) {
//			slika.add(new TSlikaVozilaDTO(s));
//		}
//				
//		this.id = a.getId();	
//		this.markaAutomobilaId = a.getMarkaAutomobilaId();
//		this.modelAutomobilaId = a.getModelAutomobilaId();
//		this.klasaAutomobilaId = a.getKlasaAutomobilaId();
//		this.vrstaGorivaId = a.getVrstaGorivaId();
//		this.tipMenjacaId = a.getTipMenjacaId();
//		this.predjenaKilometraza = a.getPredjenaKilometraza();
//		this.planiranaKilometraza = a.getPlaniranaKilometraza();
//		this.collisionDamageWaiver = a.isCollisionDamageWaiver();
//		this.brojSedistaZaDecu = a.getBrojSedistaZaDecu();
//	}
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public List<KomentarDTO> getKomentar() {
//		return komentar;
//	}
//
//	public void setKomentar(List<KomentarDTO> komentar) {
//		this.komentar = komentar;
//	}
//
//	public List<OcenaDTO> getOcena() {
//		return ocena;
//	}
//
//	public void setOcena(List<OcenaDTO> ocena) {
//		this.ocena = ocena;
//	}
//
//	public Long getMarkaAutomobilaId() {
//		return markaAutomobilaId;
//	}
//
//	public void setMarkaAutomobilaId(Long markaAutomobilaId) {
//		this.markaAutomobilaId = markaAutomobilaId;
//	}
//
//	public Long getModelAutomobilaId() {
//		return modelAutomobilaId;
//	}
//
//	public void setModelAutomobilaId(Long modelAutomobilaId) {
//		this.modelAutomobilaId = modelAutomobilaId;
//	}
//
//	public Long getKlasaAutomobilaId() {
//		return klasaAutomobilaId;
//	}
//
//	public void setKlasaAutomobilaId(Long klasaAutomobilaId) {
//		this.klasaAutomobilaId = klasaAutomobilaId;
//	}
//
//	public Long getVrstaGorivaId() {
//		return vrstaGorivaId;
//	}
//
//	public void setVrstaGorivaId(Long vrstaGorivaId) {
//		this.vrstaGorivaId = vrstaGorivaId;
//	}
//
//	public Long getTipMenjacaId() {
//		return tipMenjacaId;
//	}
//
//	public void setTipMenjacaId(Long tipMenjacaId) {
//		this.tipMenjacaId = tipMenjacaId;
//	}
//
//	public float getPredjenaKilometraza() {
//		return predjenaKilometraza;
//	}
//
//	public void setPredjenaKilometraza(float predjenaKilometraza) {
//		this.predjenaKilometraza = predjenaKilometraza;
//	}
//
//	public BigInteger getPlaniranaKilometraza() {
//		return planiranaKilometraza;
//	}
//
//	public void setPlaniranaKilometraza(BigInteger planiranaKilometraza) {
//		this.planiranaKilometraza = planiranaKilometraza;
//	}
//
//	public boolean isCollisionDamageWaiver() {
//		return collisionDamageWaiver;
//	}
//
//	public void setCollisionDamageWaiver(boolean collisionDamageWaiver) {
//		this.collisionDamageWaiver = collisionDamageWaiver;
//	}
//
//	public int getBrojSedistaZaDecu() {
//		return brojSedistaZaDecu;
//	}
//
//	public void setBrojSedistaZaDecu(int brojSedistaZaDecu) {
//		this.brojSedistaZaDecu = brojSedistaZaDecu;
//	}
//
//	public List<TSlikaVozilaDTO> getSlika() {
//		return slika;
//	}
//
//	public void setSlika(List<TSlikaVozilaDTO> slika) {
//		this.slika = slika;
//	}
//	
//	
//}
