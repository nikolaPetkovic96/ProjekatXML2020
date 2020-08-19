package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.user.Firma;

public class FirmaDTO {
	
	 	private Long id;
		
	 	private String naziv;

	 	private String poslovniMaticniBroj;
	    
	 	private List<KomentarDTO> komentar;
	    
	 	private List<OglasDTO> oglas;
		
	 	private List<PorukaDTO> poruka;

		public FirmaDTO() {
			super();
		}

		public FirmaDTO(Long id, String naziv, String poslovniMaticniBroj, List<KomentarDTO> komentar,
				List<OglasDTO> oglas, List<PorukaDTO> poruka) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.poslovniMaticniBroj = poslovniMaticniBroj;
			this.komentar = komentar;
			this.oglas = oglas;
			this.poruka = poruka;
		}



		public FirmaDTO(Firma firma) {
			super();
			this.id = firma.getId();
			this.naziv = firma.getNaziv();
			this.poslovniMaticniBroj = firma.getPoslovniMaticniBroj();
			
//			this.komentar = firma.getKomentar();
			List<Komentar> tempKomentari = firma.getKomentar();
			komentar = new ArrayList<KomentarDTO>();
			for(Komentar k : tempKomentari) {
				komentar.add(new KomentarDTO(k));
			}
//			this.oglas = firma.getOglas();
			List<Oglas> tempOglasi = firma.getOglas();
			oglas = new ArrayList<OglasDTO>();
			for(Oglas o : tempOglasi) {
				oglas.add(new OglasDTO(o));
			}
//			this.poruka = firma.getPoruka();
			List<Poruka> tempPoruke= firma.getPoruka();
			poruka = new ArrayList<PorukaDTO>();
			for(Poruka p : tempPoruke) {
				poruka.add(new PorukaDTO(p));
			}
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

		public String getPoslovniMaticniBroj() {
			return poslovniMaticniBroj;
		}

		public void setPoslovniMaticniBroj(String poslovniMaticniBroj) {
			this.poslovniMaticniBroj = poslovniMaticniBroj;
		}


		public List<KomentarDTO> getKomentar() {
			return komentar;
		}

		public void setKomentar(List<KomentarDTO> komentar) {
			this.komentar = komentar;
		}


		public List<OglasDTO> getOglas() {
			return oglas;
		}

		public void setOglas(List<OglasDTO> oglas) {
			this.oglas = oglas;
		}

		public List<PorukaDTO> getPoruka() {
			return poruka;
		}

		public void setPoruka(List<PorukaDTO> poruka) {
			this.poruka = poruka;
		}

	

}
