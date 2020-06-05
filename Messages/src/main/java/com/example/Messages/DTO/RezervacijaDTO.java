package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.Messages.SchemaToJava2.model.entitet.Oglas;
import com.example.Messages.SchemaToJava2.model.entitet.Poruka;
import com.example.Messages.SchemaToJava2.model.entitet.Rezervacija;

public class RezervacijaDTO {

	private long rezervacija_id;
	private double ukupnaCena;
	private Date odDatuma;
	private Date doDatuma;
	private Boolean bundle;
	private String statusRezervacije;
    
	private List<OglasDTO> oglas;
	private List<PorukaDTO> poruka;
	
	public RezervacijaDTO() {
		
	}
	
	public RezervacijaDTO(Rezervacija r) {
		this.rezervacija_id = r.getRezervacija_id();
		this.ukupnaCena = r.getUkupnaCena();
		this.odDatuma = r.getOdDatuma();
		this.doDatuma = r.getDoDatuma();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();	
		
		List<Oglas> tempOglasi = r.getOglas();
		oglas = new ArrayList<OglasDTO>();
		for(Oglas o : tempOglasi) {
			oglas.add(new OglasDTO(o));
		}
		
		List<Poruka> tempPoruke = r.getPoruka();
		poruka= new ArrayList<PorukaDTO>();
		for(Poruka p : tempPoruke) {
			poruka.add(new PorukaDTO(p));
		}
		
	}
	
	public RezervacijaDTO(long rezervacija_id, double ukupnaCena, Date odDatuma, Date doDatuma, Boolean bundle,
			String statusRezervacije, List<OglasDTO> oglas, List<PorukaDTO> poruka) {
		super();
		this.rezervacija_id = rezervacija_id;
		this.ukupnaCena = ukupnaCena;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		this.oglas = oglas;
		this.poruka = poruka;
	}

	public long getRezervacija_id() {
		return rezervacija_id;
	}

	public void setRezervacija_id(long rezervacija_id) {
		this.rezervacija_id = rezervacija_id;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Date getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(Date odDatuma) {
		this.odDatuma = odDatuma;
	}

	public Date getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(Date doDatuma) {
		this.doDatuma = doDatuma;
	}

	public Boolean getBundle() {
		return bundle;
	}

	public void setBundle(Boolean bundle) {
		this.bundle = bundle;
	}

	public String getStatusRezervacije() {
		return statusRezervacije;
	}

	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
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
