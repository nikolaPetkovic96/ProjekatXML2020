//package com.example.Messages.DTO;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
//import com.example.Messages.SchemaToJava2.model.entitet.Ocena;
//import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
//import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
//import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;
//import com.example.Messages.SchemaToJava2.model.user.RegistrovaniKorisnik;
//
//
//public class RegistrovaniKorisnikDTO {
//
//	private Long id;
//	
//    private String ime;
//    
//    private String prezime;
// 
//    private String jmbg;
//  
//    private List<KomentarDTO> komentar;
//  
//    private List<OcenaDTO> ocena;
//
//    private List<PorukaDTO> poruka;
//    
//    private List<RezervacijaDTO> rezervacija;
//    
//    private List<OglasDTO> oglas;
//
//	public RegistrovaniKorisnikDTO() {
//		super();
//	}
//
//	public RegistrovaniKorisnikDTO(Long id, String ime, String prezime, String jmbg, List<KomentarDTO> komentar,
//			List<OcenaDTO> ocena, List<PorukaDTO> poruka, List<RezervacijaDTO> rezervacija, List<OglasDTO> oglas) {
//		super();
//		this.id = id;
//		this.ime = ime;
//		this.prezime = prezime;
//		this.jmbg = jmbg;
//		this.komentar = komentar;
//		this.ocena = ocena;
//		this.poruka = poruka;
//		this.rezervacija = rezervacija;
//		this.oglas = oglas;
//	}
//	
//	public RegistrovaniKorisnikDTO(RegistrovaniKorisnik rk) {
//		
//		this.id = rk.getId();
//		this.ime = rk.getIme();
//		this.prezime = rk.getPrezime();
//		this.jmbg = rk.getJMBG();
//			
//		List<Komentar> pomKomentar = rk.getKomentar();
//		this.komentar = new ArrayList<KomentarDTO>();
//		for (Komentar k : pomKomentar) {
//			komentar.add(new KomentarDTO(k));
//		}
//		
//		List<Ocena> pomOcena = rk.getOcena();
//		this.ocena = new ArrayList<OcenaDTO>();
//		for (Ocena o : pomOcena) {
//			ocena.add(new OcenaDTO(o));
//		}
//		
//		List<Poruka> pomPoruka = rk.getPoruka();
//		this.poruka = new ArrayList<PorukaDTO>();
//		for (Poruka p : pomPoruka) {
//			poruka.add(new PorukaDTO(p));
//		}
//		
////		List<Rezervacija> pomRezervacija = rk.getRezervacije();
////		this.rezervacija = new ArrayList<RezervacijaDTO>();
////		for (Rezervacija r : pomRezervacija) {
////			rezervacija.add(new RezervacijaDTO(r));
////		}
//		
//		
//		List<Oglas> pomOglas= rk.getOglas();
//		this.oglas = new ArrayList<OglasDTO>();
//		for (Oglas o : pomOglas) {
//			oglas.add(new OglasDTO(o));
//		}
//	}
//
//
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
//	public List<PorukaDTO> getPoruka() {
//		return poruka;
//	}
//
//	public void setPoruka(List<PorukaDTO> poruka) {
//		this.poruka = poruka;
//	}
//
////	public List<RezervacijaDTO> getRezervacija() {
////		return rezervacija;
////	}
////
////	public void setRezervacija(List<RezervacijaDTO> rezervacija) {
////		this.rezervacija = rezervacija;
////	}
//
//	public List<OglasDTO> getOglas() {
//		return oglas;
//	}
//
//	public void setOglas(List<OglasDTO> oglas) {
//		this.oglas = oglas;
//	}
//	
//
//	
//}
