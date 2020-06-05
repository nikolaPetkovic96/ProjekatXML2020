package com.example.Messages.DTO;

import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.user.Firma;

public class FirmaDTO {
	
	 	private Long id;
		
	 	private String naziv;

	 	private String poslovniMaticniBroj;
	    
	 	private List<Komentar> komentar;
	    
	 	private List<Oglas> oglas;
		
	 	private List<Poruka> poruka;

		public FirmaDTO() {
			super();
		}

		public FirmaDTO(Long id, String naziv, String poslovniMaticniBroj, String ime, String prezime, String jmbg,
				List<Komentar> komentar, List<Oglas> oglas, List<Poruka> poruka) {
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
			this.komentar = firma.getKomentar();
			this.oglas = firma.getOglas();
			this.poruka = firma.getPoruka();
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

		public List<Komentar> getKomentar() {
			return komentar;
		}

		public void setKomentar(List<Komentar> komentar) {
			this.komentar = komentar;
		}

		public List<Oglas> getOglas() {
			return oglas;
		}

		public void setOglas(List<Oglas> oglas) {
			this.oglas = oglas;
		}

		public List<Poruka> getPoruka() {
			return poruka;
		}

		public void setPoruka(List<Poruka> poruka) {
			this.poruka = poruka;
		}

}
