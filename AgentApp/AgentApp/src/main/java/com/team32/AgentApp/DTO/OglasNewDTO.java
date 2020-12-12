package com.team32.AgentApp.DTO;

import java.time.LocalDateTime;

import com.team32.AgentApp.model.entitet.Oglas;

public class OglasNewDTO {

		private Long id;
		private LocalDateTime odDatuma;
		private LocalDateTime doDatuma;
		private Long cenovnikId;
		private Long automobilId;
//		private Long adresaId 				nema potrebe da ovde imamo adresa id kada kreiramo novu adresu 
		private float planiranaKilometraza;
		private Long commonDataId;
		private AdresaDTO adresa;
		
		public OglasNewDTO() {
			super();
		}
		
		public OglasNewDTO(Oglas o, AdresaDTO adresa) {
			super();
			this.id = o.getId();
			this.odDatuma = o.getOdDatuma();
			this.doDatuma = o.getDoDatuma();
			this.cenovnikId = o.getCenovnikId();
			this.automobilId = o.getAutomobilId();
			this.planiranaKilometraza = o.getPlaniranaKilometraza();
			this.adresa = adresa;
			
			this.commonDataId = o.getCommonDataId(); //za get samo da ispise rezultat...
			
		}
		
		public OglasNewDTO(Long id, LocalDateTime odDatuma, LocalDateTime doDatuma, Long cenovnikId, Long commonDataId,
				Long automobilId, float planiranaKilometraza, AdresaDTO adresa) {
			super();
			this.id = id;
			this.odDatuma = odDatuma;
			this.doDatuma = doDatuma;
			this.cenovnikId = cenovnikId;
			this.commonDataId = commonDataId;
			this.automobilId = automobilId;
			this.planiranaKilometraza = planiranaKilometraza;
			this.adresa = adresa;
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
		public float getPlaniranaKilometraza() {
			return planiranaKilometraza;
		}
		public void setPlaniranaKilometraza(float planiranaKilometraza) {
			this.planiranaKilometraza = planiranaKilometraza;
		}
		public AdresaDTO getAdresa() {
			return adresa;
		}
		public void setAdresa(AdresaDTO adresa) {
			this.adresa = adresa;
		}
}
