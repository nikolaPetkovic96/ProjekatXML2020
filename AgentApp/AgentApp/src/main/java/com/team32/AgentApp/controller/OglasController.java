package com.team32.AgentApp.controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.AutomobilDTO;
import com.team32.AgentApp.DTO.CenovnikDTO;
import com.team32.AgentApp.DTO.OglasDTO;
import com.team32.AgentApp.DTO.OglasNewDTO;
import com.team32.AgentApp.model.entitet.Cenovnik;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.service.AdresaService;
import com.team32.AgentApp.service.AutomobilService;
import com.team32.AgentApp.service.CenovnikService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.NarudzbenicaService;
import com.team32.AgentApp.service.OglasService;
import com.team32.AgentApp.service.UserService;

@RestController
public class OglasController {

		@Autowired
		private OglasService oglasService;
		@Autowired
		private CommonDataService comDataService;
		@Autowired
		private UserService userService;
		@Autowired
		private NarudzbenicaService narudzbService;
		
		@Autowired
		private AdresaService adresaService;
		@Autowired
		private CenovnikService cenovnikService;
		@Autowired
		private AutomobilService automobilService;
		
		//GET ALL
		@RequestMapping(method=RequestMethod.GET, value="/oglas", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDTO>> getAllOglas() {
		
			List<Oglas> allOglas = oglasService.getAllOglas();
			
			List<OglasDTO> oglasiDTO = new ArrayList<>();
			for (Oglas o : allOglas) {
				
				OglasDTO oglasDTO = new OglasDTO();
				
				CommonData comData = comDataService.findOne(o.getCommonDataId());
				if(comData == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				User user = userService.findOne(comData.getUserid());
				if(user == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				Cenovnik cenovnik = cenovnikService.findOne(o.getCenovnikId());
				if(cenovnik == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				AutomobilDTO automobilDTO = automobilService.findOneWithDetails(o.getAutomobilId());
				if(automobilDTO == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				Adresa adresa = adresaService.findOne(o.getAdresaId());
				if(adresa == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}

				oglasDTO.setId(o.getId());
				oglasDTO.setCenovnikId(o.getCenovnikId());
				oglasDTO.setAutomobilId(o.getAutomobilId());
				oglasDTO.setAdresaId(o.getAdresaId());
				oglasDTO.setCommonDataId(o.getCommonDataId());
				oglasDTO.setOdDatuma(o.getOdDatuma());
				oglasDTO.setDoDatuma(o.getDoDatuma());
				
				oglasDTO.setAgentId(comData.getUserid());
				oglasDTO.setUsername(user.getKorisnickoIme());

				oglasDTO.setPlaniranaKilometraza(o.getPlaniranaKilometraza());
				oglasDTO.setZauzetiTermini(getZauzetiTermini(narudzbService.getAllNarudzbeniceByOglasId(o.getId())));
				oglasDTO.setAdresa(new AdresaDTO(adresa));
				oglasDTO.setAutomobil(automobilDTO);
				oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));
				
				oglasiDTO.add(oglasDTO);
			}
			// convert komentar to DTOs
			return new ResponseEntity<>(oglasiDTO, HttpStatus.OK);
		}
		
		//GET
		@RequestMapping(method=RequestMethod.GET, value="/oglas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> getOglas(@PathVariable("id") Long id){
			OglasDTO oglasDTO = new OglasDTO();
			
			Oglas oglas = oglasService.findOne(id);
			if(oglas == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			CommonData comData = comDataService.findOne(oglas.getCommonDataId());
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			User user = userService.findOne(comData.getUserid());
			if(user == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			Cenovnik cenovnik = cenovnikService.findOne(oglas.getCenovnikId());
			if(cenovnik == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			AutomobilDTO automobilDTO = automobilService.findOneWithDetails(oglas.getAutomobilId());
			if(automobilDTO == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			Adresa adresa = adresaService.findOne(oglas.getAdresaId());
			if(adresa == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			oglasDTO.setId(oglas.getId());
			oglasDTO.setCenovnikId(oglas.getCenovnikId());
			oglasDTO.setAutomobilId(oglas.getAutomobilId());
			oglasDTO.setAdresaId(oglas.getAdresaId());
			oglasDTO.setCommonDataId(oglas.getCommonDataId());
			oglasDTO.setOdDatuma(oglas.getOdDatuma());
			oglasDTO.setDoDatuma(oglas.getDoDatuma());
			oglasDTO.setPlaniranaKilometraza(oglas.getPlaniranaKilometraza());
			
			oglasDTO.setAgentId(comData.getUserid());
			oglasDTO.setUsername(user.getKorisnickoIme());
			oglasDTO.setZauzetiTermini(getZauzetiTermini(narudzbService.getAllNarudzbeniceByOglasId(oglas.getId())));
			oglasDTO.setAdresa(new AdresaDTO(adresa));
			oglasDTO.setAutomobil(automobilDTO);
			oglasDTO.setCenovnik(new CenovnikDTO(cenovnik));

			return new ResponseEntity<>(oglasDTO, HttpStatus.OK);
		}
		
		//POST
		@RequestMapping(method=RequestMethod.POST, value="/oglas",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasNewDTO> addOglas(@RequestBody OglasNewDTO dto)  throws Exception {
			Oglas savedOglas = new Oglas();
			
			//Prilkom kreiranja novog oglasa odmah se kreira i commonData koji pamti ko je kreirao oglas i kada.
			CommonData commonData = setCommonData((long) 1);
			
			//Prilkom kreiranja novog oglasa odmah se kreira i nova adresa vezana za taj oglas.
			Adresa adresa = setAdresa(dto, (long) 1);
			//Izvrsi se cuvanje nove adrese i kreira na osnovu povratne vrednosti(nje same) DTO.
			AdresaDTO adresaDTO = new AdresaDTO(adresaService.addAdresa(adresa));
	
			savedOglas.setId(dto.getId());	
			savedOglas.setOdDatuma(dto.getOdDatuma());
			savedOglas.setDoDatuma(dto.getDoDatuma());
			savedOglas.setAutomobilId(dto.getAutomobilId());
			savedOglas.setCenovnikId(dto.getCenovnikId());
			savedOglas.setPlaniranaKilometraza(dto.getPlaniranaKilometraza());
			
			savedOglas.setAdresaId(adresaDTO.getId());
			savedOglas.setCommonDataId(commonData.getId());

			savedOglas = oglasService.addOglas(savedOglas);
										
			return new ResponseEntity<>(new OglasNewDTO(savedOglas, adresaDTO), HttpStatus.CREATED);
		}
		
		//PUT
		@RequestMapping(method=RequestMethod.PUT, value="/oglas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasNewDTO> updateOglas(@RequestBody OglasNewDTO dto) throws Exception{
			
			Oglas updatedOglas = oglasService.findOne(dto.getId());
			if(updatedOglas == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			CommonData commonData = updateCommonData(updatedOglas.getCommonDataId());
			
			//Ukoliko se menja adresa oglasa.
			Adresa adresa = updateAdresa(dto, updatedOglas.getAdresaId());
			//Izvrsi se cuvanje izmenjene adrese i kreira na osnovu povratne vrednosti(nje same) DTO.
			AdresaDTO updatedAdresaDTO = new AdresaDTO(adresaService.updateAdresa(adresa.getId(), adresa));
			
			updatedOglas.setId(dto.getId());	
			updatedOglas.setOdDatuma(dto.getOdDatuma());
			updatedOglas.setDoDatuma(dto.getDoDatuma());
			updatedOglas.setAutomobilId(dto.getAutomobilId());
			updatedOglas.setCenovnikId(dto.getCenovnikId());
			updatedOglas.setPlaniranaKilometraza(dto.getPlaniranaKilometraza());
			//Ne updejtuje se id automobila i id adrese
			updatedOglas.setCommonDataId(commonData.getId());
			updatedOglas = oglasService.updateOglas(updatedOglas.getId(), updatedOglas);
			
			return new ResponseEntity<>(new OglasNewDTO(updatedOglas, updatedAdresaDTO),HttpStatus.OK);
		}
		
		//DELETE
		@RequestMapping(value="/oglas/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteOglas(@PathVariable Long id) {
			
			Oglas oglas = oglasService.findOne(id);
			if (oglas != null) {
				Adresa adresa =  adresaService.findOne(oglas.getAdresaId());
				
				//obrise se adresa vezana za oglas
				adresaService.deleteAdresa(adresa.getId());
				//obrise se i commonData te adrese
				comDataService.deleteCommonData(adresa.getCommonDataId());
				
				//obrise se sam oglas
				oglasService.deleteOglas(id);
				//obrise se commonData tog oglasa
				comDataService.deleteCommonData(oglas.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
		
		//POMOCNE METODE
		
		//Pomocna metoda za kreiranje novog commonData
		public CommonData setCommonData(Long userId) throws Exception {
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumKreiranja(now);
			commonData.setUserId(userId); 
			commonData = comDataService.addCommonData(commonData);	
			return commonData;
		}
		
		//Pomocna metoda za azuriranje postojeceg commonData
		public CommonData updateCommonData(Long comDataId) throws Exception {
			CommonData commonData = comDataService.findOne(comDataId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDataId, commonData);
			return commonData;
		}
		
		//Pomocna metoda koja kreiran novu adresu i povezuje je sa oglasom
		public Adresa setAdresa(OglasNewDTO dto, Long userId) throws Exception {
			Adresa adresa = new Adresa();
			adresa.setMesto(dto.getAdresa().getMesto());
			adresa.setPostanskiBroj(dto.getAdresa().getPostanskiBroj());
			adresa.setUlica(dto.getAdresa().getUlica());
			adresa.setBroj(dto.getAdresa().getBroj());
			
			//Prilkom kreiranja nove adrese odmah se kreira i commonData koji pamti ko je kreirao adresu i kada.
			CommonData adresaCommonData = setCommonData(userId);
			adresa.setCommonDataId(adresaCommonData.getId());
			
			return adresa;
		}
		
		//Pomocna metoda koja azurira adresu prilikom azuriranja oglasa sa kojim je povezana
		public Adresa updateAdresa(OglasNewDTO dto, Long adresaId) throws Exception {
			Adresa adresa =  adresaService.findOne(adresaId);
			adresa.setMesto(dto.getAdresa().getMesto());
			adresa.setPostanskiBroj(dto.getAdresa().getPostanskiBroj());
			adresa.setUlica(dto.getAdresa().getUlica());
			adresa.setBroj(dto.getAdresa().getBroj());
			
			//Prilkom izmene adrese odmah se menja i commonData koji pamti kada je izmena izvrsena.
			CommonData adresaCommonData = updateCommonData(adresa.getCommonDataId());
			adresa.setCommonDataId(adresaCommonData.getId());
			
			return adresa;
		}
		
		
		//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
		public List<HashMap<String, LocalDateTime>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
			List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
			for (Narudzbenica n : narudzbenice) {
				//ovaj deo koda potencijalno izmeniti za TerminDTO:
				HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
				hash_map.put("odDatuma", n.getOdDatuma());
				hash_map.put("doDatuma", n.getDoDatuma());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
			
			return zauzetiTermini;
		}
}