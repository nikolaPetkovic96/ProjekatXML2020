package com.example.Reservation.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.example.Reservation.model.Oglas; 

public class OglasDTO {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
    protected Long cenovnikId;
	private Long commonDataId;
	private Long automobilId;
	private String username;
	private Long adresaId;
    private List<HashMap<String, LocalDateTime>> zauzetiTermini; //(samo u DTO)
    private AdresaDTO adresa;				//(samo u DTO)
    private AutomobilDTO automobil;			//(samo u DTO)
    private CenovnikDTO cenovnik;
	private float planiranaKm;
	
	public OglasDTO() {
		super();
	}

	public OglasDTO(Oglas o, CenovnikDTO c, AutomobilDTO a, AdresaDTO adresa) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.cenovnikId = o.getCenovnikId();
		this.commonDataId = o.getCommonDataId();
		this.automobilId = o.getAutomobilId();
		this.adresaId = o.getAdresaId();		
		this.adresa = adresa;
		this.automobil = a;
		this.cenovnik = c;
	}
	public OglasDTO(Oglas o) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.cenovnikId = o.getCenovnikId();
		this.commonDataId = o.getCommonDataId();
		this.automobilId = o.getAutomobilId();
		this.adresaId = o.getAdresaId();
		this.planiranaKm = o.getPlaniranaKm();
	}

	public OglasDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long commonDataId, Long automobilId, String username, Long adresaId, 	float planiranaKm) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.commonDataId = commonDataId;
		this.automobilId = automobilId;
		this.username = username;
		this.adresaId = adresaId;
		this.planiranaKm = planiranaKm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(LocalDateTime odDatuma) {
		this.odDatuma = odDatuma;
	}

	public LocalDateTime getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(LocalDateTime doDatuma) {
		this.doDatuma = doDatuma;
	}

	public Long getCenovnikId() {
		return cenovnikId;
	}

	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getAdresaId() {
		return adresaId;
	}

	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}

	public List<HashMap<String, LocalDateTime>> getZauzetiTermini() {
		return zauzetiTermini;
	}

	public void setZauzetiTermini(List<HashMap<String, LocalDateTime>> zauzetiTermini) {
		this.zauzetiTermini = zauzetiTermini;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public AutomobilDTO getAutomobil() {
		return automobil;
	}

	public void setAutomobil(AutomobilDTO automobil) {
		this.automobil = automobil;
	}

	public CenovnikDTO getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(CenovnikDTO cenovnik) {
		this.cenovnik = cenovnik;
	}

	public float getPlaniranaKm() {
		return planiranaKm;
	}

	public void setPlaniranaKm(float planiranaKm) {
		this.planiranaKm = planiranaKm;
	}
	
}