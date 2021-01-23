package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import com.team32.AgentApp.model.entitet.Oglas;

public class OglasDetailsDTO {

	private Long id;
	private long odDatuma;
	private long doDatuma;
    private float planiranaKilometraza;
	private Long agentId; 								//onoga ko je napravio oglas (samo u DTO)
	private String korImeAgenta;						//onoga ko je napravio oglas (samo u DTO)
    private List<HashMap<String, Long>> zauzetiTermini; //(samo u DTO)
    private AdresaDTO adresa;							//(samo u DTO)
    private AutomobilDTO automobil;						//(samo u DTO)
    private CenovnikDTO cenovnik;						//(samo u DTO)
	
	public OglasDetailsDTO() {
		super();
	}
	
	public OglasDetailsDTO(Oglas o) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();;
		this.doDatuma = o.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();;
		this.planiranaKilometraza = o.getPlaniranaKilometraza();
	}
	


	public OglasDetailsDTO(Oglas o, String korImeAgenta, Long agentId, List<HashMap<String, Long>> zauzetiTermini,
			AdresaDTO adresa, AutomobilDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
		this.doDatuma = o.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
		this.planiranaKilometraza = o.getPlaniranaKilometraza();
		this.agentId = agentId;
		this.korImeAgenta = korImeAgenta;
		this.zauzetiTermini = zauzetiTermini;
		this.adresa = adresa;
		this.automobil = automobil;
		this.cenovnik = cenovnik;
	}

	public OglasDetailsDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId, Long adresaId,
			Long planiranaKilometraza, Long commonDataId, String korImeAgenta, Long agentId, List<HashMap<String, Long>> zauzetiTermini, 
			AdresaDTO adresa, AutomobilDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = id;
		this.odDatuma = odDatuma.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
		this.doDatuma = doDatuma.atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
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

	public long getOdDatuma() {
		return odDatuma;
	}

	public void setOdDatuma(long odDatuma) {
		this.odDatuma = odDatuma;
	}

	public long getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(long doDatuma) {
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
	
}
