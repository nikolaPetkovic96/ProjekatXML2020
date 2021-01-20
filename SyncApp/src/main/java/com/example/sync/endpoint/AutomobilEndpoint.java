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
	
	//POST
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostAutomobilResponse")
	@ResponsePayload
	public AutomobilResponse postAutomobil(Long id,Long commonDataId, Long markaAutomobilaId,Long modelAutomobilaId, Long klasaAutomobilaId,
			Long vrstaGorivaId, Long tipMenjacaId, float predjenaKilometraza,
			boolean collisionDamageWaiver, int brojSedistaZaDecu, float ukupnaOcena ) {
		return  typesService.postAutomobil(id, commonDataId, markaAutomobilaId, modelAutomobilaId, klasaAutomobilaId, 
											vrstaGorivaId, tipMenjacaId, predjenaKilometraza, 
											collisionDamageWaiver, brojSedistaZaDecu, ukupnaOcena);
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostSlikaResponse")
	@ResponsePayload
	public SlikaResponse postSlika(Long id, String[] slika, Long commonDataId, Long automobilId) {
		return  typesService.postSlika(id, slika, commonDataId, automobilId);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostClassResponse")
	@ResponsePayload
	public KlasaResponse postKlase(Long id, String nazivKlase, Long commonDataId) {
		return  typesService.postKlase(id, nazivKlase, commonDataId);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart =  "PostBrandResponse")
	@ResponsePayload
	public BrandResponse postBrand(Long id, String nazivMarke, Long commonDataId) {
		return  typesService.postBrands(id, nazivMarke, commonDataId);
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostModelResponse")
	@ResponsePayload
	public ModelResponse postModel(Long id, String nazivModela, Long commonDataId, Long markaAutomobilaId)  {
		return  typesService.postModels(id, nazivModela, commonDataId, markaAutomobilaId);		
	}
	
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostTransmissionTypesResponse")
	@ResponsePayload
	public TransmissionTypesResponse postTransmissionTypes(Long id, String nazivTipa, Long commonDataId) {
		return  typesService.postTransmissions(id, nazivTipa, commonDataId);		
	}
	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "PostFuelTypesResponse")
	@ResponsePayload
	public FuelTypeResponse postFuelTypes(Long id, String nazivTipa, Long commonDataId) {
		return  typesService.postFuelTypes(id, nazivTipa, commonDataId);
	}
}
