package com.example.Messages.DTO;

import java.util.Date;

import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.user.TUser;

public class CommonDataDTO {

	private Long id;
	private Date datumKreiranja;
	private Date datumIzmene;
	private TUserDTO user;
	
	public CommonDataDTO() {
		
	}
	
	public CommonDataDTO(Long id, TUser user,Date datumKreiranja, Date datumIzmene) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.user=new TUserDTO(user);
		
	}

	public CommonDataDTO(CommonData c) {
		this(c.getId(), c.getKorisnik(),c.getDatumKreiranja(), c.getDatumIzmene());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public Date getDatumIzmene() {
		return datumIzmene;
	}
	public void setDatumIzmene(Date datumIzmene) {
		this.datumIzmene = datumIzmene;
	}

	public TUserDTO getUser() {
		return user;
	}

	public void setUser(TUserDTO user) {
		this.user = user;
	}	
}
