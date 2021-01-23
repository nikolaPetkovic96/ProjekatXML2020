package com.team32.AgentApp.DTO;

public class RezervacijaStatusDTO {
	
	private Long rezervacijaId;
	private String statusRezervacije;

	public RezervacijaStatusDTO() {
		super();
	}
	
	public RezervacijaStatusDTO(Long rezervacijaId, String statusRezervacije) {
		super();
		this.rezervacijaId = rezervacijaId;
		this.statusRezervacije = statusRezervacije;
	}
	
	public Long getRezervacijaId() {
		return rezervacijaId;
	}
	public void setRezervacijaId(Long rezervacijaId) {
		this.rezervacijaId = rezervacijaId;
	}
	public String getStatusRezervacije() {
		return statusRezervacije;
	}
	public void setStatusRezervacije(String statusRezervacije) {
		this.statusRezervacije = statusRezervacije;
	}
	
	
}
