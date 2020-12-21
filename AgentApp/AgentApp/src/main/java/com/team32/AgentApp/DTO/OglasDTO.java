package com.team32.AgentApp.DTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import com.team32.AgentApp.model.entitet.Oglas;

public class OglasDTO {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
    private float planiranaKilometraza;
	private Long commonDataId;				//Posle obrisati
    private Long cenovnikId;				//Posle obrisati
	private Long automobilId;				//Posle obrisati
    private Long adresaId;					//Posle obrisati
	private Long agentId; 					//onoga ko je napravio oglas (samo u DTO)
	private String korImeAgenta;				//onoga ko je napravio oglas (samo u DTO)
    private List<HashMap<String, LocalDateTime>> zauzetiTermini; //(samo u DTO)
    private AdresaDTO adresa;				//(samo u DTO)
    private AutomobilDTO automobil;			//(samo u DTO)
    private CenovnikDTO cenovnik;			//(samo u DTO)
	
	public OglasDTO() {
		super();
	}
	
	public OglasDTO(Oglas o) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.cenovnikId = o.getCenovnikId();
		this.automobilId = o.getAutomobilId();
		this.commonDataId = o.getCommonDataId();
		this.planiranaKilometraza = o.getPlaniranaKilometraza();
	}
	
//	Long test = savedOglas.getOdDatuma().atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();
//	System.out.println("Ponovo u milisec odDatuma: " + test);
//	System.out.println("Ponovo iz milisec  u odDatuma: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(test), TimeZone.getDefault().toZoneId()));

	public OglasDTO(Oglas o, String korImeAgenta, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini,
			AdresaDTO adresa, AutomobilDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = o.getId();
		this.odDatuma = o.getOdDatuma();
		this.doDatuma = o.getDoDatuma();
		this.cenovnikId = o.getCenovnikId();
		this.automobilId = o.getAutomobilId();
		this.commonDataId = o.getCommonDataId();
		this.planiranaKilometraza = o.getPlaniranaKilometraza();
		this.agentId = agentId;
		this.korImeAgenta = korImeAgenta;
		this.zauzetiTermini = zauzetiTermini;
		this.adresa = adresa;
		this.automobil = automobil;
		this.cenovnik = cenovnik;
	}

	public OglasDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId, Long adresaId,
			Long planiranaKilometraza, Long commonDataId, String korImeAgenta, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini, 
			AdresaDTO adresa, AutomobilDTO automobil, CenovnikDTO cenovnik) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.automobilId = automobilId;
		this.adresaId = adresaId;
		this.planiranaKilometraza = planiranaKilometraza;
		this.commonDataId = commonDataId;
		this.korImeAgenta = korImeAgenta;
		this.zauzetiTermini = zauzetiTermini;
		this.commonDataId = commonDataId;
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

	public Long getCenovnikId() {
		return cenovnikId;
	}

	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
	}
	
	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public Long getAdresaId() {
		return adresaId;
	}

	public void setAdresaId(Long adresaId) {
		this.adresaId = adresaId;
	}

	public float getPlaniranaKilometraza() {
		return planiranaKilometraza;
	}

	public void setPlaniranaKilometraza(float planiranaKilometraza) {
		this.planiranaKilometraza = planiranaKilometraza;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
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
	
}
