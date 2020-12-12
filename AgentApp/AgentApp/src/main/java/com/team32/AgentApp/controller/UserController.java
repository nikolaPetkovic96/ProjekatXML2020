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

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.UserDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.service.AdresaService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.UserService;

@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonDataService comDataService;
	
	@Autowired
	private AdresaService adresaService;
	
	//GET ALL
	@RequestMapping(method=RequestMethod.GET, value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		
		List<User> allUsers = userService.getAllUser();
		
		List<UserDTO> usersDTO = new ArrayList<>();
		for(User u : allUsers) {
			
			UserDTO userDTO = new UserDTO();
			CommonData comData = comDataService.findOne(u.getCommonDataId());
			
			if(comData == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			userDTO.setId(u.getId());
			userDTO.setKorisnickoIme(u.getKorisnickoIme());
			userDTO.setLozinka(u.getLozinka());
			userDTO.setEmail(u.getEmail());
			userDTO.setStatus(u.getStatus());
			userDTO.setAdresaId(u.getAdresaId());
			userDTO.setIme(u.getIme());
			userDTO.setPrezime(u.getPrezime());
			userDTO.setJmbg(u.getJmbg());
			userDTO.setNaziv(u.getNaziv());
			userDTO.setPoslovniMaticniBroj(u.getPoslovniMaticniBroj());
			userDTO.setPol(u.getPol());
			userDTO.setCommonDataId(u.getCommonDataId());
			
			if(adresaService.findOne(u.getAdresaId()) == null) {
				System.out.println("Nema takve adrese!");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				AdresaDTO adresaDTO = new AdresaDTO(adresaService.findOne(u.getAdresaId()));
				userDTO.setAdresa(adresaDTO);
			}

			usersDTO.add(userDTO);
			
		}
		return new ResponseEntity<>(usersDTO, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method=RequestMethod.GET, value="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id){
		UserDTO userDTO = new UserDTO();
		User user = userService.findOne(id);
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userDTO.setId(user.getId());
		userDTO.setKorisnickoIme(user.getKorisnickoIme());
		userDTO.setLozinka(user.getLozinka());
		userDTO.setEmail(user.getEmail());
		userDTO.setStatus(user.getStatus());
		userDTO.setAdresaId(user.getAdresaId());
		userDTO.setIme(user.getIme());
		userDTO.setPrezime(user.getPrezime());
		userDTO.setJmbg(user.getJmbg());
		userDTO.setNaziv(user.getNaziv());
		userDTO.setPoslovniMaticniBroj(user.getPoslovniMaticniBroj());
		userDTO.setPol(user.getPol());
		userDTO.setCommonDataId(user.getCommonDataId());
		
		if(adresaService.findOne(user.getAdresaId()) == null) {
			System.out.println("Nema takve adrese!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			AdresaDTO adresaDTO = new AdresaDTO(adresaService.findOne(user.getAdresaId()));
			userDTO.setAdresa(adresaDTO);
		}
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addRezervacija(@RequestBody UserDTO dto) throws Exception{
		
		User savedUser = new User();
		
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
		commonData = comDataService.addCommonData(commonData);
		
		savedUser.setId(dto.getId());
		savedUser.setKorisnickoIme(dto.getKorisnickoIme());
		savedUser.setLozinka(dto.getLozinka());
		savedUser.setEmail(dto.getEmail());
		savedUser.setStatus(dto.getStatus());
		savedUser.setAdresaId(dto.getAdresaId());
		savedUser.setIme(dto.getIme());
		savedUser.setPrezime(dto.getPrezime());
		savedUser.setJmbg(dto.getJmbg());
		savedUser.setNaziv(dto.getNaziv());
		savedUser.setPoslovniMaticniBroj(dto.getPoslovniMaticniBroj());
		savedUser.setPol(dto.getPol());		
		savedUser.setCommonDataId(commonData.getId());
		
		savedUser = userService.addUser(savedUser);

		return new ResponseEntity<>(new UserDTO(savedUser), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto) throws Exception{
		
		User updatedUser = userService.findOne(dto.getId());
		if(updatedUser == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Long comDatId = updatedUser.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updatedUser.setId(dto.getId());
		updatedUser.setKorisnickoIme(dto.getKorisnickoIme());
		updatedUser.setLozinka(dto.getLozinka());
		updatedUser.setEmail(dto.getEmail());
		updatedUser.setStatus(dto.getStatus());
		updatedUser.setAdresaId(dto.getAdresaId());
		updatedUser.setIme(dto.getIme());
		updatedUser.setPrezime(dto.getPrezime());
		updatedUser.setJmbg(dto.getJmbg());
		updatedUser.setNaziv(dto.getNaziv());
		updatedUser.setPoslovniMaticniBroj(dto.getPoslovniMaticniBroj());
		updatedUser.setPol(dto.getPol());		
		updatedUser.setCommonDataId(comDatId);
		
		updatedUser = userService.updateUser(updatedUser.getId(), updatedUser);
		return new ResponseEntity<>(new UserDTO(updatedUser),HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		User user = userService.findOne(id);
		if(user != null) {
			userService.deleteUser(id);
			comDataService.deleteCommonData(user.getCommonDataId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
