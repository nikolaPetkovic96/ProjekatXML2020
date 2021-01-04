package com.example.Messages2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.CommonData;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.CommonDataRepository;
import com.example.Messages2.repository.PorukaRepository;
import com.example.Messages2.service.mapper.PorukaMapper;



@Service
public class PorukaService {
	
	@Autowired
	private  PorukaRepository  porukaRepository;
	@Autowired
	private PorukaMapper porMapper;
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private CommonDataService cmdServ;
	
	public List< Poruka> getAllPoruka(){
		List< Poruka>  porukaKlinCentra = new ArrayList<>();
			porukaRepository.findAll().forEach(porukaKlinCentra::add);
			return porukaKlinCentra;
		}

		public PorukaDTO getPoruka(Long id) {
			return porukaRepository.findById(id).map(por-> porMapper.toDTO(por)).orElseGet(null);
		}
		
		public Poruka addPoruka(Poruka poruka)throws Exception{
			  if (poruka.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Poruka savedPorukaKlinCentra = porukaRepository.save(poruka);
		        return savedPorukaKlinCentra;
			
		}
		
		public PorukaDTO updatePoruka(Long id, PorukaDTO dto) throws Exception {
			Poruka p=porukaRepository.findById(dto.getId()).orElseGet(null);
			if(p==null) {
				return null;
			}
			CommonData postojeci=cmdRep.findById(p.getCommonDataId()).orElseGet(null);
			LocalDateTime now=LocalDateTime.now();
			postojeci.setDatumIzmene(now);
			postojeci=cmdServ.updateCommonData(postojeci.getId(), postojeci);
			
			p.setId(dto.getId());
			p.setTekstPoruke(dto.getTekstPoruke());
			p.setCommonDataId(postojeci.getId());
			
			p=porukaRepository.save(p);
			return porMapper.toDTO(p);
			
		}
		
		public void deletePoruka(Long id) {
			porukaRepository.deleteById(id);
		}
		public List<PorukaDTO> getAllMessages(Long rez_id){	//sve poruke razmenjene u vezi rezervacije
			return porukaRepository.findAll().stream().filter(p-> p.getRezervacijaId()==rez_id).map(p->porMapper.toDTO(p)).collect(Collectors.toList());
		}
		public PorukaDTO createPoruka(PorukaDTO dto) {
			Poruka p=porMapper.fromDTO(dto);
			p= porukaRepository.saveAndFlush(p);
			return porMapper.toDTO(p);
		}

		public List<PorukaDTO> getAllMessages() {
			// TODO Auto-generated method stub
			return porukaRepository.findAll().stream().map(p->porMapper.toDTO(p)).collect(Collectors.toList());
			}
		
}		
