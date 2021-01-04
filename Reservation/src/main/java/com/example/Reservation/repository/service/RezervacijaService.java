package com.example.Reservation.repository.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.NarudzbenicaNewDTO;
import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.dto.RezervacijaFullDTO;
import com.example.Reservation.dto.RezervacijaNewDTO;
import com.example.Reservation.dto.RezervacijaStatusDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.model.TUser;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.RezervacijaRepository;
import com.example.Reservation.repository.TUserRepository;
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
	private TUserService userServ;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NarudzbenicaService narServ;
	
	public  RezervacijaDTO getRezervacija(Long rezervacija_id) {	
		return rezMappper.toDTO(rezervacijaRepository.getOne(rezervacija_id));
	}
	public List<RezervacijaFullDTO> getAllRezervacijeUser(String username){//ok
		List<RezervacijaFullDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTOFull(r)));
		allDTO.removeIf(r-> !r.getUsername().equals(username));
		return allDTO;
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
	///////////////////////////
	public List<RezervacijaDTO> getAll() {
		return rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTO(x)).collect(Collectors.toList());
	}
	public List<RezervacijaFullDTO> getAllFull() {
		return rezervacijaRepository.findAll().stream().map(x->rezMappper.toDTOFull(x)).collect(Collectors.toList());
	}
	public List<RezervacijaDTO> getAllStatus(String status) {
		return rezervacijaRepository.findAll().stream().
									filter(r->r.getStatusRezervacije().equals(status)).
									map(x->rezMappper.toDTO(x)).collect(Collectors.toList());
	}
	public List<RezervacijaDTO> getAllStatusUser(String username,String status) {
		List<RezervacijaDTO> rezervacije=	rezervacijaRepository.findAll().stream().
											filter(r->r.getStatusRezervacije().equals(status)).
											map(x->rezMappper.toDTO(x)).
											filter(r->r.getStatusRezervacije().equals(status)).
											collect(Collectors.toList());
		return  rezervacije;
	}
	public RezervacijaFullDTO getRezervacijaFull(Long id) {
		Rezervacija r=rezervacijaRepository.findById(id).orElseGet(null);
		return rezMappper.toDTOFull(r);
	}
	public RezervacijaNewDTO createRezervacija(RezervacijaNewDTO dto, String username) throws Exception {
		TUser user=userServ.findByUsername(username);
		
		CommonData commonData = new CommonData();
		commonData.setId(dto.getCommonDataId());
		commonData.setDatumKreiranja(LocalDateTime.now());
		commonData.setDatumIzmene(LocalDateTime.now());
		commonData.setUserId(user.getId());
		commonData=cmdServ.addCommonData(commonData);
		
		Rezervacija novaRez=new Rezervacija();
		novaRez.setCommonDataId(commonData.getId());
		novaRez.setBundle(dto.getBundle());
		novaRez.setNapomena(dto.getNapomenaRezervacije());
		novaRez.setStatusRezervacije(dto.getStatusRezervacije()); //defaultStatus?
		novaRez.setUkupnaCena(dto.getUkupnaCena());
		List<NarudzbenicaNewDTO> kreirane=Collections.emptyList();
		for(NarudzbenicaNewDTO nDTO : dto.getNarudzbenica()) {
			Oglas o=oglasRep.findById(nDTO.getId()).orElse(null);
			CommonData oglasCMD=commonDataRepository.findById(o.getCommonDataId()).orElse(null);
			Long agentId=oglasCMD.getUserid();
			Narudzbenica novaNar=new Narudzbenica(	null, agentId, user.getId(), nDTO.getOglasId(), nDTO.getRezervacijaId(), 
													nDTO.getOdDatuma(), nDTO.getOdDatuma(), null, null);
			CommonData narCmd=new CommonData();
			narCmd.setDatumKreiranja(LocalDateTime.now());
			narCmd.setDatumIzmene(LocalDateTime.now());
			narCmd.setUserId(user.getId());
			narCmd=cmdServ.addCommonData(narCmd);
			novaNar.setCommonDataId(narCmd.getId());
			novaNar=narServ.add(novaNar);
			kreirane.add(new NarudzbenicaNewDTO(novaNar));
		}
		return new RezervacijaNewDTO(novaRez, kreirane);
	}
	public Rezervacija addRezervacija(Rezervacija r) throws Exception {
		if(r.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Rezervacija saved=rezervacijaRepository.save(r);
		return saved;
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
	
	
//public List<RezervacijaDTO> createRezervacija(RezervacijaDTO rezDTO) {	//ako je bundle true kreira se jedan zahtev, za bundle==false kreira se posebna rezervacija za svaki oglas
//		
//		List<RezervacijaDTO> rezervacije=new ArrayList<>();
//
//		Set<Long> vlasnici_id=Collections.emptySet();
//		for(Long id:rezDTO.getOglasi_id()) {
//			vlasnici_id.add(commonDataRepository.findById(oglasRep.findById(id).get().getCommonDataId()).get().getUserid());
//		}
//		for(Long vlas_id : vlasnici_id) {
//			List<Long> oglasi_od_vlasnika=Collections.emptyList();
//			for(Long oglas_id : rezDTO.getOglasi_id()) {
//				if(vlas_id==commonDataRepository.findById(oglasRep.findById(oglas_id).get().getCommonDataId()).get().getUserid())
//						oglasi_od_vlasnika.add(oglas_id);	//oglas pripada vlasniku, dodati ga u listu
//			}
//			RezervacijaDTO temp=rezDTO;	//temp uvek isti, samo ce se menjati lista oglasa zavisno od toga da li je bundle
//			if(rezDTO.getBundle()) {
//				temp.setOglasi_id(oglasi_od_vlasnika);
//				Rezervacija r=rezMappper.fromDTO(temp);
//				rezervacijaRepository.saveAndFlush(r);
//				rezervacije.add(rezMappper.toDTO(r));
//			}else {
//				for(Long oglas_od_vlasnika : oglasi_od_vlasnika) {
//					List<Long> pojedinacni_oglas=Collections.emptyList();
//					pojedinacni_oglas.add(oglas_od_vlasnika);
//					temp.setOglasi_id(pojedinacni_oglas);
//					temp.setOglasi_id(oglasi_od_vlasnika);
//					Rezervacija r=rezMappper.fromDTO(temp);
//					rezervacijaRepository.saveAndFlush(r);
//					rezervacije.add(rezMappper.toDTO(r));
//				}
//			}
//					
//		}
//
//		return rezervacije;
//	}
}

