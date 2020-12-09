package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;

import com.team32.AgentApp.model.entitet.CommonData;

public class CommonDataDTO {

	private Long id;
	private LocalDateTime datumKreiranja;
	private LocalDateTime datumIzmene;
	private Long userId;
	
	public CommonDataDTO() {
		
	}
	
	public CommonDataDTO(Long id, Long userId, LocalDateTime  datumKreiranja, LocalDateTime  datumIzmene) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumIzmene = datumIzmene;
		this.userId = userId;
		
	}

	public CommonDataDTO(CommonData c) {
		this(c.getId(), c.getUserid(),c.getDatumKreiranja(), c.getDatumIzmene());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime  getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(LocalDateTime  datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public LocalDateTime  getDatumIzmene() {
		return datumIzmene;
	}
	public void setDatumIzmene(LocalDateTime  datumIzmene) {
		this.datumIzmene = datumIzmene;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
