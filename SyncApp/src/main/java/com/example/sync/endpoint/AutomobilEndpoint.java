package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.automobil.AutomobilResponse;
import com.example.sync.dto.automobil.brand.BrandResponse;
import com.example.sync.dto.automobil.carClass.Klasa;
import com.example.sync.dto.automobil.carClass.KlasaResponse;
import com.example.sync.dto.automobil.fuel.FuelTypeResponse;
import com.example.sync.dto.automobil.model.ModelResponse;
import com.example.sync.dto.automobil.slika.SlikaResponse;
import com.example.sync.dto.automobil.transmission.TransmissionTypesResponse;
import com.example.sync.dto.commonData.CommonDataResponse;
import com.example.sync.service.AutomobilService;
@Endpoint
public class AutomobilEndpoint {

	@Autowired
	private AutomobilService typesService;

	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetFuelTypesResponse")
	@ResponsePayload
	public FuelTypeResponse getFuelTypes() {
		return  typesService.getFuelTypes();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetTransmissionTypesResponse")
	@ResponsePayload
	public TransmissionTypesResponse getTransmissionTypes() {
		return  typesService.getTransmissions();		
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetModelResponse")
	@ResponsePayload
	public ModelResponse getModel() {
		return  typesService.getModels();		
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetBrandResponse")
	@ResponsePayload
	public BrandResponse getBrand() {
		return  typesService.getBrands();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetClassResponse")
	@ResponsePayload
	public KlasaResponse getKlase() {
		return  typesService.getKlase();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetSlikaResponse")
	@ResponsePayload
	public SlikaResponse getSlika() {
		return  typesService.getSlika();
	}

	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetAutomobilResponse")
	@ResponsePayload
	public AutomobilResponse getAutomobil() {
		return  typesService.getAutomobil();
	}
}
