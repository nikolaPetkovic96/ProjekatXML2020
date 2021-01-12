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
/***********************GET *****************************************************/	
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
	/***********************GET *****************************************************/		
	
/*********************UPDATE STATUS ****************************************/	
	public RezervacijaDTO prihvatiRezervaciju(Long id) {
		Rezervacija r=rezervacijaRepository.getOne(id);
		
		CommonData data=commonDataRepository.getOne(r.getCommonDataId());
		data.setDatumIzmene(LocalDateTime.now());
		commonDataRepository.saveAndFlush(data);
		
		r.setStatusRezervacije("RESERVED");
		rezervacijaRepository.saveAndFlush(r);
		
		return rezMappper.toDTO(r);		
	}
	public RezervacijaDTO otkaziRezervaciju(Long id) {
		Rezervacija r=rezervacijaRepository.getOne(id);
		r.setStatusRezervacije("CANCELED");
		rezervacijaRepository.saveAndFlush(r);
		return rezMappper.toDTO(r);		
	}
	public RezervacijaDTO platiRezervaciju(Long id) {
		Rezervacija r=rezervacijaRepository.getOne(id);
		r.setStatusRezervacije("PAID");
		rezervacijaRepository.saveAndFlush(r);
		return rezMappper.toDTO(r);		
	}
	
	public RezervacijaStatusDTO updateStatus(RezervacijaStatusDTO dto) throws Exception {
		Rezervacija r=rezervacijaRepository.findById(dto.getRezervacijaId()).orElse(null);
		CommonData cmd=commonDataRepository.findById(r.getCommonDataId()).orElse(null);
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(), cmd);
		r.setCommonDataId(cmd.getId());
		r.setStatusRezervacije(dto.getStatusRezervacije());
		r=rezervacijaRepository.save(r);
		
		return new RezervacijaStatusDTO(r.getId(), r.getStatusRezervacije());
	}
/*********************************************************************************/	
	
	public List<RezervacijaDTO> getAllStatus(String status) {
		return rezervacijaRepository.findAll().stream().
									filter(r->r.getStatusRezervacije().equals(status)).
									map(x->rezMappper.toDTO(x)).collect(Collectors.toList());
	}
	public List<RezervacijaDTO> getAllStatusUser(String username,String status) {
		List<RezervacijaDTO> rezervacije=	rezervacijaRepository.findAll().stream().
											filter(r->r.getStatusRezervacije().equals(status)).
											map(x->rezMappper.toDTO(x)).
											collect(Collectors.toList());
		return sortiraneRezervacije(rezervacije);
	}
	
/*************************DODAVANJE NOVE*********************************************/	
	public RezervacijaNewDTO createRezervacija(RezervacijaNewDTO dto, String username) throws Exception {
		
//		CommonData commonData = new CommonData();
//		commonData.setId(dto.getCommonDataId());
//		commonData.setDatumKreiranja(LocalDateTime.now());
//		commonData.setDatumIzmene(LocalDateTime.now());
//		commonData.setUserId(user.getId());
//		commonData=cmdServ.addCommonData(commonData);
//		
//		Rezervacija novaRez=new Rezervacija();
//		novaRez.setCommonDataId(commonData.getId());
//		novaRez.setBundle(dto.getBundle());
//		novaRez.setNapomena(dto.getNapomenaRezervacije());
//		novaRez.setStatusRezervacije(dto.getStatusRezervacije()); //defaultStatus?
//		novaRez.setUkupnaCena(dto.getUkupnaCena());
//		List<NarudzbenicaNewDTO> kreirane=Collections.emptyList();
//		for(NarudzbenicaNewDTO nDTO : dto.getNarudzbenica()) {
//			Oglas o=oglasRep.findById(nDTO.getId()).orElse(null);
//			CommonData oglasCMD=commonDataRepository.findById(o.getCommonDataId()).orElse(null);
//			Long agentId=oglasCMD.getUserid();
//			Narudzbenica novaNar=new Narudzbenica(	null, agentId, user.getId(), nDTO.getOglasId(), nDTO.getRezervacijaId(), 
//													nDTO.getOdDatuma(), nDTO.getOdDatuma(), null, null);
//			CommonData narCmd=new CommonData();
//			narCmd.setDatumKreiranja(LocalDateTime.now());
//			narCmd.setDatumIzmene(LocalDateTime.now());
//			narCmd.setUserId(user.getId());
//			narCmd=cmdServ.addCommonData(narCmd);
//			novaNar.setCommonDataId(narCmd.getId());
//			novaNar=narServ.add(novaNar);
//			kreirane.add(new NarudzbenicaNewDTO(novaNar));
//		}
//		return new RezervacijaNewDTO(novaRez, kreirane);
		return null;
	}
	//public List<RezervacijaDTO> createRezervacija(RezervacijaDTO rezDTO) {	//ako je bundle true kreira se jedan zahtev, za bundle==false kreira se posebna rezervacija za svaki oglas
//	
//	List<RezervacijaDTO> rezervacije=new ArrayList<>();
//
//	Set<Long> vlasnici_id=Collections.emptySet();
//	for(Long id:rezDTO.getOglasi_id()) {
//		vlasnici_id.add(commonDataRepository.findById(oglasRep.findById(id).get().getCommonDataId()).get().getUserid());
//	}
//	for(Long vlas_id : vlasnici_id) {
//		List<Long> oglasi_od_vlasnika=Collections.emptyList();
//		for(Long oglas_id : rezDTO.getOglasi_id()) {
//			if(vlas_id==commonDataRepository.findById(oglasRep.findById(oglas_id).get().getCommonDataId()).get().getUserid())
//					oglasi_od_vlasnika.add(oglas_id);	//oglas pripada vlasniku, dodati ga u listu
//		}
//		RezervacijaDTO temp=rezDTO;	//temp uvek isti, samo ce se menjati lista oglasa zavisno od toga da li je bundle
//		if(rezDTO.getBundle()) {
//			temp.setOglasi_id(oglasi_od_vlasnika);
//			Rezervacija r=rezMappper.fromDTO(temp);
//			rezervacijaRepository.saveAndFlush(r);
//			rezervacije.add(rezMappper.toDTO(r));
//		}else {
//			for(Long oglas_od_vlasnika : oglasi_od_vlasnika) {
//				List<Long> pojedinacni_oglas=Collections.emptyList();
//				pojedinacni_oglas.add(oglas_od_vlasnika);
//				temp.setOglasi_id(pojedinacni_oglas);
//				temp.setOglasi_id(oglasi_od_vlasnika);
//				Rezervacija r=rezMappper.fromDTO(temp);
//				rezervacijaRepository.saveAndFlush(r);
//				rezervacije.add(rezMappper.toDTO(r));
//			}
//		}
//				
//	}
//
//	return rezervacije;
//}
	/********************************************************************************************************/	

/*******************************GETALL ADMIN*********************************************************/
//	public List<RezervacijaDTO> getAll() {
//		return rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTO(x)).collect(Collectors.toList());
//	}
	public List<RezervacijaFullDTO> getAllRezervacijeFull() {
		List<RezervacijaFullDTO> lista = rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTOFull(x)).collect(Collectors.toList());
		lista=sortiraneRezervacijeFull(lista);
		return lista;
	}
	
//	public List<RezervacijaFullDTO> getAllFull() {
//		return rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTOFull(x)).collect(Collectors.toList());
//	}
	
	public List<RezervacijaDTO> getAllRezervacije(){//ok
		List<RezervacijaDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTO(r)));
		return allDTO;
	}
/********************************************************************************************************/

/******************************************************************GETALL AGENT **********************/
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
	public List<RezervacijaFullDTO> getAllRezervacijeAgentFullDTO(String name) {	//konvertuje rezervacije trenuto ulogovano agenta u FullDTO
		return sortiraneRezervacijeFull(getAllRezervacijeAgent(name).stream().map(r->rezMappper.toDTOFull(r)).collect(Collectors.toList()));
	}
	public List<RezervacijaDTO> getAllRezervacijeAgentDTO(String name) {	//konvertuje rezervacije trenuto ulogovano agenta u DTO
		return sortiraneRezervacije(getAllRezervacijeAgent(name).stream().map(r->rezMappper.toDTO(r)).collect(Collectors.toList()));
	}
/********************************************************************************************************/
/******************************************************************GETALL USER **********************/
	public List<RezervacijaFullDTO> getAllRezervacijeUserFull(String name) {
		// TODO Auto-generated method stub
		return sortiraneRezervacijeFull(getAllRezervacijeUser(name).stream().map(r->rezMappper.toDTOFull(r)).collect(Collectors.toList()));
	}
	public List<RezervacijaDTO> getAllRezervacijeUserDTO(String name) {
		// TODO Auto-generated method stub
		return sortiraneRezervacije(getAllRezervacijeUser(name).stream().map(r->rezMappper.toDTO(r)).collect(Collectors.toList()));
	}
	public List<Rezervacija> getAllRezervacijeUser(String username){//ok
		List<Rezervacija> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll();
		allDTO.removeIf(r-> !r.getUsername().equals(username));
		return allDTO;
	}
/********************************************************************************************************/
/******************************************************************POMOCNE METODE **********************/
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
/********************************************************************************************************/

	
}

