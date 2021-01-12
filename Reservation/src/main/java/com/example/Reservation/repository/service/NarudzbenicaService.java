package com.example.Reservation.repository.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reservation.dto.NarudzbenicaDTO;
import com.example.Reservation.dto.NarudzbenicaNewDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Narudzbenica;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.NarudzbenicaRepository;
import com.example.Reservation.repository.OglasRepository;
import com.example.Reservation.repository.service.mapper.NaruzbenicaMapper;


@Service
public class NarudzbenicaService {
	@Autowired
	private NarudzbenicaRepository narRep;
	@Autowired
	private NaruzbenicaMapper narMap;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired 
	private CommonDataRepository cmdRep;
	@Autowired
	private OglasRepository oglasRep;
	
	public List<NarudzbenicaDTO> getAll() {
		List<NarudzbenicaDTO> lista=narRep.findAll().stream().map(x->narMap.toDTO(x)).collect(Collectors.toList());
		return lista;
	}
	public List<NarudzbenicaDTO> getAllByRez(Long rez_id) {
		List<NarudzbenicaDTO> lista=narRep.findAll().stream().filter(x->x.getRezervacijaId().equals(rez_id)).map(x->narMap.toDTO(x)).collect(Collectors.toList());
		return lista;
	}
	public List<Narudzbenica> getAllByRezNar(Long rez_id) {
		List<Narudzbenica> lista=narRep.findAll().stream().filter(x->x.getRezervacijaId().equals(rez_id)).collect(Collectors.toList());
		return lista;	
	}
	public List<Narudzbenica> getAllForAgent(Long agentId) {
		List<Narudzbenica> lista=narRep.findAll().stream().filter(x->x.getAgentId().equals(agentId)).collect(Collectors.toList());
		return lista;	
	}
	public List<Narudzbenica> getAllForUser(Long userId) {
		List<Narudzbenica> lista=narRep.findAll().stream().filter(x->x.getUserId().equals(userId)).collect(Collectors.toList());
		return lista;	
	}


	public Narudzbenica add(Narudzbenica novaNar) throws Exception {
		if(novaNar.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		Narudzbenica saved=narRep.save(novaNar);
		return saved;
	}
	
	public void delete(Long id) {
		 Narudzbenica n=narRep.findById(id).orElse(null);
		 CommonData cmd=cmdRep.findById(n.getCommonDataId()).orElse(null);
		 if(n!=null && cmd!=null) {
			 narRep.deleteById(id);
			 cmdServ.deleteCommonData(cmd.getId());
		 }
		 
	}
	public NarudzbenicaNewDTO updateNar(NarudzbenicaNewDTO dto) throws Exception {
		Narudzbenica n=narRep.findById(dto.getId()).orElse(null);
		CommonData cmd=cmdRep.getOne(dto.getCommonDataId());

		if(n==null || cmd==null)
			return null;
		
		cmd.setDatumIzmene(LocalDateTime.now());
		cmd=cmdServ.updateCommonData(cmd.getId(), cmd);
		
		n.setAgentId(dto.getAgentId());
		n.setCommonDataId(cmd.getId());
		n.setId(dto.getId());
		n.setOdDatuma(dto.getDoDatuma());
		n.setDoDatuma(dto.getDoDatuma());
		n.setRezervacijaId(dto.getRezervacijaId());
		n.setOglasId(dto.getOglasId());
		n.setUserId(dto.getUserId());
		n=narRep.save(n);
		
		return new NarudzbenicaNewDTO(n);		
	}
	public NarudzbenicaDTO get(Long id) {
		Narudzbenica n=narRep.findById(id).orElse(null);
		Oglas o=oglasRep.findById(n.getOglasId()).orElse(null);
		return null;
	}
	public List<Narudzbenica> getAllByOglas(Long id) {
		List<Narudzbenica> lista=narRep.findAll().stream().filter(x->x.getOglasId().equals(id)).collect(Collectors.toList());
		return lista;
	}
}