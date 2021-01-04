package com.example.Oglas.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.repository.TAdresaRepository;
import com.example.Oglas.repository.service.CommonDataService;
import com.example.Oglas.repository.service.NarudzbenicaService;
import com.example.Oglas.repository.service.OglasService;
import com.example.Oglas.repository.service.TAdresaService;
import com.example.Oglas.repository.service.UserService;

@RestController
@RequestMapping(value="/oglas")
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
	private TAdresaRepository adresaRep;
		
	@GetMapping(value="")
	public ResponseEntity<List<OglasDTO>> getAllOglas() {
		List<OglasDTO> all=oglasService.getAll();
		if(all!=null)
			return new ResponseEntity<>(all, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/user")
	public ResponseEntity<List<OglasDTO>> getAllAgentsOglas(String username) {
		
		List<OglasDTO> all=oglasService.getOglaseForUser(userService.findByUsername(username).getId());
		if(all!=null)
			return new ResponseEntity<>(all, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value= "/{id}")
	public ResponseEntity<OglasDTO> getOglas(@PathVariable("id") Long id){
		OglasDTO o=oglasService.getOglas(id);
		if(o!=null)
			return new ResponseEntity<>(o, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(value= "/{id}/details")		//todo
	public ResponseEntity<OglasDTO> getOglasDetails(@PathVariable("id") Long id){
		OglasDTO o=oglasService.getOglasDetails(id);
		if(o!=null)
			return new ResponseEntity<>(o, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PostMapping(value="")
	public ResponseEntity<OglasDTO> addOglas(Principal principal, @RequestBody OglasNewDTO dto)  throws Exception {
		String username=principal.getName();
		OglasDTO novi=oglasService.addOglas(dto, username);
		if(novi!=null)
			return new ResponseEntity<>(novi, HttpStatus.CREATED);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteOglas(@PathVariable Long id) {
		Boolean uspeh=oglasService.deleteOglas(id);
		if(uspeh)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


}
