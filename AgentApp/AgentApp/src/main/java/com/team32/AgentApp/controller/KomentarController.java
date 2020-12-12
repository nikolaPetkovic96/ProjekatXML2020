package com.team32.AgentApp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import com.team32.AgentApp.DTO.KomentarDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Komentar;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.KomentarService;
import com.team32.AgentApp.service.UserService;


@RestController
public class KomentarController {

	@Autowired
	private KomentarService komentarService;
	@Autowired
	private CommonDataService comDataService;
	@Autowired
	private UserService userService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/komentar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KomentarDTO>> getAllKomentar() {
	
		List<Komentar> allKomentar = komentarService.getAllKomentar();
		
		List<KomentarDTO> komentariDTO = new ArrayList<>();
		for (Komentar k : allKomentar) {
			
			KomentarDTO komentarDTO = new KomentarDTO();
			CommonData comData = comDataService.findOne(k.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			User user = userService.findOne(comData.getUserid());
			komentarDTO.setUsername(user.getKorisnickoIme());
			komentarDTO.setId(k.getId());
			komentarDTO.setAutomobilId(k.getAutomobilId());
			komentarDTO.setRezervacijaId(k.getRezervacijaId());
			komentarDTO.setOdobren(k.isOdobren());
			komentarDTO.setTekstKomentara(k.getTekstKomentara());
			komentarDTO.setCommonDataId(k.getCommonDataId());
			
			komentariDTO.add(komentarDTO);
		}
		// convert komentar to DTOs
		return new ResponseEntity<>( komentariDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/komentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> getKomentar(@PathVariable("id") Long id){
		KomentarDTO komentarDTO = new KomentarDTO();
		Komentar k = komentarService.findOne(id);
		
		if (k == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = comDataService.findOne(k.getCommonDataId());
		User user = userService.findOne(comData.getUserid());
		komentarDTO.setUsername(user.getKorisnickoIme());
		komentarDTO.setId(k.getId());
		komentarDTO.setAutomobilId(k.getAutomobilId());
		komentarDTO.setRezervacijaId(k.getRezervacijaId());
		komentarDTO.setOdobren(k.isOdobren());
		komentarDTO.setTekstKomentara(k.getTekstKomentara());
		komentarDTO.setCommonDataId(k.getCommonDataId());

		return new ResponseEntity<>(komentarDTO, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/komentar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> addKomentar(@RequestBody KomentarDTO komentarDTO)  throws Exception {
		
		Komentar savedKomentar = new Komentar();
		
		//Prilkom kreiranja novog komentara odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = comDataService.addCommonData(commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		savedKomentar.setId(komentarDTO.getId());
		savedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		savedKomentar.setOdobren(komentarDTO.isOdobren());
		savedKomentar.setAutomobilId(komentarDTO.getAutomobilId());
		savedKomentar.setRezervacijaId(komentarDTO.getRezervacijaId());
		savedKomentar.setCommonDataId(commonData.getId());
		
		savedKomentar = komentarService.addKomentar(savedKomentar); 
		return new ResponseEntity<>(new KomentarDTO(savedKomentar, user.getKorisnickoIme()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/komentar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> updateAutomobil(@RequestBody KomentarDTO komentarDTO) throws Exception{
		
		Komentar updatedKomentar = komentarService.findOne(komentarDTO.getId());
		if(updatedKomentar == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updatedKomentar.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		User user = userService.findOne(commonData.getUserid());
		
		updatedKomentar.setId(komentarDTO.getId());
		updatedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		updatedKomentar.setOdobren(komentarDTO.isOdobren());
//		updatedKomentar.setAutomobilId(porukaDTO.getAutomobilId());
//		updatedKomentar.setRezervacijaId(porukaDTO.getRezervacijaId());
		updatedKomentar.setCommonDataId(comDatId);
		
		updatedKomentar = komentarService.updateKomentar(updatedKomentar.getId(), updatedKomentar);
		 
		return new ResponseEntity<>(new KomentarDTO(updatedKomentar,user.getKorisnickoIme()),HttpStatus.OK);
	}
	
	@RequestMapping(value="/komentar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKomentar(@PathVariable Long id){
		Komentar komentar = komentarService.findOne(id);
		if(komentar != null) {
			komentarService.deleteKomentar(id);
			comDataService.deleteCommonData(komentar.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
