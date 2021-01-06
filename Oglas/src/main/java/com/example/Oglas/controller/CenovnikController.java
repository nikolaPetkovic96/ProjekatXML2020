package com.example.Oglas.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.repository.service.CenovnikService;
import com.example.Oglas.repository.service.CommonDataService;


@RestController
@RequestMapping(value="/cenovnik")	
public class CenovnikController {
	@Autowired
	private  CenovnikService cenServ;
	
	@GetMapping(value="")
	public ResponseEntity<List<CenovnikDTO>> getAllCenovnik(){
		List<CenovnikDTO> svi=cenServ.getAllCenovnik();
		if(svi!=null)
			return new ResponseEntity<>(svi, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CenovnikDTO> getCenovnik(@PathVariable("id") Long id){
		CenovnikDTO dto=cenServ.getOne(id);
		if(dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	@PostMapping(value="")
	public ResponseEntity<CenovnikDTO> addCenovnik(Principal principal, @RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		Cenovnik dodati=cenServ.createCenovnik(cenovnikDTO, this.getUserId());
		return new ResponseEntity<>(new CenovnikDTO(dodati), HttpStatus.CREATED);

	}
	@PutMapping(value="")
	public ResponseEntity<CenovnikDTO> updateCenovnik(@RequestBody CenovnikDTO cenovnikDTO) throws Exception{
		Cenovnik updated=cenServ.updateCenovnik(cenovnikDTO);
		if(updated==null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(new CenovnikDTO(updated),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCenovnik(@PathVariable Long id){
		Cenovnik deleted=cenServ.deleteCenovnik(id);
		if(deleted!=null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	private Long getUserId() {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		return userId;
	}
}
