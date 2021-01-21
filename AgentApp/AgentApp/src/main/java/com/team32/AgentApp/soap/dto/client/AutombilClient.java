package com.team32.AgentApp.soap.dto.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team32.AgentApp.model.entitet.Automobil;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.tentitet.KlasaAutomobila;
import com.team32.AgentApp.model.tentitet.MarkaAutomobila;
import com.team32.AgentApp.model.tentitet.ModelAutomobila;
import com.team32.AgentApp.model.tentitet.SlikaVozila;
import com.team32.AgentApp.model.tentitet.TipGoriva;
import com.team32.AgentApp.model.tentitet.TipMenjaca;
import com.team32.AgentApp.soap.SoapMessageSender;
import com.team32.AgentApp.soap.dto.automobil.AutoSuccessResponse;
import com.team32.AgentApp.soap.dto.automobil.AutomobilRequest;
import com.team32.AgentApp.soap.dto.automobil.AutomobilResponse;
import com.team32.AgentApp.soap.dto.brand.BrandRequest;
import com.team32.AgentApp.soap.dto.brand.BrandResponse;
import com.team32.AgentApp.soap.dto.carClass.KlasaRequest;
import com.team32.AgentApp.soap.dto.carClass.KlasaResponse;
import com.team32.AgentApp.soap.dto.commonData.CommonDataRequest;
import com.team32.AgentApp.soap.dto.commonData.CommonDataResponse;
import com.team32.AgentApp.soap.dto.commonData.CommonDataSuccessResponse;
import com.team32.AgentApp.soap.dto.fuel.FuelTypeResponse;
import com.team32.AgentApp.soap.dto.fuel.FuelTypeRequest;
import com.team32.AgentApp.soap.dto.model.ModelRequest;
import com.team32.AgentApp.soap.dto.model.ModelResponse;
import com.team32.AgentApp.soap.dto.slika.SlikaRequest;
import com.team32.AgentApp.soap.dto.slika.SlikaResponse;
import com.team32.AgentApp.soap.dto.slika.SlikaSuccessResponse;
import com.team32.AgentApp.soap.dto.transmission.TransmissionTypesRequest;
import com.team32.AgentApp.soap.dto.transmission.TransmissionTypesResponse;

@Component
public class AutombilClient {
	
	@Autowired
	private SoapMessageSender soapMessageSender;
	
	//GET ZA SVE
	public List<ModelAutomobila> getAllModel() {
		ModelRequest request = new ModelRequest();
		ModelResponse response = (ModelResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getModels();
	}
	
	
	public List<MarkaAutomobila> getAllMarka() {
		BrandRequest request = new BrandRequest();
		BrandResponse response = (BrandResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getBrands();
	}
	
	public List<KlasaAutomobila> getAllKlasa() {
		KlasaRequest request = new KlasaRequest();
		KlasaResponse response = (KlasaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getKlase();
	}
	
	public List<TipGoriva> getAllTipGoriva() {
		FuelTypeRequest request = new FuelTypeRequest();
		FuelTypeResponse response = (FuelTypeResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getTypes();
	}
	
	public List<TipMenjaca> getAllTipMenjaca() {
		TransmissionTypesRequest request = new TransmissionTypesRequest();
		TransmissionTypesResponse response = (TransmissionTypesResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getTypes();
	}
	
	
	public List<Automobil> getAllAutomobil() {
		AutomobilRequest request = new AutomobilRequest();
		AutomobilResponse response = (AutomobilResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getAutomobils();
	}
	
	public List<SlikaVozila> getAllSlikaVozila() {
		SlikaRequest request = new SlikaRequest();
		SlikaResponse response = (SlikaResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getSlika();
	}
	
	public List<CommonData> getAllCommonData() {
		CommonDataRequest request = new CommonDataRequest();
		CommonDataResponse response = (CommonDataResponse) soapMessageSender
				.sendMessage(request);
		
		return response.getCommonDatas();
	}
	
	
	//CREATE NEW
	
	//Dodavanje novog automobila prvo u glavnu bazu
	//Da bi se zatim dodao u lokalnu sa id-jem iz glavne... 
	public Automobil createNewAutomobil(Automobil a) {

		AutoSuccessResponse response = (AutoSuccessResponse) soapMessageSender
				.sendMessage(a);
		if (response.isSuccessful()) {
			a.setId(response.getAutomobilId());
			
			return a;
		}
		
		return null;
	}
	
	public SlikaVozila createNewSlikaVozila(SlikaVozila s) {

		SlikaSuccessResponse response = (SlikaSuccessResponse) soapMessageSender
				.sendMessage(s);
		if (response.isSuccessful()) {
			s.setId(response.getSlikaId());
			
			return s;
		}
		
		return null;
	}
	
	public CommonData createNewCommonData(CommonData cmd) {

		CommonDataSuccessResponse response = (CommonDataSuccessResponse) soapMessageSender
				.sendMessage(cmd);
		if (response.isSuccessful()) {
			cmd.setId(response.getCommonDataId());
			
			return cmd;
		}
		
		return null;
	}

}
