//package com.example.Messages.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Messages.DTO.AdministratorDTO;
//import com.example.Messages.SchemaToJava2.model.user.Administrator;
//import com.example.Messages.service.AdministratorService;
//
//@RestController
//public class AdministratorController {
//
//	@Autowired
//	private AdministratorService adminService;
//	
//	//GET ALL	
//	@RequestMapping(method=RequestMethod.GET, value="/Administrator", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<AdministratorDTO>> getAllAdministrator() {
//	
//		List<Administrator> allAdmin = adminService.getAllAdministrator();
//		
//		List<AdministratorDTO> adminDTO = new ArrayList<>();
//		for (Administrator a : allAdmin) {
//			adminDTO.add(new AdministratorDTO(a));
//		}
//		// convert admin to DTOs
//		return new ResponseEntity<>(adminDTO, HttpStatus.OK);
//	}
//	
//	//GET
//	@RequestMapping(method=RequestMethod.GET, value="/Administrator/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable("id") Long id){
//		
//		Administrator admin = adminService.findOne(id);
//		//return radnikService.getRadnik(id);
//		if (admin == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(new AdministratorDTO(admin), HttpStatus.OK);
//		
//	}
//	
//	//POST
//	//Ovo kaze metoda addAdministrator hendla svaki zahtev sa url '/Administrator' koji ima http zahtev POST:
//	@RequestMapping(method=RequestMethod.POST, value="/Administrator",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AdministratorDTO> addAdministrator(@RequestBody AdministratorDTO adminDTO)  throws Exception {
//		Administrator savedAdmin = new Administrator();
//		
//		savedAdmin.setId(adminDTO.getId());	
//		savedAdmin.setIme(adminDTO.getIme());	
//		savedAdmin.setPrezime(adminDTO.getPrezime());	
//		savedAdmin.setJmbg(adminDTO.getJmbg());	
//		
//		savedAdmin  = adminService.addAdministrator(savedAdmin);
//		return new ResponseEntity<>(new AdministratorDTO(savedAdmin), HttpStatus.CREATED);
//	}
//	
//	//PUT
//	@RequestMapping(method=RequestMethod.PUT, value="/Administrator", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AdministratorDTO> updateAdministrator(@RequestBody AdministratorDTO adminDTO) throws Exception{
//		
//		Administrator updatedAdmin = adminService.findOne(adminDTO.getId());
//		
//		if (updatedAdmin == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		// we allow changing date and points for an administratpr only
//		updatedAdmin.setId(adminDTO.getId());			
//		updatedAdmin.setIme(adminDTO.getIme());	
//		updatedAdmin.setPrezime(adminDTO.getPrezime());	
//		updatedAdmin.setJmbg(adminDTO.getJmbg());	
//		
//		updatedAdmin = adminService.updateAdministrator(updatedAdmin.getId(), updatedAdmin);
//		return new ResponseEntity<>(new AdministratorDTO(updatedAdmin), HttpStatus.OK);
//	}
//
//			
//	//DELET	
//	@RequestMapping(value="/Administrator/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
//		
//		Administrator admin = adminService.findOne(id);
//		if (admin != null) {
//			adminService.deleteAdministrator(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} 
//	}
//	
//}
