package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.team32.AgentApp.model.entitet.Oglas;

public class OglasDTO {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
    private float planiranaKilometraza;
	private Long commonDataId;
    private Long cenovnikId;				//Posle obrisati
	private Long automobilId;				//Posle obrisati
    private Long adresaId;					//Posle obrisati
	private Long agentId; 					//onoga ko je napravio oglas (samo u DTO)
	private String username;				//onoga ko je napravio oglas (samo u DTO)
    private List<HashMap<String, LocalDateTime>> zauzetiTermini; //(samo u DTO)
    private AdresaDTO adresa;				//(samo u DTO)
    private AutomobilDTO automobil;			//(samo u DTO)
    private CenovnikDTO cenovnik;			//(samo u DTO)
    
	
	public OglasDTO() {
		super();
	}

	public OglasDTO(Oglas o, String username, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini,
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
		this.username = username;
		this.zauzetiTermini = zauzetiTermini;
		this.adresa = adresa;
		this.automobil = automobil;
		this.cenovnik = cenovnik;
	}

	public OglasDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId, Long adresaId,
			Long planiranaKilometraza, Long commonDataId, String username, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini, 
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
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
