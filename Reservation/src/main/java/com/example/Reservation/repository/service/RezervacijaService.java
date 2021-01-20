package com.example.Reservation.repository.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.NarudzbenicaNewDTO;
import com.example.Reservation.dto.OglasDTO;
import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.dto.RezervacijaFullDTO;
import com.example.Reservation.dto.RezervacijaNewDTO;
import com.example.Reservation.dto.RezervacijaStatusDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.RezervacijaRepository;
import com.example.Reservation.repository.service.mapper.RezervacijaMapper;

@Service
public class RezervacijaService {
	@Autowired
	private  RezervacijaRepository  rezervacijaRepository;
	@Autowired
	private CommonDataRepository commonDataRepository;
	@Autowired 
	private RezervacijaMapper rezMappper;
	@Autowired
	private OglasRepository oglasRep;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NarudzbenicaService narServ;
	@Autowired
	private OglasService oglServ;
	
	
/**************************************GET**************************************/
	
	public  RezervacijaDTO getRezervacija(Long rezervacija_id) {	
		return rezMappper.toDTO(rezervacijaRepository.getOne(rezervacija_id));
	}
	public  Rezervacija FindRezervacija(Long rezervacija_id) {	
		return rezervacijaRepository.getOne(rezervacija_id);
	}
	public RezervacijaFullDTO getRezervacijaFull(Long id) {
		Rezervacija r=rezervacijaRepository.findById(id).orElseGet(null);
		return rezMappper.toDTOFull(r);
	}
	
	public List<RezervacijaFullDTO> getAllRezervacijeOglas(Long oglas_id){
		List<RezervacijaFullDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTOFull(r)));
		List<RezervacijaFullDTO> RezWithOglas=new ArrayList<>();
		for(RezervacijaFullDTO r : allDTO) {
			for(NarudzbenicaDTO n: r.getNarudzbenice()) {
				if(n.getOglasId().equals(oglas_id))
					RezWithOglas.add(r);
			}
		}
		return RezWithOglas;
	}
	
	
/*********************************UPDATE STATUS***********************************/	
	
	public RezervacijaStatusDTO updateStatus(RezervacijaStatusDTO dto) throws Exception {
		Rezervacija r = rezervacijaRepository.findById(dto.getRezervacijaId()).orElse(null);
		CommonData cmd=commonDataRepository.findById(r.getCommonDataId()).orElse(null);
		
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(), cmd);
		
		r.setCommonDataId(cmd.getId());
		r.setStatusRezervacije(dto.getStatusRezervacije());
		r = rezervacijaRepository.save(r);
		
		return new RezervacijaStatusDTO(r.getId(), r.getStatusRezervacije());
	}
	
/*********************************************************************************/	
	
	public List<RezervacijaDTO> getAllStatus(String status) {
		return rezervacijaRepository.findAll().stream().
									filter(r->r.getStatusRezervacije().equals(status)).
									map(x->rezMappper.toDTO(x)).collect(Collectors.toList());
	}
	

	
/************************************DODAVANJE NOVE**********************************/
	
	public List<RezervacijaNewDTO> createRezervacija(List<RezervacijaNewDTO> dtos, String username) throws Exception {
		List<RezervacijaNewDTO> kreiraneRezervacije = new ArrayList<>();
		

		
		for(RezervacijaNewDTO dto : dtos) {
			//commonData za rezervaciju
			CommonData commonData = new CommonData();
			commonData.setId(dto.getCommonDataId());
			commonData.setDatumKreiranja(LocalDateTime.now());
			commonData.setDatumIzmene(null);
			commonData.setUserId(getActiveUserId());
			commonData=cmdServ.addCommonData(commonData);
			
			Rezervacija novaRez=new Rezervacija();
			novaRez.setCommonDataId(commonData.getId());
			novaRez.setCommonDataId(commonData.getId());
			novaRez.setBundle(dto.getBundle());
			novaRez.setStatusRezervacije(dto.getStatusRezervacije()); 
			novaRez.setUkupnaCena(dto.getUkupnaCena());
			novaRez.setUsername(username);
			
			novaRez=rezervacijaRepository.save(novaRez);//sacuvaj rezervaciju u bazi i vrati je sa id-jem
			
			List<NarudzbenicaNewDTO> kreiraneNarudzbenice = new ArrayList<>();
			List<NarudzbenicaNewDTO>  test = dto.getNarudzbenice();
			for(NarudzbenicaNewDTO nDTO : dto.getNarudzbenice()) {
				nDTO.setRezervacijaId(novaRez.getId());	//postavi id rezervacije
				nDTO.setId(null);//postavi id na null, za svaki slucaj zbog cuvanja
				nDTO.setUserId(extractUserId());
				NarudzbenicaNewDTO n =	narServ.add(nDTO);	//sacuva se narudzbenica u bazu i vraca se u formatu NarudzbenicaNewDTO
				kreiraneNarudzbenice.add(n);
			}
			kreiraneRezervacije.add(new RezervacijaNewDTO(novaRez, kreiraneNarudzbenice));	//dodate sve narudzbenice, dodaj rezervaciju u listu rezervacija
		}
		return kreiraneRezervacije;
	}
	
	public Long extractUserId() {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		return Long.parseLong(request.getHeader("userid"));
	}

/***************************************GET ALL ADMIN*********************************************/
	
	public List<RezervacijaFullDTO> getAllRezervacijeFull() {
		List<RezervacijaFullDTO> lista = rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTOFull(x)).collect(Collectors.toList());
		lista=sortiraneRezervacijeFull(lista);
		return lista;
	}
	
	public List<RezervacijaDTO> getAllRezervacije(){//ok
		List<RezervacijaDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTO(r)));
		return allDTO;
	}
	
/****************************************GET ALL AGENT*******************************************/
	
	public List<Rezervacija> getAllRezervacijeAgent(String name) {	//radi samo za trenutno ulogovanog
		List<Rezervacija> sveOdAgenta=new ArrayList<>();
			//List<Narudzbenica> narIds=narServ.getAllForAgent(getActiveUserId())	//;//sve  narudzbenice sa id-jem ogalsa koji se trenutno posmatra
		List<Long> rezervacijeIds=narServ.getAllForAgent(getActiveUserId())//vraca sve narudzbenice vezane za agenta
											.stream()	//uzima samo id-jeve rezervacija koji su u tim naruzdbenicama
											.map(n->n.getRezervacijaId())
											.distinct()	//uklanja duplikate
											.collect(Collectors.toList());
			//rezervacijeIDs sadrzi idjeve rezervacija iz liste narudzbenica koje su vezane za agenta, i izbaceni duplikati
		for (Long rezId : rezervacijeIds){
			sveOdAgenta.add(FindRezervacija(rezId));
		}	
		return sveOdAgenta;
	}
	
	/***
	 * 
	 * @param name username trenutno ulogovanog korisnika
	 * @return listu rezervacijaFullDTO koje su drugi korisnici kreirali nad njegovim oglasima
	 */
	public List<RezervacijaFullDTO> getAllRezervacijeAgentFullDTO(String name) {	//konvertuje rezervacije trenuto ulogovano agenta u FullDTO
		return sortiraneRezervacijeFull(getAllRezervacijeAgent(name).stream().map(r->rezMappper.toDTOFull(r)).collect(Collectors.toList()));
	}
	/***
	 * 
	 * @param name username trenutno ulogovanog korisnika
	 * @return listu rezervacijaDTO koje su drugi korisnici kreirali nad njegovim oglasima
	 */
	public List<RezervacijaDTO> getAllRezervacijeAgentDTO(String name) {	//konvertuje rezervacije trenuto ulogovano agenta u DTO
		return sortiraneRezervacije(getAllRezervacijeAgent(name).stream().map(r->rezMappper.toDTO(r)).collect(Collectors.toList()));
	}
	
	//placene, zavrsene rezervacije u kojima su oglasi agenta
	public List<RezervacijaDTO> getAllFinishedForAgent(String name) {
		List<RezervacijaDTO> agentAll = getAllRezervacijeAgentDTO(name);
		agentAll=agentAll.stream().filter(r->r.getStatusRezervacije().toUpperCase().equals("PAID")
											&& getKrajRezervacije(r.getId()).isBefore(LocalDateTime.now())).
											collect(Collectors.toList());
		return agentAll;
	}

/*****************************************GET ALL USER********************************************/
	
	public List<RezervacijaFullDTO> getAllRezervacijeUserFull(String name) {
		// TODO Auto-generated method stub
		return sortiraneRezervacijeFull(getAllRezervacijeUser(name).stream().map(r->rezMappper.toDTOFull(r)).collect(Collectors.toList()));
	}
	/***
	 * 
	 * @param name username trenutno ulogovanog korisnika 
	 * @return listu rezervacija koje je korisnik kreirao nad tudjim oglasima
	 */
	public List<RezervacijaDTO> getAllRezervacijeUserDTO(String name) {
		// TODO Auto-generated method stub
		return sortiraneRezervacije(getAllRezervacijeUser(name).stream().map(r->rezMappper.toDTO(r)).collect(Collectors.toList()));
	}
	
	public List<Rezervacija> getAllRezervacijeUser(String username){
		List<Rezervacija> allDTO = rezervacijaRepository.findAll();
		allDTO.removeIf(r -> !r.getUsername().equals(username));
		return allDTO;
	}
	
	//placne, zavrsene rezervacije koje je kreirao korisnik
	public List<RezervacijaDTO> getAllFinishedForUser(String username) {
		List<RezervacijaDTO> rezervacije =	rezervacijaRepository.findAll().stream().			
											filter(r->r.getStatusRezervacije().toUpperCase().equals("PAID")
													&& getKrajRezervacije(r.getId()).isBefore(LocalDateTime.now()) 
													&& r.getUsername().equals(username)).
											map(x->rezMappper.toDTO(x)).
											collect(Collectors.toList());
		
		return sortiraneRezervacije(rezervacije);
	}
	

/*****************************************POMOCNE METODE ******************************************/
	
	public Rezervacija addRezervacija(Rezervacija r) throws Exception {
		if(r.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Rezervacija saved=rezervacijaRepository.save(r);
		return saved;
	}
	public Boolean deleteRezervacija(Long id) {
		Rezervacija r= rezervacijaRepository.findById(id).orElse(null);
		if (r==null)
			return false;
		else {//obrisati narudzbenice
			List<Narudzbenica> narudzbenice=narServ.getAllByRezNar(id);
			for(Narudzbenica n: narudzbenice) {
				narServ.delete(n.getId());
			}
		}
		return true;
	}
	
	private Long getActiveUserId() {
		//Ovako se izvalaci id usera iz zahteva
				HttpServletRequest request = 
				        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
				                .getRequest();
				
				Long userId = Long.parseLong(request.getHeader("userid"));
				return userId;
	}
	
	private List<RezervacijaFullDTO> sortiraneRezervacijeFull(List<RezervacijaFullDTO> lista) { //ista metoda kao sortirane rezervacije, samo tip promenjen
		LinkedHashMap<RezervacijaFullDTO, LocalDateTime> nesortirane=new LinkedHashMap<RezervacijaFullDTO, LocalDateTime>();
		for(RezervacijaFullDTO dto : lista) {
			List<LocalDateTime> doDatumi=narServ.getAllByRezNar(dto.getId()).stream()
												.map(x->x.getDoDatuma())
												.sorted() //nadam se da vraca od najranijeg ka najkasnijem datumu
												.collect(Collectors.toList());
			nesortirane.put(dto, doDatumi.get(doDatumi.size()-1));
		}
		LinkedHashMap<RezervacijaFullDTO, LocalDateTime> sortirane=new LinkedHashMap<RezervacijaFullDTO, LocalDateTime>();
		
		nesortirane.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.forEachOrdered(x->sortirane.put(x.getKey(), x.getValue()));
		System.out.println("Sortirane rezervacije :"+ sortirane);
		return  new ArrayList<RezervacijaFullDTO>(sortirane.keySet());
	}
	
	private List<RezervacijaDTO> sortiraneRezervacije(List<RezervacijaDTO> rezervacije) {
		LinkedHashMap<RezervacijaDTO, LocalDateTime> nesortirane=new LinkedHashMap<RezervacijaDTO, LocalDateTime>();
		for(RezervacijaDTO dto : rezervacije) {
			List<LocalDateTime> doDatumi=narServ.getAllByRezNar(dto.getId()).stream()
												.map(x->x.getDoDatuma())
												.sorted() //nadam se da vraca od najranijeg ka najkasnijem datumu, prva koja istice je bi trebal biti na vrhu
												.collect(Collectors.toList());
			nesortirane.put(dto, doDatumi.get(doDatumi.size()-1));
		}
		LinkedHashMap<RezervacijaDTO, LocalDateTime> sortirane=new LinkedHashMap<RezervacijaDTO, LocalDateTime>();
		
		nesortirane.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.forEachOrdered(x->sortirane.put(x.getKey(), x.getValue()));
		System.out.println("Sortirane rezervacije :"+ sortirane);
		return  new ArrayList<RezervacijaDTO>(sortirane.keySet());
	}
	
	public LocalDateTime getKrajRezervacije(Long id) {
		List<LocalDateTime> krajnjiDatumi=narServ.getAllByRezOg(id).stream().map(x->x.getDoDatuma()).sorted().collect(Collectors.toList());
		return krajnjiDatumi.get(krajnjiDatumi.size()-1);
	}
	public LocalDateTime getPocetakRezervacije(Long id) {
		List<LocalDateTime> krajnjiDatumi=narServ.getAllByRezOg(id).stream().map(x->x.getDoDatuma()).sorted().collect(Collectors.toList());
		return krajnjiDatumi.get(krajnjiDatumi.size()-1);
	}
	
	@Autowired
	private NarudzbenicaRepository narudzbenicaRepository;
	public void otkaziOstale(Rezervacija savedRezervcaija, Narudzbenica narudzbenica ) {
		//nadji sve narudzbenice koje nisu iz ove rezervacije, a odnose se na oglas za koji je vezana ova narudzbenica
		List<Narudzbenica> ostaleNarudzbeniceUBazi=narudzbenicaRepository.findAll().stream()
																		.filter(x->x.getRezervacijaId()!=narudzbenica.getRezervacijaId() && x.getOglasId()==narudzbenica.getOglasId()) 
																		.collect(Collectors.toList());
		for(Narudzbenica n : ostaleNarudzbeniceUBazi) {
			//nema preklapanja ako se jenda zavrsava pre nego sto druga pocne ili jedna pocinje nakon sto se druga zavrsi
			boolean nemaPreklapanja= n.getDoDatuma().isBefore(narudzbenica.getOdDatuma()) || n.getOdDatuma().isAfter(narudzbenica.getDoDatuma());
			if(!nemaPreklapanja) {
				Rezervacija r=rezervacijaRepository.findById(n.getRezervacijaId()).orElse(null);
				//ovo je rezervacija iz baze koja se preklapa sa rezervacijom koju smo napravili
			}
		}
	}

}
