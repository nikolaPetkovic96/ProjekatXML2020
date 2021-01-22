package com.example.sync.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.sync.dto.automobil.AutoSuccessResponse;
import com.example.sync.dto.automobil.Automobil;
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

	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetFuelTypeRequest")
	@ResponsePayload
	public FuelTypeResponse getFuelTypes() {
		return  typesService.getFuelTypes();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetTransmissionTypesRequest")
	@ResponsePayload
	public TransmissionTypesResponse getTransmissionTypes() {
		return  typesService.getTransmissions();		
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetModelRequest")
	@ResponsePayload
	public ModelResponse getModel() {
		return  typesService.getModels();		
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetBrandRequest")
	@ResponsePayload
	public BrandResponse getBrand() {
		return  typesService.getBrands();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetKlasaRequest")
	@ResponsePayload
	public KlasaResponse getKlase() {
		return  typesService.getKlase();
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetSlikaRequest")
	@ResponsePayload
	public SlikaResponse getSlika() {
		return  typesService.getSlika();
	}

	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetAutomobilRequest")
	@ResponsePayload
	public AutomobilResponse getAutomobil() {
		return  typesService.getAutomobil();
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostAutomobilRequest")
	@ResponsePayload
	public AutoSuccessResponse postAutomobil(@RequestBody Automobil a) {
		return typesService.postAutomobil(a);
	}
}
