package com.team32.AgentApp.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.UserDTO;
import com.team32.AgentApp.DTO.UserNewDTO;
import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.service.AdresaService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.UserService;

import com.team32.AgentApp.security.exception.ResourceConflictException;


@RestController
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommonDataService comDataService;
	
	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	//GET ALL
	@PreAuthorize("hasRole('ROLE_AGENT')")
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
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.GET, value="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUser(Principal principal, @PathVariable("id") Long id){

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
	
	//Za sada ne treba post metoda
//	@RequestMapping(method=RequestMethod.POST, value="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserDTO> addRezervacija(@RequestBody UserDTO dto) throws Exception{
//		
//		User savedUser = new User();
//		
//		CommonData commonData = new CommonData();
//		LocalDateTime now = LocalDateTime.now();
//		commonData.setDatumKreiranja(now);
//		commonData.setUserId((long) 1); //OVO IZMENITI DA BUDE DINAMICKI
//		commonData = comDataService.addCommonData(commonData);
//		
//		savedUser.setId(dto.getId());
//		savedUser.setKorisnickoIme(dto.getKorisnickoIme());
//		savedUser.setLozinka(dto.getLozinka());
//		savedUser.setEmail(dto.getEmail());
//		savedUser.setStatus(dto.getStatus());
//		savedUser.setAdresaId(dto.getAdresaId());
//		savedUser.setIme(dto.getIme());
//		savedUser.setPrezime(dto.getPrezime());
//		savedUser.setJmbg(dto.getJmbg());
//		savedUser.setNaziv(dto.getNaziv());
//		savedUser.setPoslovniMaticniBroj(dto.getPoslovniMaticniBroj());
//		savedUser.setPol(dto.getPol());		
//		savedUser.setCommonDataId(commonData.getId());
//		
//		savedUser = userService.addUser(savedUser);
//
//		return new ResponseEntity<>(new UserDTO(savedUser), HttpStatus.CREATED);
//	}
	@PreAuthorize("hasRole('ROLE_AGENT')")
	@RequestMapping(method=RequestMethod.PUT, value="/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserNewDTO> updateUser(Principal principal, @RequestBody UserNewDTO dto) throws Exception{
		System.out.println("Usao u updateUser");
		//Dobavljanje username iz zahteva
//		String username = principal.getName();
		
		User updatedUser = userService.findOne(dto.getId());
		if(updatedUser == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		//Ukoliko je prosledjena lozinka za potvrdu to znaci da user hoce da je promeni
		//Poredi se lozinka za potvrdu sa starom lozinkom i ako su iste sacuva se nova lozinka
		if(dto.getLozinkaZaPotvrdu() != null) {
			if(passwordEncoder.matches(dto.getLozinkaZaPotvrdu(), updatedUser.getLozinka())) {
				updatedUser.setLozinka(passwordEncoder.encode(dto.getLozinka()));
			}
			else {
				throw new ResourceConflictException(dto.getId(), "Incorrect old password!");
			}
		}
		CommonData commonData = updateCommonData(updatedUser.getCommonDataId());
		
		//Ukoliko se menja adresa oglasa.
		Adresa adresa = updateUsersAdresa(dto, updatedUser.getAdresaId());
		//Izvrsi se cuvanje izmenjene adrese i kreira na osnovu povratne vrednosti(nje same) DTO.
		AdresaDTO updatedAdresaDTO = new AdresaDTO(adresaService.updateAdresa(adresa.getId(), adresa));
		
		updatedUser.setId(dto.getId());
		updatedUser.setKorisnickoIme(dto.getKorisnickoIme());
		updatedUser.setEmail(dto.getEmail());
		updatedUser.setStatus(dto.getStatus());
		updatedUser.setAdresaId(dto.getAdresaId());
		updatedUser.setIme(dto.getIme());
		updatedUser.setPrezime(dto.getPrezime());
		updatedUser.setJmbg(dto.getJmbg());
		updatedUser.setNaziv(dto.getNaziv());
		updatedUser.setPoslovniMaticniBroj(dto.getPoslovniMaticniBroj());
		updatedUser.setPol(dto.getPol());		
		updatedUser.setCommonDataId(commonData.getId());
			
		updatedUser = userService.updateUser(updatedUser.getId(), updatedUser);
		return new ResponseEntity<>(new UserNewDTO(updatedUser, updatedAdresaDTO),HttpStatus.OK);
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
	
	//POMOCNA METODA
	
	//Pomocna metoda za azuriranje postojeceg commonData
	public CommonData updateCommonData(Long comDataId) throws Exception {
		CommonData commonData = comDataService.findOne(comDataId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDataId, commonData);
		return commonData;
	}
	
	//Pomocna metoda koja azurira adresu prilikom azuriranja agenta sa kojim je povezana
	public Adresa updateUsersAdresa(UserNewDTO dto, Long adresaId) throws Exception {
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
	
}
