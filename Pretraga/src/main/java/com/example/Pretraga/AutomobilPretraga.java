package com.example.Pretraga;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT auto.id,\r\n" + 
		"    auto.br_sedista_za_decu,\r\n" + 
		"    auto.col_dmg_waiver,\r\n" + 
		"    auto.plan_kilom,\r\n" + 
		"    auto.predj_kilom,\r\n" + 
		"    model.naziv_modela,\r\n" + 
		"    klasa.naziv_klase,\r\n" + 
		"    marka.naziv_marke,\r\n" + 
		"    gorivo.naziv_tipa,\r\n" + 
		"    menjac.naziv_menjaca\r\n" + 
		"   FROM automobil auto\r\n" + 
		"     LEFT JOIN model_automobila model ON model.id = auto.model_automobila_id\r\n" + 
		"     LEFT JOIN tklasa_automobila klasa ON auto.klasa_automobila_id = klasa.id\r\n" + 
		"     LEFT JOIN tmarka_automobila marka ON auto.marka_automobila_id = marka.id\r\n" + 
		"     LEFT JOIN ttip_goriva gorivo ON auto.vrsta_goriva_id = gorivo.id\r\n" + 
		"     LEFT JOIN ttip_menjaca menjac ON auto.tip_menjaca_id = menjac.id;")
public class AutomobilPretraga {
	
	@Id
	Long id;
	
	@Column
	int br_sedista_za_decu;
	
	@Column
	boolean col_dmh_waiver;
	
	@Column
	int plan_km;
	@Column
	int predj_km;
	@Column
	String model;
	@Column String klasa;
	@Column String marka;
	@Column String gorivo;
	@Column String menjac;
	

}
