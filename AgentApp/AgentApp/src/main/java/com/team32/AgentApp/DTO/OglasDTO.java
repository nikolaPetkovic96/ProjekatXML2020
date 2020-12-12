package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.team32.AgentApp.model.entitet.Oglas;

public class OglasDTO {

	private Long id;
	private LocalDateTime odDatuma;
	private LocalDateTime doDatuma;
    protected Long cenovnikId;
	private Long commonDataId;
	private Long automobilId;
	private Long agentId; 		 			//onoga ko je napravio oglas (samo u DTO)
	private String username;				//onoga ko je napravio oglas (samo u DTO)
    private float planiranaKilometraza;
//  private TerminDTO[] zauzetiTermini; 	//(samo u DTO)
    private List<HashMap<String, LocalDateTime>> zauzetiTermini;		
	
	public OglasDTO() {
		super();
	}

	public OglasDTO(Oglas o, String username, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini) {
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
		
	}

	public OglasDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long automobilId,
			Long planiranaKilometraza, Long commonDataId, String username, Long agentId, List<HashMap<String, LocalDateTime>> zauzetiTermini) {
		super();
		this.id = id;
		this.odDatuma = odDatuma;
		this.doDatuma = doDatuma;
		this.cenovnikId = cenovnikId;
		this.automobilId = automobilId;
		this.planiranaKilometraza = planiranaKilometraza;
		this.commonDataId = commonDataId;
		this.username = username;
		this.agentId = agentId;
		this.zauzetiTermini = zauzetiTermini;
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
	
	
}
