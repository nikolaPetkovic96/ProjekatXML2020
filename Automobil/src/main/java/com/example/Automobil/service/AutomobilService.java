package com.example.Automobil.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Automobil.dto.AutomobilAgentDTO;
import com.example.Automobil.dto.AutomobilDTO;
import com.example.Automobil.model.Automobil;
import com.example.Automobil.repository.AutomobilRepository;
import com.example.Automobil.repository.CommonDataRepository;
import com.example.Automobil.service.mapper.AutomobilMapper;

@Service
public class AutomobilService {
	@Autowired
	private AutomobilRepository autoRepository;
	@Autowired
	private AutomobilMapper autoMapper;
	@Autowired
	private CommonDataService comDataService;
	
	private List<AutomobilDTO> getAutomobils(){
		return null;
	}
	private AutomobilDTO getAutomobil(Long id) {
		return autoRepository.findById(id).map(a -> autoMapper.toDTO(a)).orElse(null);
	}


	public List<AutomobilDTO> getAllAutomobil(){
		List<Automobil> allAutomobil = autoRepository.findAll();
		
		List<AutomobilDTO> automobilDTO = new ArrayList<>();
		for(Automobil a :  allAutomobil) {
			automobilDTO.add(autoMapper.toDTO(a));
		}
		return automobilDTO;
	}
	
	/****
	 * 
	 * @return listu svih automobila koje je ulogovani user napravio
	 */
	public List<AutomobilAgentDTO> getAllAutomobilByAgent(){
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		List<Automobil> allAutomobil = findAllAutomobilByAgentId(userId);
		
		List<AutomobilAgentDTO> automobilDTO = new ArrayList<>();
		for(Automobil a :  allAutomobil) {
			automobilDTO.add(autoMapper.toAgentDTO(a));
		}
		return automobilDTO;
	}
	
	
	//DODATNE METODE:
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
}