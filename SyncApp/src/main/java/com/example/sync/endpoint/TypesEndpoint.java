//package com.example.sync.endpoint;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import com.example.sync.dto.adresa.AdresaResponse;
//import com.example.sync.dto.automobil.AutomobilResponse;
//import com.example.sync.dto.automobil.brand.BrandResponse;
//import com.example.sync.dto.automobil.carClass.KlasaResponse;
//import com.example.sync.dto.automobil.fuel.FuelTypeResponse;
//import com.example.sync.dto.automobil.model.ModelResponse;
//import com.example.sync.dto.automobil.slika.SlikaResponse;
//import com.example.sync.dto.automobil.transmission.TransmissionTypesResponse;
//import com.example.sync.dto.commonData.CommonDataResponse;
//import com.example.sync.dto.komentar.KomentarResponse;
//import com.example.sync.dto.ocena.OcenaResponse;
//import com.example.sync.dto.oglas.OglasResponse;
//import com.example.sync.dto.oglas.cenovnik.CenovnikResponse;
//import com.example.sync.dto.poruka.PorukaResponse;
//import com.example.sync.dto.rezervacija.RezervacijaResponse;
//import com.example.sync.dto.rezervacija.izvestaj.IzvestajResponse;
//import com.example.sync.dto.user.UserTypesResponse;
//import com.example.sync.service.TypesService;
//
//@Endpoint
//public class TypesEndpoint {
//
//	@Autowired
//	private TypesService typesService;
//
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetFuelTypes")
//	@ResponsePayload
//	public FuelTypeResponse getFuelTypes() {
//		return  typesService.getFuelTypes();
//		
//	}
//	
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetTransmissionTypes")
//	@ResponsePayload
//	public TransmissionTypesResponse getTransmissionTypes() {
//		return  typesService.getTransmissionTypes();		
//	}
//	
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetModelTypes")
//	@ResponsePayload
//	public ModelResponse getModelTypes() {
//		return  typesService.getModelTypes();		
//	}
//	
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetBrandTypes")
//	@ResponsePayload
//	public BrandResponse getBrandTypes() {
//		return  typesService.getBrandTypes();
//	}
//	
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetClassTypes")
//	@ResponsePayload
//	public KlasaResponse getClassTypes() {
//		return  typesService.getClassTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetSlikaTypes")
//	@ResponsePayload
//	public SlikaResponse getSlikaTypes() {
//		return  typesService.getSlikaTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetCommonDataTypes")
//	@ResponsePayload
//	public CommonDataResponse getCommonDataTypes() {
//		return  typesService.getCommonDataTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetAutomobilTypes")
//	@ResponsePayload
//	public AutomobilResponse getAutomobilTypes() {
//		return  typesService.getAutomobilTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetKomentarTypes")
//	@ResponsePayload
//	public KomentarResponse getKomentarTypes() {
//		return  typesService.getKomentarTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetOcenaTypes")
//	@ResponsePayload
//	public OcenaResponse getOcenaTypes() {
//		return  typesService.getOcenaTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetAdresaTypes")
//	@ResponsePayload
//	public AdresaResponse getAdresaTypes() {
//		return  typesService.getAdresaTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetUserTypes")
//	@ResponsePayload
//	public UserTypesResponse getUserTypes() {
//		return  typesService.getUserTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetPorukaTypes")
//	@ResponsePayload
//	public PorukaResponse getPorukaTypes() {
//		return  typesService.getPorukaTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetIzvestajTypes")
//	@ResponsePayload
//	public IzvestajResponse getIzvestajTypes() {
//		return  typesService.getIzvestajTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetCenovnikTypes")
//	@ResponsePayload
//	public CenovnikResponse getCenovnikTypes() {
//		return  typesService.getCenovnikTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetOglasTypes")
//	@ResponsePayload
//	public OglasResponse getOglasTypes() {
//		return  typesService.getOglasTypes();
//	}
//	@PayloadRoot(namespace = "http://www.ftn.uns.ac.rs/sync", localPart = "GetRezervacijaTypes")
//	@ResponsePayload
//	public RezervacijaResponse getRezervacijaTypes() {
//		return  typesService.getRezervacijaTypes();
//	}
//
//}
