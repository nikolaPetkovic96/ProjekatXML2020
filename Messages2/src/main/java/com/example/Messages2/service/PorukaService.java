package com.example.Messages2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Messages2.dto.CommonDataDTO;
import com.example.Messages2.dto.PorukaDTO;
import com.example.Messages2.model.CommonData;
import com.example.Messages2.model.Poruka;
import com.example.Messages2.repository.PorukaRepository;
import com.example.Messages2.service.mapper.PorukaMapper;



@Service
public class PorukaService {
	
	@Autowired
	private  PorukaRepository  porukaRepository;
	
	@Autowired
	private PorukaMapper porMapper;
	
	@Autowired
	private CommonDataService comDataService;
	
		//GET ALL (ne koristi se trenutno)
		//ovde sam ostavio da je bez rez_id jer ako stavimo onu proveru onda ne moze u controlleru 
		//biti required rez_id, a nekada se on nece prosledjivati sto ce praviti error, a ako se 
		//stalno prosldjuje nikada nece uci u slucaj kada je null...
		public List<PorukaDTO> getAllMessages(){
			return porukaRepository.findAll().stream().map(p->porMapper.toDTO(p)).collect(Collectors.toList());
		}
		
		//GET ALL BY REZERVACIJA IN ORDER
		public List<PorukaDTO> getAllMessagesByRezerv(Long rez_id){	//sve poruke razmenjene u vezi rezervacije
			List<Poruka> poruke = findAllPorukeByRezervId(rez_id);
			return  poruke.stream().map(p->porMapper.toDTO(p)).collect(Collectors.toList());
		}
		
		//IN ORDER vraca poruke, mozda se bude prebacivala i u rezervacija servis
		public List<Poruka> findAllPorukeByRezervId(Long rezervId) {
			List<Poruka> poruke = porukaRepository.findAllByRezervacijaId(rezervId);
			
			//Sortiranje poruka po datumu;
			poruke.sort((p1,p2) -> comDataService.findOne(p1.getCommonDataId()).getDatumKreiranja()
					.compareTo(comDataService.findOne(p2.getCommonDataId()).getDatumKreiranja()));
			
			return poruke;
		}
		
		//GET ONE (ne koristi se trenutno)
		public PorukaDTO getPoruka(Long id) {
			return porukaRepository.findById(id).map(por-> porMapper.toDTO(por)).orElseGet(null);
		}
		
		//ADD (bitno)
		public PorukaDTO createPoruka(PorukaDTO dto, String username) throws Exception {
			
			Poruka savedPoruka = new Poruka();
			
			//Ovako se izvalaci id usera iz zahteva
			HttpServletRequest request = 
			        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
			                .getRequest();
			Long userId = Long.parseLong(request.getHeader("userid"));
			
			//Prilkom kreiranja novog komentara odmah se kreira i commonData koji pamti ko je kreirao i kada.
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumKreiranja(now);
			commonData.setUserId(userId);
			commonData = comDataService.addCommonData(commonData);
			
			
			savedPoruka.setId(dto.getId());
			savedPoruka.setUsername(username);
			savedPoruka.setTekstPoruke(dto.getTekstPoruke());
			savedPoruka.setAutomobilId(dto.getAutomobilId());
			savedPoruka.setRezervacijaId(dto.getRezervacijaId());
			savedPoruka.setCommonDataId(commonData.getId());
			
			savedPoruka = addPoruka(savedPoruka);
		
			return new PorukaDTO(savedPoruka, new CommonDataDTO(commonData));
			
		}
		
		//DELETE (ne koristi se trenutno)
		public void deletePoruka(Long id) {
			porukaRepository.deleteById(id);
		}

		
		public Poruka addPoruka(Poruka poruka)throws Exception{
			  if (poruka.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Poruka savedPoruka = porukaRepository.save(poruka);
		        return savedPoruka;
			
		}
}		
