package com.example.Messages.controller;

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

import com.example.Messages.DTO.KomentarDTO;
import com.example.Messages.SchemaToJava2.model.entitet.CommonData;
import com.example.Messages.SchemaToJava2.model.entitet.Komentar;
import com.example.Messages.SchemaToJava2.model.user.TUser;
import com.example.Messages.service.CommonDataService;
import com.example.Messages.service.KomentarService;
import com.example.Messages.service.TUserService;

@RestController
public class KomentarController {

	@Autowired
	private KomentarService komentarService;
	@Autowired
	private CommonDataService commonDataService;
	@Autowired
	private TUserService userService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/Komentar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KomentarDTO>> getAllKomentar() {
	
		List<Komentar> allKomentar = komentarService.getAllKomentar();
		
		List<KomentarDTO> komentariDTO = new ArrayList<>();
		for (Komentar k : allKomentar) {
			
			KomentarDTO komentarDTO = new KomentarDTO();
			CommonData comData = commonDataService.findOne(k.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			TUser user = userService.findOne(comData.getUserid());
			komentarDTO.setUsername(user.getKorisnickoIme());
			komentarDTO.setId(k.getId());
			komentarDTO.setAutomobilId(k.getAutomobilId());
			komentarDTO.setCommonDataId(k.getCommonDataId());
			komentarDTO.setOdobren(k.isOdobren());
			komentarDTO.setTekstKomentara(k.getTekstKomentara());
			
			komentariDTO.add(komentarDTO);
		}
		// convert komentar to DTOs
		return new ResponseEntity<>( komentariDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/Komentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> getKomentar(@PathVariable("id") Long id){
		KomentarDTO komentarDTO = new KomentarDTO();
		Komentar k = komentarService.findOne(id);
		
		if (k == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CommonData comData = commonDataService.findOne(k.getCommonDataId());
		TUser user = userService.findOne(comData.getUserid());
		komentarDTO.setUsername(user.getKorisnickoIme());
		komentarDTO.setId(k.getId());
		komentarDTO.setAutomobilId(k.getAutomobilId());
		komentarDTO.setCommonDataId(k.getCommonDataId());
		komentarDTO.setOdobren(k.isOdobren());
		komentarDTO.setTekstKomentara(k.getTekstKomentara());
		
		return new ResponseEntity<>(komentarDTO, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(method=RequestMethod.POST, value="/Komentar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> addKomentar(@RequestBody KomentarDTO komentarDTO)  throws Exception {
		
		Komentar savedKomentar = new Komentar();
		
		//Prilkom kreiranja novog komentara odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = commonDataService.addCommonData(commonData);
		
		savedKomentar.setId(komentarDTO.getId());
		savedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		savedKomentar.setOdobren(komentarDTO.isOdobren());
		savedKomentar.setAutomobilId(komentarDTO.getAutomobilId());
		savedKomentar.setCommonDataId(commonData.getId());
		
		savedKomentar = komentarService.addKomentar(savedKomentar); 
		return new ResponseEntity<>(new KomentarDTO(savedKomentar.getId(),savedKomentar.getTekstKomentara(),savedKomentar.isOdobren(), savedKomentar.getCommonDataId(), savedKomentar.getAutomobilId(), komentarDTO.getUsername()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Komentar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KomentarDTO> updateAutomobil(@RequestBody KomentarDTO komentarDTO) throws Exception{
		
		Komentar updatedKomentar = komentarService.findOne(komentarDTO.getId());
		if(updatedKomentar == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Long comDatId = updatedKomentar.getCommonDataId();
		
		CommonData commonData = commonDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = commonDataService.updateCommonData(comDatId, commonData);
		
		updatedKomentar.setId(komentarDTO.getId());
		updatedKomentar.setTekstKomentara(komentarDTO.getTekstKomentara());
		updatedKomentar.setOdobren(komentarDTO.isOdobren());
		//Ne updejtuje se id automobila
		updatedKomentar.setCommonDataId(comDatId);
		
		updatedKomentar = komentarService.updateKomentar(updatedKomentar.getId(), updatedKomentar);
		 
		return new ResponseEntity<>(new KomentarDTO(updatedKomentar),HttpStatus.OK);
	}
	
	@RequestMapping(value="/Komentar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKomentar(@PathVariable Long id){
		Komentar komentar = komentarService.findOne(id);
		if(komentar != null) {
			komentarService.deleteKomentar(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
