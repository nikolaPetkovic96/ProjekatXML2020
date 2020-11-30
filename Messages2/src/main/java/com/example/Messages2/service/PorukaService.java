package com.example.Messages2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.PorukaRepository;
import com.example.Messages2.service.mapper.PorukaMapper;



@Service
public class PorukaService {
	
	@Autowired
	private  PorukaRepository  porukaRepository;
	@Autowired
	private PorukaMapper porMapper;
	
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
		
		public Poruka updatePoruka(Long id, Poruka poruka) throws Exception {
			Optional<Poruka> porukaKlinCentraToUpadet = porukaRepository.findById(id);
			if (porukaKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Poruka updatePorukaKilCentra = porukaRepository.save(poruka);
			return updatePorukaKilCentra;
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
		
}		
