package com.example.Reservation.repository.service.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Reservation.dto.PorukaDTO;
import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Oglas;
import com.example.Reservation.model.Poruka;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.service.CommonDataService;
import com.example.Reservation.repository.service.OglasService;
import com.example.Reservation.repository.service.RezervacijaService;

@Component
public class PorukaMapper {

	@Autowired
	private CommonDataRepository commonDataRepository;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private RezervacijaService rezServ;
	@Autowired
	private CommonDataMapper cmdMapper;
	@Autowired
	private OglasService oglasServ;
	
	public PorukaDTO toDTO(Poruka p)  {
		CommonData data = commonDataRepository.findById(p.getCommonDataId()).get();
		Rezervacija r=rezServ.FindRezervacija(p.getRezervacijaId());
		CommonData rCMD=cmdServ.findOne(r.getCommonDataId());
		List<Oglas> oglasiR=oglasServ.getAllRez(r.getId());
		
		String agentName=oglasiR.get(0).getUsername();	//username agenta
		String kupacName=r.getUsername();				//username kupca
		PorukaDTO pDTO=new PorukaDTO();
		if(data.getUserId()==rCMD.getUserId()) { //da li je userId poruke jednak userId od rezervacije
		//ako jeste username poruke postaje username od rezervacije
			pDTO=new PorukaDTO(p,kupacName,cmdMapper.toDTO(data));
		}else {		//ako userId poruke nije jednak userId rezervacaije sledi da je jednak userId od oglasa, tj agenta
			pDTO=new PorukaDTO(p,agentName,cmdMapper.toDTO(data));
		}
		return pDTO;		
	}
	
	public Poruka fromDTO(PorukaDTO dto) {
		CommonData data = dto.getCommonDataId()!=null ? commonDataRepository.findById(dto.getCommonDataId()).get():new CommonData();
		Poruka p=new Poruka();
		p.setRezervacijaId(dto.getRezervacijaId());
		p.setTekstPoruke(dto.getTekstPoruke());
		data.setDatumIzmene(LocalDateTime.now());
		commonDataRepository.save(data);
		commonDataRepository.flush();
		p.setCommonDataId(data.getId());
		return p;
	}
}
