package com.example.Pretraga;

public class AutomobilPretragaDTO {

	Long id;
	int broj_sedista_za_decu;
	boolean col_dmg_weaver;
	int predj_km;
	int plan_km;
	String model;
	String marka;
	String klasa;
	String gorivo;
	String menjac;
	
	public AutomobilPretragaDTO(AutomobilPretraga a) {
		this(a.id,a.br_sedista_za_decu,a.col_dmh_waiver,a.plan_km,a.plan_km,a.model,a.marka,a.klasa,a.gorivo,a.menjac);
	}
	public AutomobilPretragaDTO() {};
	
	public AutomobilPretragaDTO(Long id, int broj_sedista_za_decu, boolean col_dmg_weaver, int predj_km, int plan_km,
			String model, String marka, String klasa, String gorivo, String menjac) {
		super();
		this.id = id;
		this.broj_sedista_za_decu = broj_sedista_za_decu;
		this.col_dmg_weaver = col_dmg_weaver;
		this.predj_km = predj_km;
		this.plan_km = plan_km;
		this.model = model;
		this.marka = marka;
		this.klasa = klasa;
		this.gorivo = gorivo;
		this.menjac = menjac;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBroj_sedista_za_decu() {
		return broj_sedista_za_decu;
	}
	public void setBroj_sedista_za_decu(int broj_sedista_za_decu) {
		this.broj_sedista_za_decu = broj_sedista_za_decu;
	}
	public boolean isCol_dmg_weaver() {
		return col_dmg_weaver;
	}
	public void setCol_dmg_weaver(boolean col_dmg_weaver) {
		this.col_dmg_weaver = col_dmg_weaver;
	}
	public int getPredj_km() {
		return predj_km;
	}
	public void setPredj_km(int predj_km) {
		this.predj_km = predj_km;
	}
	public int getPlan_km() {
		return plan_km;
	}
	public void setPlan_km(int plan_km) {
		this.plan_km = plan_km;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getKlasa() {
		return klasa;
	}
	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}
	public String getGorivo() {
		return gorivo;
	}
	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}
	public String getMenjac() {
		return menjac;
	}
	public void setMenjac(String menjac) {
		this.menjac = menjac;
	}
}
