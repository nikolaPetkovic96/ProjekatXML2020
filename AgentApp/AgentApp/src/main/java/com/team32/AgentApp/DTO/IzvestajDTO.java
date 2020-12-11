package com.team32.AgentApp.DTO;
import com.team32.AgentApp.model.entitet.Izvestaj;

public class IzvestajDTO {
	
	private Long id;
	
	private float predjenaKilometraza;
	
	private String tekstIzvestaja;

	private Long narudzbenicaId;

	private Long commonDataId;
	
	public IzvestajDTO() {
		super();
	}
	
	public IzvestajDTO(Izvestaj i) {
		this(
			i.getId(),
			i.getPredjenaKilometraza(),
			i.getTekstIzvestaja(),
			i.getNarudzbenicaId(),
			i.getCommonDataId()
			);
	}

	public IzvestajDTO(Long id, float predjenaKilometraza, String tekstIzvestaja, Long narudzbenicaId,
			Long commonDataId) {
		super();
		this.id = id;
		this.predjenaKilometraza = predjenaKilometraza;
		this.tekstIzvestaja = tekstIzvestaja;
		this.narudzbenicaId = narudzbenicaId;
		this.commonDataId = commonDataId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPredjenaKilometraza() {
		return predjenaKilometraza;
	}

	public void setPredjenaKilometraza(float predjenaKilometraza) {
		this.predjenaKilometraza = predjenaKilometraza;
	}

	public String getTekstIzvestaja() {
		return tekstIzvestaja;
	}

	public void setTekstIzvestaja(String tekstIzvestaja) {
		this.tekstIzvestaja = tekstIzvestaja;
	}

	public Long getNarudzbenicaId() {
		return narudzbenicaId;
	}

	public void setNarudzbenicaId(Long narudzbenicaId) {
		this.narudzbenicaId = narudzbenicaId;
	}

	public Long getCommonDataId() {
		return commonDataId;
	}

	public void setCommonDataId(Long commonDataId) {
		this.commonDataId = commonDataId;
	}
	
	
	

}
