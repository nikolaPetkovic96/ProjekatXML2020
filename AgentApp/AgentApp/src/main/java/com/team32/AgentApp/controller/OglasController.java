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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.OglasDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.NarudzbenicaService;
import com.team32.AgentApp.service.OglasService;
import com.team32.AgentApp.service.UserService;

@RestController
public class OglasController {

		@Autowired
		private OglasService oglasService;
		@Autowired
		private CommonDataService commonDataService;
		@Autowired
		private UserService userService;
		@Autowired
		private NarudzbenicaService narudzbService;
	
		//GET ALL	
		@RequestMapping(method=RequestMethod.GET, value="/oglas", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDTO>> getAllOglas() {
		
			List<Oglas> allOglas = oglasService.getAllOglas();
			
			List<OglasDTO> oglasiDTO = new ArrayList<>();
			for (Oglas o : allOglas) {
				
				OglasDTO oglasDTO = new OglasDTO();
				
				CommonData comData = commonDataService.findOne(o.getCommonDataId());
				if(comData == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}else {
					oglasDTO.setAgentId(comData.getUserid());
				}
				
				User user = userService.findOne(comData.getUserid());
				if(user == null) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					oglasDTO.setUsername(user.getKorisnickoIme());
				}	
				
				oglasDTO.setUsername(user.getKorisnickoIme());
				oglasDTO.setId(o.getId());
				oglasDTO.setCenovnikId(o.getCenovnikId());
				oglasDTO.setAutomobilId(o.getAutomobilId());
				oglasDTO.setCommonDataId(o.getCommonDataId());
				oglasDTO.setOdDatuma(o.getOdDatuma());
				oglasDTO.setDoDatuma(o.getDoDatuma());
				oglasDTO.setPlaniranaKilometraza(o.getPlaniranaKilometraza());
				
				List<Narudzbenica> narudzbenice = narudzbService.getAllNarudzbeniceByOglasId(o.getId());
				List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
				for (Narudzbenica n : narudzbenice) {
					//ovaj deo koda potencijalno izmeniti za TerminDTO:
					HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
					hash_map.put("odDatuma", n.getOdDatuma());
					hash_map.put("doDatuma", n.getDoDatuma());
					System.out.println("Initial Mappings are: " + hash_map);
					zauzetiTermini.add(hash_map);
				}
				oglasDTO.setZauzetiTermini(zauzetiTermini);
				
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
			
			if (oglas == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			CommonData comData = commonDataService.findOne(oglas.getCommonDataId());
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				oglasDTO.setAgentId(comData.getUserid());
			}
			
			User user = userService.findOne(comData.getUserid());
			if(user == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				oglasDTO.setUsername(user.getKorisnickoIme());
			}		
			
			oglasDTO.setId(oglas.getId());
			oglasDTO.setCenovnikId(oglas.getCenovnikId());
			oglasDTO.setAutomobilId(oglas.getAutomobilId());
			oglasDTO.setCommonDataId(oglas.getCommonDataId());
			oglasDTO.setOdDatuma(oglas.getOdDatuma());
			oglasDTO.setDoDatuma(oglas.getDoDatuma());
			oglasDTO.setPlaniranaKilometraza(oglas.getPlaniranaKilometraza());
		
			
			List<Narudzbenica> narudzbenice = narudzbService.getAllNarudzbeniceByOglasId(oglas.getId());
			List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
			for (Narudzbenica n : narudzbenice) {
				//ovaj deo koda potencijalno izmeniti za TerminDTO:
				HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
				hash_map.put("odDatuma", n.getOdDatuma());
				hash_map.put("doDatuma", n.getDoDatuma());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
			oglasDTO.setZauzetiTermini(zauzetiTermini);
			
			return new ResponseEntity<>(oglasDTO, HttpStatus.OK);
		}
		
		//POST
//		@RequestMapping(method=RequestMethod.POST, value="/oglas",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<OglasDTO> addOglas(@RequestBody OglasDTO oglasDTO)  throws Exception {
//			Oglas savedOglas = new Oglas();
//			
//			
//			//Prilkom kreiranja novog komentara odmah se kreira i commonData koji pamti ko je kreirao i kada.
//			CommonData commonData = new CommonData();
//			LocalDateTime now = LocalDateTime.now();
//			commonData.setDatumKreiranja(now);
//			commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
//			commonData = commonDataService.addCommonData(commonData);
//			
//			savedOglas.setId(oglasDTO.getId());	
//			savedOglas.setOdDatuma(oglasDTO.getOdDatuma());
//			savedOglas.setDoDatuma(oglasDTO.getDoDatuma());
//			savedOglas.setAutomobilId(oglasDTO.getAutomobilId());
//			savedOglas.setCommonDataId(commonData.getId());
//			savedOglas.setCenovnikId(oglasDTO.getCenovnikId());
//			
//			savedOglas = oglasService.addOglas(savedOglas);
//													
////			return new ResponseEntity<>(new OglasDTO(savedOglas.getId(), savedOglas.getOdDatuma(), savedOglas.getDoDatuma(), savedOglas.getCenovnikId(), savedOglas.getCommonDataId(), savedOglas.getAutomobilId(), oglasDTO.getUsername()), HttpStatus.CREATED);
////			return new ResponseEntity<>(new OglasDTO(savedOglas, oglasDTO.getUsername()), HttpStatus.CREATED);
//			return new ResponseEntity<>(new OglasDTO(savedOglas), HttpStatus.CREATED);
//		}
//		
//		//PUT
//		@RequestMapping(method=RequestMethod.PUT, value="/oglas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<OglasDTO> updateOglas(@RequestBody OglasDTO oglasDTO) throws Exception{
//			
//			Oglas updatedOglas = oglasService.findOne(oglasDTO.getId());
//			if(updatedOglas == null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//			
//			Long comDatId = updatedOglas.getCommonDataId();
//			
//			CommonData commonData = commonDataService.findOne(comDatId);
//			LocalDateTime now = LocalDateTime.now();
//			commonData.setDatumIzmene(now);
//			commonData = commonDataService.updateCommonData(comDatId, commonData);
//			
//			updatedOglas.setId(oglasDTO.getId());
//			updatedOglas.setOdDatuma(oglasDTO.getOdDatuma());
//			updatedOglas.setDoDatuma(oglasDTO.getDoDatuma());
//			updatedOglas.setCenovnikId(oglasDTO.getCenovnikId());
//			//Ne updejtuje se id automobila
//			updatedOglas.setCommonDataId(comDatId);
//			updatedOglas = oglasService.updateOglas(updatedOglas.getId(), updatedOglas);
//			
//			return new ResponseEntity<>(new OglasDTO(updatedOglas),HttpStatus.OK);
//		}
		
		//DELETE
		@RequestMapping(value="/oglas/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteOglas(@PathVariable Long id) {
			
			Oglas oglas = oglasService.findOne(id);
			if (oglas != null) {
				oglasService.deleteOglas(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
		
}
