package com.example.sync.dto.commonData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonData", propOrder = { "id", "datumKreiranja","datumIzmene","userId"})
@XmlRootElement(name = "CommonData")
public class CommonData {
	
	@XmlElement(name = "Id", required = true)
	protected Long id;

	@XmlElement(name = "DatumKreiranja", required = true)
	protected LocalDateTime datumKreiranja;

	@XmlElement(name = "DatumIzmene", required = true)
	protected LocalDateTime datumIzmene;
	
	@XmlElement(name = "UserId", required = true)
	protected Long userId;

	public CommonData() {
		// TODO Auto-generated constructor stub
	}

	public CommonData(Long id, LocalDateTime datumKreiranja, LocalDateTime datumIzmene, Long userId) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public LocalDateTime getDatumIzmene() {
		return datumIzmene;
	}

	public void setDatumIzmene(LocalDateTime datumIzmene) {
		this.datumIzmene = datumIzmene;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setDatumKreiranja(String datumKreiranja) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(datumKreiranja.replace('T',' ' ), formatter);
		this.datumKreiranja = dateTime;
		
	}

	public void setDatumIzmene(String datumIzmene) {
		if(datumIzmene.equals("null")) {
			datumIzmene=null;
		}else {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(datumIzmene.replace('T',' ' ), formatter);
		this.datumIzmene = dateTime;	
		}
	}

}
