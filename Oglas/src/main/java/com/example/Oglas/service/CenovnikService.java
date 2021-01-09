package com.example.Oglas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Oglas.dto.CenovnikDTO;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.repository.CenovnikRepository;

@Service
public class CenovnikService {

	@Autowired
	private  CenovnikRepository  cenovnikRepository; 
	@Autowired
	private CommonDataService comDataService;
	
	public List<CenovnikDTO> getAllCenovniks(){
		List<Cenovnik> allCenovnik = getAllCenovnik();
		List<CenovnikDTO> cenovnikDTO = new ArrayList<>();
		
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		//Vraca samo one cenovnike koje je taj user napravio
		for(Cenovnik c : allCenovnik) {
			CommonData comData = comDataService.findOne(c.getCommonDataId());
			if(comData.getUserId() == userId) {
				cenovnikDTO.add(new CenovnikDTO(c));
			}
		}
		return cenovnikDTO;
 	}
	
	
	public CenovnikDTO getCenovnik(@PathVariable("id") Long id){
		Cenovnik cenovnik = findOne(id);
		if(cenovnik == null) {
			return null;
		}
		return new CenovnikDTO(cenovnik);
	}
	
	
	public CenovnikDTO addCenovnik(CenovnikDTO cenovnikDTO) throws Exception{

		Cenovnik savedCenovnik = new Cenovnik();
		
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId(userId); 
		commonData.setDatumKreiranja(now);
		commonData = comDataService.addCommonData(commonData);

		savedCenovnik.setId(cenovnikDTO.getId());
		savedCenovnik.setCenaCollisionDamageWaiver(cenovnikDTO.getCenaCollisionDamageWaiver());
		savedCenovnik.setCenaPoDanu(cenovnikDTO.getCenaPoDanu());
		savedCenovnik.setCenaPoKilometru(cenovnikDTO.getCenaPoKilometru());
		savedCenovnik.setNazivCenovnika(cenovnikDTO.getNazivCenovnika());
//		savedCenovnik.setPopustZaPreko30Dana(cenovnikDTO.getPopustZaPreko30Dana());
		
		savedCenovnik.setCommonDataId(commonData.getId());
		
		savedCenovnik = addCenovnik(savedCenovnik);
		return new CenovnikDTO(savedCenovnik);
	}
	
	
	public CenovnikDTO updateCenovnik(CenovnikDTO cenovnikDTO) throws Exception{
		
		Cenovnik updatedCenovnik = findOne(cenovnikDTO.getId());
		if(updatedCenovnik == null) {
			return null; //Ili onaj neki exception;
		}
		
		Long comDatId = updatedCenovnik.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updatedCenovnik.setId(cenovnikDTO.getId());
		updatedCenovnik.setCenaCollisionDamageWaiver(cenovnikDTO.getCenaCollisionDamageWaiver());
		updatedCenovnik.setCenaPoDanu(cenovnikDTO.getCenaPoDanu());
		updatedCenovnik.setCenaPoKilometru(cenovnikDTO.getCenaPoKilometru());
		updatedCenovnik.setNazivCenovnika(cenovnikDTO.getNazivCenovnika());
		updatedCenovnik.setPopustZaPreko30Dana(cenovnikDTO.getPopustZaPreko30Dana());
		
		updatedCenovnik.setCommonDataId(comDatId);
		
		updatedCenovnik = updateCenovnik(updatedCenovnik.getId(), updatedCenovnik);
		return new CenovnikDTO(updatedCenovnik);
	}
	
	@Transactional(value=TxType.REQUIRED)
	public boolean deleteCenovnik(Long id){
		Cenovnik cenovnik = findOne(id);
		if(cenovnik != null) {
//			TODO if(cenovnik postoji u nekom oglasu ne moze se obristai)
			delCenovnik(id);
			comDataService.deleteCommonData(cenovnik.getCommonDataId());
			return true;
		}else {
			throw new DataIntegrityViolationException("No price!");
		}
	}	

	
	//POMOCNE METODE ZA KOMUNIKACIJU SA REPOSITORY SLOJEM
	
	public List< Cenovnik> getAllCenovnik(){
		List< Cenovnik>  cenovnici = new ArrayList<>();
		cenovnikRepository.findAll().forEach(cenovnici::add);
			return cenovnici;
		}
	
	public Cenovnik findOne(Long id) {
		return cenovnikRepository.findById(id).orElseGet(null);
	}
	
	public Cenovnik addCenovnik(Cenovnik cenovnik) throws Exception{
		if(cenovnik.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Cenovnik savedCenovnik = cenovnikRepository.save(cenovnik);
		return savedCenovnik;
	}
	
	public Cenovnik updateCenovnik(Long id, Cenovnik cenovnik) throws Exception{
		Optional<Cenovnik> cenovnikToUpdate = cenovnikRepository.findById(id);
		if(cenovnikToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Cenovnik updateCenovnik = cenovnikRepository.save(cenovnik);
		return updateCenovnik;
	}
	
	public void delCenovnik(Long id) {
		cenovnikRepository.deleteById(id);
	}
	
}
