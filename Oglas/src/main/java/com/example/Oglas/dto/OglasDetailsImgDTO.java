package com.example.Oglas.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.example.Oglas.model.Oglas;


public class OglasDetailsImgDTO {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
    private float planiranaKilometraza;
	private Long agentId; 								//onoga ko je napravio oglas (samo u DTO)
	private String korImeAgenta;						//onoga ko je napravio oglas (samo u DTO)
    private List<HashMap<String, Long>> zauzetiTermini; //(samo u DTO)
    private AdresaDTO adresa;							//(samo u DTO)
    private AutomobilImgDTO automobil;						//(samo u DTO)
    private CenovnikDTO cenovnik;						//(samo u DTO)
	
	public OglasDetailsImgDTO() {
		super();
	}
	
	public OglasDetailsImgDTO(Oglas o) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.planiranaKilometraza = o.getPlaniranaKm();
	}
	


	public OglasDetailsImgDTO(Oglas o, String korImeAgenta, Long agentId, List<HashMap<String, Long>> zauzetiTermini,
			AdresaDTO adresa, AutomobilImgDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.planiranaKilometraza = o.getPlaniranaKm();
		this.agentId = agentId;
		this.korImeAgenta = korImeAgenta;
		this.zauzetiTermini = zauzetiTermini;
		this.adresa = adresa;
		this.automobil = automobil;
		this.cenovnik = cenovnik;
	}

	public OglasDetailsImgDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId, Long adresaId,
			Long planiranaKilometraza, Long commonDataId, String korImeAgenta, Long agentId, List<HashMap<String, Long>> zauzetiTermini, 
			AdresaDTO adresa, AutomobilImgDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.planiranaKilometraza = planiranaKilometraza;
		this.korImeAgenta = korImeAgenta;
		this.zauzetiTermini = zauzetiTermini;
		this.adresa = adresa;
		this.automobil = automobil;
		this.cenovnik = cenovnik;
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

	public float getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}

	public void setPlaniranaKilometraza(float planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
	}

	public String getKorImeAgenta() {
		return korImeAgenta;
	}

	public void setKorImeAgenta(String korImeAgenta) {
		this.korImeAgenta = korImeAgenta;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public List<HashMap<String, Long>> getZauzetiTermini() {
		return zauzetiTermini;
	}

	public void setZauzetiTermini(List<HashMap<String, Long>> zauzetiTermini) {
		this.zauzetiTermini = zauzetiTermini;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public AutomobilImgDTO getAutomobil() {
		return automobil;
	}

	public void setAutomobil(AutomobilImgDTO automobil) {
		this.automobil = automobil;
	}

	public CenovnikDTO getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(CenovnikDTO cenovnik) {
		this.cenovnik = cenovnik;
	}
	
}
