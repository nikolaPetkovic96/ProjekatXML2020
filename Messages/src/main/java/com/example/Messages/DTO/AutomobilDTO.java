package com.example.Messages.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.example.Messages.SchemaToJava2.model.entitet.Automobil;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.entitet.Ocena;

public class AutomobilDTO {

	private Long id;
	private List<KomentarDTO> komentar;
	private List<OcenaDTO> ocena;
	
	public AutomobilDTO() {
		
	}
	
	public AutomobilDTO(Long id, List<KomentarDTO> komentar, List<OcenaDTO> ocena) {
		super();
		this.id = id;
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
		
		
		this.id = a.getId();
		
		
		
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
	
	
	
	
}
