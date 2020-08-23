package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.user.Firma;

public class FirmaDTO {
	
	 	private Long id;
		
	 	private String naziv;

	 	private String poslovniMaticniBroj;

		public FirmaDTO() {
			super();
		}

		public FirmaDTO(Long id, String naziv, String poslovniMaticniBroj) {
			super();
			this.id = id;
			this.naziv = naziv;
			this.poslovniMaticniBroj = poslovniMaticniBroj;

		}

		public FirmaDTO(Firma firma) {
			super();
			this.id = firma.getId();
			this.naziv = firma.getNaziv();
			this.poslovniMaticniBroj = firma.getPoslovniMaticniBroj();
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


}
