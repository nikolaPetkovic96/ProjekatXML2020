//package com.example.Messages.DTO;
//
//import java.util.List;
//
//import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
//import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
//import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
//import com.example.Messages.SchemaToJava2.model.user.Firma;
//
//public class FirmaAgentDTO {
//	
// 	private Long id;
//	
// 	private String ime;
//    
// 	private String prezime;
// 
// 	private String jmbg;
//    
// 	private List<Komentar> komentar;
//    
// 	private List<Oglas> oglas;
//	
// 	private List<Poruka> poruka;
//
// 	
//	public FirmaAgentDTO() {
//		super();
//	}
//
//	public FirmaAgentDTO(Long id, String naziv, String poslovniMaticniBroj, String ime, String prezime, String jmbg,
//			List<Komentar> komentar, List<Oglas> oglas, List<Poruka> poruka) {
//		super();
//		this.id = id;
//		this.ime = ime;
//		this.prezime = prezime;
//		this.jmbg = jmbg;
//		this.komentar = komentar;
//		this.oglas = oglas;
//		this.poruka = poruka;
//	}
//
//	public FirmaAgentDTO(Firma firma) {
//		super();
//		this.id = firma.getId();
//		this.ime = firma.getIme();
//		this.prezime = firma.getPrezime();
//		this.jmbg = firma.getJmbg();
//		this.komentar = firma.getKomentar();
//		this.oglas = firma.getOglas();
//		this.poruka = firma.getPoruka();
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
//	public String getIme() {
//		return ime;
//	}
//
//	public void setIme(String ime) {
//		this.ime = ime;
//	}
//
//	public String getPrezime() {
//		return prezime;
//	}
//
//	public void setPrezime(String prezime) {
//		this.prezime = prezime;
//	}
//
//	public String getJmbg() {
//		return jmbg;
//	}
//
//	public void setJmbg(String jmbg) {
//		this.jmbg = jmbg;
//	}
//
//	public List<Komentar> getKomentar() {
//		return komentar;
//	}
//
//	public void setKomentar(List<Komentar> komentar) {
//		this.komentar = komentar;
//	}
//
//	public List<Oglas> getOglas() {
//		return oglas;
//	}
//
//	public void setOglas(List<Oglas> oglas) {
//		this.oglas = oglas;
//	}
//
//	public List<Poruka> getPoruka() {
//		return poruka;
//	}
//
//	public void setPoruka(List<Poruka> poruka) {
//		this.poruka = poruka;
//	}
// 	
//}
