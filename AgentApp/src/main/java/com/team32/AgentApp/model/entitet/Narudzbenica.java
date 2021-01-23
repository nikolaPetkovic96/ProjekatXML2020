package com.team32.AgentApp.model.entitet;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.team32.AgentApp.soap.LocalDateTimeAdapter;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Narudzbenica", namespace = "http://www.ftn.uns.ac.rs/sync", propOrder = { "id", "commonDataId", "agentId",
											"userId","oglasId","rezervacijaId","odDatuma","doDatuma" })
@XmlRootElement(name = "Narudzbenica", namespace = "http://www.ftn.uns.ac.rs/sync")
public class Narudzbenica {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@XmlElement(name = "Id", required = true)
		private Long id;
	
		//UserId iz commonData od Oglasa 
		@Column(name = "agent_id", nullable = false)
		@XmlElement(name = "AgentId", required = true)
		private Long agentId;
		
//		//UserId iz commonData od te Narudzbenice
		@XmlElement(name = "UserId", required = true)
		private Long userId;
	
		@Column(name = "oglas_id", nullable = false)
		@XmlElement(name = "OglasId", required = true)
		private Long oglasId;
		
		@Column(name = "rezervacija_id", nullable = false)
		@XmlElement(name = "RezervacijaId", required = true)
		private Long rezervacijaId;
		
		@Column(name = "od_datuma", nullable = false)
		@XmlElement(name = "OdDatuma", required = true)
		@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	    private LocalDateTime odDatuma;
	    
	    @Column(name = "do_datuma", nullable = false)
		@XmlElement(name = "DoDatuma", required = true)
		@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	    private LocalDateTime  doDatuma;
	    
	    @Column(name="common_data_id", nullable = false)
	    @XmlElement(name = "CommonDataId", required = true)
	    private Long commonDataId;

		public Narudzbenica() {
			super();
		}

		public Narudzbenica(Long id, Long agentId/*, Long userId*/, Long oglasId, Long rezervacijaId, LocalDateTime odDatuma,
				LocalDateTime doDatuma, Long commonDataId) {
			super();
			this.id = id;
			this.agentId = agentId;
//			this.userId = userId;
			this.oglasId = oglasId;
			this.rezervacijaId = rezervacijaId;
			this.odDatuma = odDatuma;
			this.doDatuma = doDatuma;
			this.commonDataId = commonDataId;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getAgentId() {
			return agentId;
		}

		public void setAgentId(Long agentId) {
			this.agentId = agentId;
		}

//		public Long getUserId() {
//			return userId;
//		}
//
//		public void setUserId(Long userId) {
//			this.userId = userId;
//		}

		public Long getOglasId() {
			return oglasId;
		}

		public void setOglasId(Long oglasId) {
			this.oglasId = oglasId;
		}

		public Long getRezervacijaId() {
			return rezervacijaId;
		}

		public void setRezervacijaId(Long rezervacijaId) {
			this.rezervacijaId = rezervacijaId;
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

		public Long getCommonDataId() {
			return commonDataId;
		}

		public void setCommonDataId(Long commonDataId) {
			this.commonDataId = commonDataId;
		}
}
