package com.example.Reservation.repository.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reservation.dto.RezervacijaDTO;
import com.example.Reservation.model.CommonData;
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
	private NarudzbenicaRepository narRep;
	
	public  RezervacijaDTO getRezervacija(Long rezervacija_id) {	
		return rezMappper.toDTO(rezervacijaRepository.getOne(rezervacija_id));
	}
	public List<RezervacijaDTO> getAllRezervacijeUser(String username){
		List<RezervacijaDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTO(r)));
		allDTO.removeIf(r-> !r.getUsername().equals(username));
		return allDTO;
	}
	public List<RezervacijaDTO> getAllRezervacijeOglas(Long oglas_id){
		List<RezervacijaDTO> allDTO=new ArrayList<>();
		rezervacijaRepository.findAll().stream().forEach(r->allDTO.add(rezMappper.toDTO(r)));
		//allDTO.removeIf(r-> !r.getOglasi_id().contains(oglas_id));
		return allDTO;
	}
	
	public List<RezervacijaDTO> createRezervacija(RezervacijaDTO rezDTO) {	//ako je bundle true kreira se jedan zahtev, za bundle==false kreira se posebna rezervacija za svaki oglas
		
		List<RezervacijaDTO> rezervacije=new ArrayList<>();

		Set<Long> vlasnici_id=Collections.emptySet();
		for(Long id:rezDTO.getNarudzbenice_id()) {
			vlasnici_id.add(commonDataRepository.findById(narRep.findById(id).get().getIzvestaj().getCommonDataId()).get().getUserid());
		}
		for(Long vlas_id : vlasnici_id) {
			List<Long> narudzbenice_od_vlasnika=Collections.emptyList();
			for(Long oglas_id : rezDTO.getNarudzbenice_id()) {
				if(vlas_id==commonDataRepository.findById(narRep.findById(oglas_id).get().getIzvestaj().getCommonDataId()).get().getUserid())
						narudzbenice_od_vlasnika.add(oglas_id);	//oglas pripada vlasniku, dodati ga u listu
			}
			RezervacijaDTO temp=rezDTO;	//temp uvek isti, samo ce se menjati lista oglasa zavisno od toga da li je bundle
			if(rezDTO.getBundle()) {
				temp.setNarudzbenice_id(narudzbenice_od_vlasnika);
				Rezervacija r=rezMappper.fromDTO(temp);
				rezervacijaRepository.saveAndFlush(r);
				rezervacije.add(rezMappper.toDTO(r));
			}else {
				for(Long narudzbenica_od_vlasnika : narudzbenice_od_vlasnika) {
					List<Long> pojedinacni_oglas=Collections.emptyList();
					pojedinacni_oglas.add(narudzbenica_od_vlasnika);
					temp.setNarudzbenice_id(pojedinacni_oglas);
					temp.setNarudzbenice_id(narudzbenice_od_vlasnika);
					Rezervacija r=rezMappper.fromDTO(temp);
					rezervacijaRepository.saveAndFlush(r);
					rezervacije.add(rezMappper.toDTO(r));
				}
			}
					
		}
		//
	/*	List<RezervacijaDTO> rezervacije=new ArrayList<>();
		if(rezDTO.getBundle()==true) {
		Rezervacija r=rezMappper.fromDTO(rezDTO);
		rezervacijaRepository.saveAndFlush(r);
		rezervacije.add(rezMappper.toDTO(r));
		}else {	//nije bundle, kreiraj posebnu rezervaciju za svaki oglas
			for(Long oglas_id : rezDTO.getOglasi_id()) {
				RezervacijaDTO novaDTO=rezDTO;
				List<Long> oglasi=new ArrayList<>();
				oglasi.add(oglas_id);
				novaDTO.setOglasi_id(oglasi);
				Rezervacija r=rezMappper.fromDTO(novaDTO);
				rezervacijaRepository.saveAndFlush(r);
				rezervacije.add(rezMappper.toDTO(r));				
			}
		}*/
		return rezervacije;
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
	
	
	/*public List< Rezervacija> getAllRezervacija(){
		List< Rezervacija>  rezervacijaKlinCentra = new ArrayList<>();
			rezervacijaRepository.findAll().forEach(rezervacijaKlinCentra::add);
			return rezervacijaKlinCentra;
		}

		public Rezervacija findOne(Long id) {
			return rezervacijaRepository.findById(id).orElseGet(null);
		}
		
		public Rezervacija addRezervacija(Rezervacija rezervacija)throws Exception{
			  if (rezervacija.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Rezervacija savedRezervacijaKlinCentra = rezervacijaRepository.save(rezervacija);
		        return savedRezervacijaKlinCentra;
			
		}
		
		public Rezervacija updateRezervacija(Long id, Rezervacija rezervacija) throws Exception {
			Optional<Rezervacija> rezervacijaKlinCentraToUpadet = rezervacijaRepository.findById(id);
			if (rezervacijaKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Rezervacija updateRezervacijaKilCentra = rezervacijaRepository.save(rezervacija);
			return updateRezervacijaKilCentra;
		}
		
		public void deleteRezervacija(Long id) {
			rezervacijaRepository.deleteById(id);
		}*/
}
