package com.team32.AgentApp.DTO;

import java.util.List;

import com.team32.AgentApp.model.entitet.Rezervacija;

public class RezervacijaFullDTO {

	private Long id;
	private double ukupnaCena;
	private Boolean bundle;
	private String statusRezervacije;
	private Long commonDataId; 			//Moze se i obrisati jer treba samo za new;
	private String username; 			//Dodato u DTO
	private List<NarudzbenicaDTO> narudzbenice;
	private List<PorukaDTO> poruke;
	
	public RezervacijaFullDTO() {
		
	}
	
	//Dodat String username kako bi se u returnu
	//POST I PUT zahteva vratila i vrednost username korisnika koji je kreirao/izmeno rezervaciju
	public RezervacijaFullDTO(Rezervacija r, String username, List<NarudzbenicaDTO> narudzbenice, List<PorukaDTO> poruke) {
		this.id = r.getId();
		this.ukupnaCena = r.getUkupnaCena();
		this.bundle = r.getBundle();
		this.statusRezervacije = r.getStatusRezervacije();
		
		this.commonDataId = r.getCommonDataId();
		this.username = username;

		this.narudzbenice = narudzbenice;
		this.poruke = poruke;
	}
	
	public RezervacijaFullDTO(Long id, double ukupnaCena, Boolean bundle, String statusRezervacije, Long commonDataId, String username,
			List<NarudzbenicaDTO> narudzbenice, List<PorukaDTO> poruke) {
		super();
		this.id = id;
		this.ukupnaCena = ukupnaCena;
		this.bundle = bundle;
		this.statusRezervacije = statusRezervacije;
		
		this.commonDataId = commonDataId;
		this.username = username;
		this.narudzbenice = narudzbenice;
		this.poruke = poruke;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public List<NarudzbenicaDTO> getNarudzbenice() {
		return narudzbenice;
	}
	public void setNarudzbenice(List<NarudzbenicaDTO> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}
	public List<PorukaDTO> getPoruke() {
		return poruke;
	}
	public void setPoruke(List<PorukaDTO> poruke) {
		this.poruke = poruke;
	}
	
}
