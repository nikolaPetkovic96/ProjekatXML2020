package com.example.Reservation.repository.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Reservation.dto.IzvestajDTO;
import com.example.Reservation.model.Automobil;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Izvestaj;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.IzvestajRepository;
import com.example.Reservation.repository.service.impl.EmailService;
@Service
public class IzvestajService {

	@Autowired
	private IzvestajRepository izvRep;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private RezervacijaService rezServ;
	@Autowired
	private AutomobilService autoServ;
	
	@Autowired
	private EmailService emailService;
	
	public List<IzvestajDTO> getAll() {
		return izvRep.findAll().stream().map(x->new IzvestajDTO(x)).collect(Collectors.toList());
	}
	
	public IzvestajDTO getOne(Long id) throws Exception{
		Izvestaj i= izvRep.findById(id).orElse(null);
		if(i==null) {
			throw new Exception("IzvestajService: Nije pronajden izvestaj sa id :"+id);
		}
		return new IzvestajDTO(i);
	}
	public Izvestaj findOne(Long id) throws Exception{
		Izvestaj i= izvRep.findById(id).orElse(null);
		if(i==null) {
			throw new Exception("IzvestajService: Nije pronajden izvestaj sa id :"+id);
		}
		return i;
	}
	
	//pomocna metoda
	public Long getUserId() {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		
		Long userId = Long.parseLong(request.getHeader("userid"));
		return userId;
	}

	public ResponseEntity<?> addIzvestaj(IzvestajDTO dto, String name) throws Exception {
		Izvestaj savedIzvestaj = new Izvestaj();

		CommonData commonData = new CommonData();
		LocalDateTime now = LocalDateTime.now();
		commonData.setUserId(getUserId());
		commonData.setDatumKreiranja(now);
		commonData = cmdServ.addCommonData(commonData);
		
		savedIzvestaj.setId(null);
		savedIzvestaj.setNarudzbenicaId(dto.getNarudzbenicaId());
		savedIzvestaj.setAutomobilId(dto.getAutomobilId());
		savedIzvestaj.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		savedIzvestaj.setTekstIzvestaja(dto.getTekstIzvestaja());
		savedIzvestaj.setRezervacijaId(dto.getRezervacijaId());
		savedIzvestaj.setPrekoracenaKilometraza(dto.getPrekoracenaKilometraza());
		savedIzvestaj.setDodatniTroskovi(dto.getDodatniTroskovi());
		savedIzvestaj.setCommonDataId(commonData.getId());
		
		//da li vec postoji izvestaj u bazi za datu narudzbenicu
		List<Izvestaj> all=izvRep.findAll().stream()	
				.filter(x->x.getNarudzbenicaId()==savedIzvestaj.getNarudzbenicaId()).collect(Collectors.toList());
		if(all.size()>0) {//ako je ova lista veca od 0 znaci da u tabeli izvestaja vec postoji izvestaj sa narudzbenicom za koju je pokusano cuvanje 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Već postoji napravljen izveštaj za dati automobil!");
		}
		Izvestaj i=izvRep.save(savedIzvestaj);
		
		Rezervacija r=rezServ.FindRezervacija(i.getRezervacijaId());
		CommonData cmdRez=cmdServ.findOne(r.getCommonDataId());
		//User userWhoMadeReserv = userService.findOne(comData.getUserid());
		if(savedIzvestaj.getPrekoracenaKilometraza() > 0) {
			emailService.sendBillEmail(cmdRez.getUserId(), savedIzvestaj);
		}
		
		Automobil auto = autoServ.findOne(savedIzvestaj.getAutomobilId());
		auto.setPredjenaKilometraza(auto.getPredjenaKilometraza() + savedIzvestaj.getPredjenaKilometraza());
		autoServ.updateAutomobil(auto.getId(), auto);
		
		return new ResponseEntity<>(new IzvestajDTO(i), HttpStatus.CREATED);
	}

	//NE KORISTI SE 
	public IzvestajDTO updateIzvestaj(IzvestajDTO dto) throws Exception {
		Izvestaj i=findOne(dto.getId());
		CommonData cmd=cmdServ.findOne(dto.getCommonDataId());
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(), cmd);
		
		i.setId(dto.getId());
		i.setNarudzbenicaId(dto.getNarudzbenicaId());
		i.setPredjenaKilometraza(dto.getPredjenaKilometraza());
		i.setTekstIzvestaja(dto.getTekstIzvestaja());
		i.setCommonDataId(cmd.getId());
		
		//naredne 4 linije nisu u agent aplikaciji
//		i.setDodatniTroskovi(dto.getDodatniTroskovi());
//		i.setAutomobilId(dto.getAutomobilId());
//		i.setPrekoracenaKilometraza(dto.getPrekoracenaKilometraza());
//		i.setRezervacijaId(dto.getRezervacijaId());
		Izvestaj updated=izvRep.save(i);
		
		return new IzvestajDTO(updated);
	}
	
	//NE KORISTI SE 
	public Void deleteIzvestaj(Long id) throws Exception {
		Izvestaj i=findOne(id);
		izvRep.delete(i);
		cmdServ.deleteCommonData(i.getCommonDataId());
		return null;
	}
}
