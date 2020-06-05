package com.example.Messages.DTO;

import java.math.BigInteger;

import javax.xml.datatype.XMLGregorianCalendar;

import com.example.Messages.SchemaToJava2.model.entitet.Pretrazivanje;
import com.example.Messages.SchemaToJava2.model.tentitet.TAutomobila;

public class PretrazivanjeDTO {
	
	private Long id;
	private XMLGregorianCalendar datumPreuzimanjaVozila;
	private XMLGregorianCalendar datumPovratkaVozila;
	private String mestoPreuzimanjaVozila;
	private BigInteger minCena;
	private BigInteger maxCena;
	private TAutomobila dodatniParametri;
	
	public PretrazivanjeDTO() {
		
	}
	
	public PretrazivanjeDTO(Pretrazivanje p) {
		this(p.getId(), p.getDatumPreuzimanjaVozila(), p.getDatumPovratkaVozila(), p.getMestoPreuzimanjaVozila(),
				p.getMinCena(), p.getMaxCena(),p.getDodatniParametri());
	}
	
	
	
	public PretrazivanjeDTO(Long id, XMLGregorianCalendar datumPreuzimanjaVozila,
			XMLGregorianCalendar datumPovratkaVozila, String mestoPreuzimanjaVozila, BigInteger minCena,
			BigInteger maxCena, TAutomobila dodatniParametri) {
		super();
		this.id = id;
		this.datumPreuzimanjaVozila = datumPreuzimanjaVozila;
		this.datumPovratkaVozila = datumPovratkaVozila;
		this.mestoPreuzimanjaVozila = mestoPreuzimanjaVozila;
		this.minCena = minCena;
		this.maxCena = maxCena;
		this.dodatniParametri = dodatniParametri;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public XMLGregorianCalendar getDatumPreuzimanjaVozila() {
		return datumPreuzimanjaVozila;
	}
	public void setDatumPreuzimanjaVozila(XMLGregorianCalendar datumPreuzimanjaVozila) {
		this.datumPreuzimanjaVozila = datumPreuzimanjaVozila;
	}
	public XMLGregorianCalendar getDatumPovratkaVozila() {
		return datumPovratkaVozila;
	}
	public void setDatumPovratkaVozila(XMLGregorianCalendar datumPovratkaVozila) {
		this.datumPovratkaVozila = datumPovratkaVozila;
	}
	public String getMestoPreuzimanjaVozila() {
		return mestoPreuzimanjaVozila;
	}
	public void setMestoPreuzimanjaVozila(String mestoPreuzimanjaVozila) {
		this.mestoPreuzimanjaVozila = mestoPreuzimanjaVozila;
	}
	public BigInteger getMinCena() {
		return minCena;
	}
	public void setMinCena(BigInteger minCena) {
		this.minCena = minCena;
	}
	public BigInteger getMaxCena() {
		return maxCena;
	}
	public void setMaxCena(BigInteger maxCena) {
		this.maxCena = maxCena;
	}
	public TAutomobila getDodatniParametri() {
		return dodatniParametri;
	}
	public void setDodatniParametri(TAutomobila dodatniParametri) {
		this.dodatniParametri = dodatniParametri;
	}
	 
}
