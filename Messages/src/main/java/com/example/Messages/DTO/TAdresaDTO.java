package com.example.Messages.DTO;

import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa;
import com.example.Messages.SchemaToJava2.model.tentitet.TAdresa.Kordinate;

public class TAdresaDTO {
	private Long id;
	private String mesto;
	private int postanskiBroj;
	private String ulica;
	private int broj;
	private TAdresaDTO.KordinateDTO kordinate;	
	
	public TAdresaDTO() {}
	
	public TAdresaDTO(Long id, String mesto, int postanskiBroj, String ulica, int broj, KordinateDTO kordinate) {
		super();
		this.id = id;
		this.mesto = mesto;
		this.postanskiBroj = postanskiBroj;
		this.ulica = ulica;
		this.broj = broj;
		this.kordinate = kordinate;
	}
	public TAdresaDTO(TAdresa a) {
		super();
		this.id = a.getId();
		this.mesto = a.getMesto();
		this.postanskiBroj = a.getPostanskiBroj();
		this.ulica = a.getUlica();
		this.broj = a.getBroj();
		this.kordinate =new KordinateDTO(a.getKordinate());	
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public TAdresaDTO.KordinateDTO getKordinate() {
		return kordinate;
	}
	public void setKordinate(TAdresaDTO.KordinateDTO kordinate) {
		this.kordinate = kordinate;
	}
	////Klasa za kordinate
	private static class KordinateDTO{
		private Long id;
		private Float longitude;
		private Float latitude;
		
		public KordinateDTO(Long id, Float longitude, Float latitude) {
			super();
			this.id = id;
			this.longitude = longitude;
			this.latitude = latitude;
		}

		public KordinateDTO(Kordinate k) {			
			this(k.getId(),k.getLongitude(),k.getLatitude());
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Float getLongitude() {
			return longitude;
		}

		public void setLongitude(Float longitude) {
			this.longitude = longitude;
		}

		public Float getLatitude() {
			return latitude;
		}

		public void setLatitude(Float latitude) {
			this.latitude = latitude;
		}		
	}
}
