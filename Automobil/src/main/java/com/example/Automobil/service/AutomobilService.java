package com.example.Automobil.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.dto.AutomobilImgDTO;
import com.example.Automobil.dto.AutomobilNewDTO;
import com.example.Automobil.dto.AutomobilPomDTO;
import com.example.Automobil.dto.TSlikaVozilaDTO;
import com.example.Automobil.model.Automobil;
import com.example.Automobil.model.CommonData;
import com.example.Automobil.model.SlikaVozila;
import com.example.Automobil.model.TSlikaVozila;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.service.mapper.AutomobilMapper;

@Service
public class AutomobilService{
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private AutomobilMapper autoMapper;
	@Autowired
	private CommonDataService comDataService;
	
	@Autowired
	private TSlikaVozilaService slikaVozService;
	
	//SEARCH
	public List<AutomobilDTO> searchAgentsAutomobil(Long markaAutId, Long modelAutId,Long klasaAutId,
			Long tipMenjacaId, Long tipGorivaId, Integer brojSedZaDec, Boolean ColDmgWaiv, Float kilometraza){
		
		//Obrisati na kraju
    	System.out.println("markaAut " + markaAutId);
    	System.out.println("modelAut: " + modelAutId);
    	System.out.println("klasaAut: " + klasaAutId);
    	System.out.println("tipMenjaca: " + tipMenjacaId);
    	System.out.println("tipGoriva: " + tipGorivaId);
    	System.out.println("brojSedZaDec: " + brojSedZaDec);
		System.out.println("ColDmgWaiv: " + ColDmgWaiv);
		System.out.println("kilometraza: " + kilometraza);

		//Preuzima se user iz sesije koji je trenutno ulogovan
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		List<Automobil> allAgentsAutomobil = findAllAutomobilByAgentId(userId);

		if(markaAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getMarkaAutomobilaId() == markaAutId)
					.collect(Collectors.toList());
		}
		if(modelAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getModelAutomobilaId() == modelAutId)
				.collect(Collectors.toList());
		}
		if(klasaAutId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getKlasaAutomobilaId() == klasaAutId)
				.collect(Collectors.toList());
		}
		if(tipMenjacaId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
				.filter(a -> a.getTipMenjacaId() == tipMenjacaId)
				.collect(Collectors.toList());
		}
		if (tipGorivaId != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getVrstaGorivaId() == tipGorivaId)
					.collect(Collectors.toList());
		}
		if (brojSedZaDec != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getBrojSedistaZaDecu() == brojSedZaDec)
					.collect(Collectors.toList());
		}
		if (ColDmgWaiv != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.isCollisionDamageWaiver() == ColDmgWaiv)
					.collect(Collectors.toList());
		}
		if (kilometraza != null) {
			allAgentsAutomobil = allAgentsAutomobil.stream()
					.filter(a -> a.getPredjenaKilometraza() <= kilometraza)
					.collect(Collectors.toList());
		}
		
		//Oni automobili koji su zadovoljili uslove se prebacuju u DTO
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a : allAgentsAutomobil) {
			
			automobilDTO.add(autoMapper.toDTO(a));
			
		}

		return automobilDTO;
	}
		

	public List<AutomobilPomDTO> getAllAutomobil(){
		List<Automobil> allAutomobil = autoRepository.findAll();
		
		List<AutomobilPomDTO> automobilDTO = new ArrayList<>();
		for(Automobil a :  allAutomobil) {
			automobilDTO.add(autoMapper.toPomDTO(a));
		}
		return automobilDTO;
	}
	
	//GET
	/****
	 * 
	 * @return listu svih automobila koje je ulogovani user napravio
	 */
	public List<AutomobilDTO> getAllAutomobilByAgent(){

		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		List<Automobil> allAutomobil = findAllAutomobilByAgentId(userId);
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a :  allAutomobil) {
			automobilDTO.add(autoMapper.toDTO(a));
		}
		return automobilDTO;
	}
	
	//ADD
	public AutomobilImgDTO addNewAutomobil(AutomobilNewDTO dto) throws Exception{
		Automobil savedAutomobil = new Automobil();
		
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		//Prilkom kreiranja nove klase automobila odmah se kreira i commonData koji pamti ko je kreirao i kada.
		CommonData commonData = setCommonData(userId);
	
		savedAutomobil.setId(dto.getId());
		savedAutomobil.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
		savedAutomobil.setModelAutomobilaId(dto.getModelAutomobilaId());
		savedAutomobil.setKlasaAutomobilaId(dto.getKlasaAutomobilaId());
		savedAutomobil.setVrstaGorivaId(dto.getTipGorivaId());
		savedAutomobil.setTipMenjacaId(dto.getTipMenjacaId());
		savedAutomobil.setUkupnaOcena(dto.getUkupnaOcena());
		savedAutomobil.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		savedAutomobil.setCollisionDamageWaiver(dto.isCollisionDamageWaiver());
		savedAutomobil.setBrojSedistaZaDecu(dto.getBrojSedistaZaDecu());
		savedAutomobil.setCommonDataId(commonData.getId());
		
		savedAutomobil = addAutomobil(savedAutomobil);
		
		//SLIKE
		CommonData commonDataImg = setCommonData(userId);
		TSlikaVozila slikaVozila = new TSlikaVozila();
		slikaVozila.setSlika(dto.getSlikeVozila());
		slikaVozila.setCommonDataId(commonDataImg.getId());
		slikaVozila.setAutomobilId(savedAutomobil.getId());
		
		slikaVozila = slikaVozService.addSlikaVozila(slikaVozila);
		
		AutomobilDTO autoDto = autoMapper.toDTO(savedAutomobil);
		return new AutomobilImgDTO(autoDto, new TSlikaVozilaDTO(slikaVozila));
	}
	
	
	//PUT
	public AutomobilDTO updAutomobil(AutomobilNewDTO dto) throws Exception{
		
		Automobil updatedAutomobil = findOne(dto.getId());
		if(updatedAutomobil == null) {
			throw new DataIntegrityViolationException("No car!");
		}
		
		Long comDatId = updatedAutomobil.getCommonDataId();
		
		CommonData commonData = comDataService.findOne(comDatId);
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumIzmene(now);
		commonData = comDataService.updateCommonData(comDatId, commonData);
		
		updatedAutomobil.setId(dto.getId());
		updatedAutomobil.setBrojSedistaZaDecu(dto.getBrojSedistaZaDecu());
		updatedAutomobil.setCollisionDamageWaiver(dto.isCollisionDamageWaiver());
		updatedAutomobil.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		
		updatedAutomobil.setMarkaAutomobilaId(dto.getMarkaAutomobilaId());
		updatedAutomobil.setModelAutomobilaId(dto.getModelAutomobilaId());
		updatedAutomobil.setKlasaAutomobilaId(dto.getKlasaAutomobilaId());
		updatedAutomobil.setVrstaGorivaId(dto.getTipGorivaId());
		updatedAutomobil.setTipMenjacaId(dto.getTipMenjacaId());
		updatedAutomobil.setUkupnaOcena(dto.getUkupnaOcena());
		
		updatedAutomobil.setCommonDataId(comDatId);

		updatedAutomobil = updateAutomobil(updatedAutomobil.getId(), updatedAutomobil);
		
		AutomobilDTO auto  =  autoMapper.toDTO(updatedAutomobil);
		
		//svejedno je sta cemo vratiti kod update
		return auto;
	}
	
	
	//DELETE
	public boolean deleteAutomobil(Long id) throws Exception{
		Automobil automobil = findOne(id);
		if(automobil != null) {
			
			//Provera da li postoji neki oglas kreiran za taj automobil
//			if(oglasService.getAllOglasByAutomobilId(automobil.getId()).size() != 0) {
//				throw new Exception("There is an ad connected to this car!");
//			}
			
			delAutomobil(id);
			comDataService.deleteCommonData(automobil.getCommonDataId());
			return true;
		}else {
			throw new DataIntegrityViolationException("No car!");
		}
	}
	
	
	
	//DODATNE METODE:
	
	private List<AutomobilDTO> getAutomobils(){
		return null;
	}
	

	
	
	/***
	 * 
	 * @param id automobila koji se zeli dobiti
	 * @return vec sredjenDTO automobila...
	 */
	private AutomobilDTO getAutomobil(Long id) {
		return autoRepository.findById(id).map(a -> autoMapper.toDTO(a)).orElse(null);
	}

	public AutomobilDTO findOneDTO(Long id) {
		return autoRepository.findById(id).map(a -> autoMapper.toDTO(a)).orElse(null);
	}
	
	public Automobil findOne(Long id) {

		return autoRepository.findById(id).orElse(null);
	}
	

	public List<Automobil> findAllAutomobilByAgentId(Long agentId) {
		List<Automobil> automobili = new ArrayList<>();
		
		//Dobavim sve oglase iz baze
		List<Automobil> sviAutomobili = autoRepository.findAll();
		
		//Prolazim kroz autlomobile i proveravam da li je agentId = userId u commonData automobila
		for(Automobil a : sviAutomobili){
			if(comDataService.findOne(a.getCommonDataId()).getUserId() == agentId) {
				automobili.add(a);
			}
		}
		
		return automobili;	
	}

	//Pomocna metoda za cuvanje novog Automobila
	public Automobil addAutomobil(Automobil automobil) throws Exception {
		if(automobil.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Automobil savedAutomobil = autoRepository.save(automobil);
		return savedAutomobil;	
	}
	
	public Automobil updateAutomobil(Long id, Automobil automobil) throws Exception{
		Optional<Automobil> automobilToUpdate = autoRepository.findById(id);
		if(automobilToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		Automobil updateAutomobil = autoRepository.save(automobil);
		return updateAutomobil;
	}
	
	//Pomocna metoda za kreiranje novog commonData
	public CommonData setCommonData(Long userId) throws Exception {
		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setDatumKreiranja(now);
		commonData.setUserId(userId); 
		commonData = comDataService.addCommonData(commonData);	
		return commonData;
	}
	
	//ne treba AutomobilDetailsDTO (//Komentari su dobavljeni posebno) 
	public AutomobilImgDTO findOneWithDetails(Long id) throws Exception {
			
			AutomobilDTO autoDTO = getAutomobil(id);
			
			//Dobavljamo slike koje su vezane za njega
			TSlikaVozila s = slikaVozService.getSlikaVozilaByAutomobilId(id);
			TSlikaVozilaDTO slike = new TSlikaVozilaDTO(s);
	
			return new AutomobilImgDTO(autoDTO, slike);
	}

	
	public void delAutomobil(Long id) {
		autoRepository.deleteById(id);
	}
}