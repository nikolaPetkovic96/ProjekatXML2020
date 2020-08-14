package com.example.Pretraga;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PretragaService {
	@Autowired 
	private AutomobilPretragaRepository autoRep;
	
	public ArrayList<AutomobilPretragaDTO> filter(int broj_sedista_za_decu, Boolean col_dmg_waiver,
			int predj_km, int plan_km,String model, String marka, String klasa,String gorivo, String menjac) {
		
		ArrayList<AutomobilPretraga> auto=(ArrayList<AutomobilPretraga>) autoRep.findAll();
		ArrayList<AutomobilPretragaDTO> autoDTO= new ArrayList<AutomobilPretragaDTO>();
		for(AutomobilPretraga a:auto) {
			if(broj_sedista_za_decu!=-1) {
				if(a.br_sedista_za_decu!=broj_sedista_za_decu)
					continue;
			}
			if(col_dmg_waiver!=null) {
				if(a.col_dmh_waiver!=col_dmg_waiver)
					continue;
			}
			if(predj_km!=-1) {
				if(a.predj_km!=predj_km)
					continue;
			}
			if(plan_km!=-1) {
				if(a.plan_km!=plan_km)
					continue;
			}
			if(model!=null) {
				if(a.model!=model)
					continue;
			}
			if(marka!=null) {
				if(a.marka!=marka)
					continue;
			}
			if(model!=null) {
				if(a.klasa!=klasa)
					continue;
			}
			if(gorivo!=null) {
				if(a.gorivo!=gorivo)
					continue;
			}
			if(menjac!=null) {
				if(a.menjac!=menjac)
					continue;
			}
			autoDTO.add(new AutomobilPretragaDTO(a));			
		}
	return autoDTO;
	//return new ArrayList<AutomobilPretragaDTO>();
	}
}
