package com.example.Oglas.service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.Oglas.dto.OglasDTO;
import com.example.Oglas.dto.OglasDetailsImgDTO;
import com.example.Oglas.dto.OglasNewDTO;
import com.example.Oglas.model.Automobil;
import com.example.Oglas.model.Cenovnik;
import com.example.Oglas.model.CommonData;
import com.example.Oglas.model.Narudzbenica;
import com.example.Oglas.model.Oglas;
import com.example.Oglas.model.TAdresa;
import com.example.Oglas.repository.AutomobilRepository;
import com.example.Oglas.repository.CenovnikRepository;
import com.example.Oglas.repository.CommonDataRepository;
import com.example.Oglas.repository.OglasRepository;
import com.example.Oglas.service.mapper.OglasMapper;

@Service
public class OglasService {
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired 
	private OglasMapper oglasMapper;
	@Autowired
	private OglasRepository oglasRep;
//	@Autowired
//	private UserService userServ;
	@Autowired
	private TAdresaService adrServ;
	@Autowired
	private CommonDataService cmdServ;
	@Autowired
	private NarudzbenicaService narServ;
	@Autowired
	private AutomobilRepository autoRep;
	@Autowired
	private CenovnikRepository cenRep;
	//GET ALL
	public List<OglasDTO> getAll() {
		List<Oglas> pom = oglasRep.findAll();
		List<OglasDTO> retDTO = new ArrayList<>();
		for(Oglas p:pom) {
			if(p.getDoDatuma().isAfter(LocalDateTime.now()))
			{
			retDTO.add(oglasMapper.toDTO(p));
			}
		}
		return retDTO;
	}
	
	//GET ONE
	public OglasDTO getOglas(Long id) {
		return oglasRep.findById(id).map(oglas-> oglasMapper.toDTO(oglas)).orElse(null);
	}
	
	
	//GET ALL USERS
	public List<OglasDTO> getOglaseForUser() {
		//Ovako se izvalaci id usera iz zahteva
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		List<Oglas> pom = oglasRep.findAll();
		List<OglasDTO> retDTO = new ArrayList<>();
		for(Oglas p:pom) {
			CommonData comData = cmdServ.findOne(p.getCommonDataId());
			if(comData.getUserId() == userId) {
				retDTO.add(oglasMapper.toDTO(p));
			}
		}
		return retDTO;
		
	}
	
	public ResponseEntity<String> deleteOglas(Long id) {
		Oglas o=oglasRep.findById(id).orElse(null);
		if(o!=null) {
			List<HashMap<String, LocalDateTime>> imaZauzetihTermina = getZauzetiTermini(narServ.getAllByOglas(o.getId()));
			//Ako nema rezervacija vezanih za sebe
			if(imaZauzetihTermina.size() == 0){
				TAdresa adresa =  adrServ.findById(o.getAdresaId());
				//obrise se adresa vezana za oglas
				adrServ.deleteAdresa(adresa.getId());
				//obrise se i commonData te adrese
//				cmdServ.deleteCommonData(adresa.getCommonDataId());
				
				//obrise se sam oglas
				oglasRep.deleteById(id);
				//obrise se commonData tog oglasa
				cmdServ.deleteCommonData(o.getCommonDataId());
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				//Zbog ovog rucnog errora moramo imati return type Response entity;
				return  ResponseEntity
			            .status(HttpStatus.NOT_FOUND)
			            .body("There are reservations connected to this ad!");
			}

		} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
	}


	public OglasDTO getOglasDetails(Long id) {
		// TODO Auto-generated method stub
		//GETOVATI OGLAS KOJI SADRZI AUTOMOBIL SA SLIKAMA
		return null;
	}

	public ResponseEntity<?> addOglas(OglasNewDTO dto, String username) throws Exception {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		Long userId = Long.parseLong(request.getHeader("userid"));
		
		if(isIntervalSlobodan(userId, dto)==false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Za odabrani termin vec postoji oglas!");
		}
		
		CommonData cmd = new CommonData();
		cmd.setDatumKreiranja(LocalDateTime.now());
		cmd.setUserId(userId);
		cmd.setDatumIzmene(LocalDateTime.now());
		
		TAdresa adresa = adrServ.addAdresa(dto.getAdresa(),userId);
		
		Oglas novi=new Oglas();
		novi.setUsername(username);
		novi.setOdDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
		novi.setDoDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
		novi.setAutomobilId(dto.getAutomobilId());
		novi.setCenovnikId(dto.getCenovnikId());
		novi.setPlaniranaKm(dto.getPlaniranaKilometraza());
		novi.setAdresaId(adresa.getId());
		
		cmd=cmdServ.addCommonData(cmd);
		novi.setCommonDataId(cmd.getId());
		
		novi = oglasRep.save(novi);
	
		return new ResponseEntity<>(oglasMapper.toDTO(novi), HttpStatus.CREATED);
	}
	
	//Provera da li se novi oglas poklapa sa neki drugi vec kreiranim oglasom za interval i utomobil 
			//(za razlicite automobile mogu postojati oglasi u istom terminu)... 
			public boolean isIntervalSlobodan(Long agentId, OglasNewDTO dto){
				List<Oglas> oglas = oglasRep.findAll().stream().filter(x->cmdRep.getOne(x.getCommonDataId()).getUserId().equals(agentId)).collect(Collectors.toList());
				//Pocetak i kraj novog oglasa
				LocalDateTime odDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId());
				LocalDateTime doDatuma = LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId());
				//id automobila novo
				Long automobilId = dto.getAutomobilId();
				for(Oglas o:oglas) {
					//Ovo pokriva kada su oba intervala novog u intervalu starog ili je pocetak ili kraj novog u intervalu starog...
					//Pocetak novog je u intervalu postojeceg oglasa;
					if(odDatuma.isAfter(o.getOdDatuma()) && odDatuma.isBefore(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
						return false;
					}
					//Kraj novog je u intervalu postojeceg oglasa;
					else if(doDatuma.isAfter(o.getOdDatuma()) && doDatuma.isBefore(o.getDoDatuma()) && automobilId == o.getAutomobilId()) {
						return false;
					}
					//Stari interval je u intervalu novog oglasa; np|   sp|   |sk   |nk
					else if(odDatuma.isBefore(o.getOdDatuma()) && doDatuma.isAfter(o.getDoDatuma()) &&  automobilId == o.getAutomobilId()) {
						return false;
					}
				}
				return true;
	}
			
	//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
	public List<HashMap<String, LocalDateTime>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
		List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
		for (Narudzbenica n : narudzbenice) {
			
			HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
			hash_map.put("odDatuma", n.getOdDatuma());
			hash_map.put("doDatuma", n.getDoDatuma());
			System.out.println("Initial Mappings are: " + hash_map);
			zauzetiTermini.add(hash_map);
		}
		
		return zauzetiTermini;
	}
/***********PRETRAGA*******************/	
	public List<OglasDetailsImgDTO> pretragaOglasa(Long markaAutId, Long modelAutId,
			Long klasaAutId, Long tipMenjacaId, Long tipGorivaId,
			Integer brojSedZaDec, Boolean colDmgWaiv, Float kilometraza,
			Float cenaMin, Float cenaMax, LocalDateTime odDatum, LocalDateTime doDatum, String username) throws Exception {
		
		//Obrisati na kraju
    	System.out.println("od " +  odDatum);
    	System.out.println("do: " + doDatum);
    	System.out.println("min: " + cenaMin);
    	System.out.println("max: " + cenaMax);
    	System.out.println("markaAut " + markaAutId);
    	System.out.println("modelAut: " + modelAutId);
    	System.out.println("klasaAut: " + klasaAutId);
    	System.out.println("tipMenjaca: " + tipMenjacaId);
    	System.out.println("tipGoriva: " + tipGorivaId);
    	System.out.println("brojSedZaDec: " + brojSedZaDec);
		System.out.println("ColDmgWaiv: " + colDmgWaiv);
		System.out.println("kilometraza: " + kilometraza);
		
		
	
		List<Oglas> pom = oglasRep.findAll();	//pokupi sve oglase
		
		List<OglasDetailsImgDTO> retDTO = new ArrayList<>();
		
		for(Oglas o:pom) {	//proveri svaki pojedinacno oglas sa parametrima zahteva
			
			boolean slobodan=terminSlobodan(odDatum,doDatum,getZauzetiTermini(narServ.getAllByOglas(o.getId())),o.getOdDatuma(),o.getDoDatuma());
			//slobodan je false u slucaju da oglas nije slobodan u trazenom terminu, ili se uopste ne vrsi pretraga po datumima pa je false za oglase koji nisu trenutno aktuelni
			if(slobodan==false) continue; 
			//provera datuma
			//if(odDatum != null && odDatum.isAfter(o.getDoDatuma())) continue; //oglas_poc datum pre search_poc datuma 
			//if(odDatum != null && doDatum.isBefore(o.getOdDatuma()) ) continue;  //oglas_kraj datum posle search_poc datuma 
			
			//provera cenovnika
			Cenovnik c=cenRep.findById(o.getCenovnikId()).orElse(null);
			if(c == null) {
				throw new Exception ("pretragaOglasa: za oglas"+ o.getId()+" nije nadjen cenovnik!");
			}
			if(cenaMin!=null  && c.getCenaPoDanu()<cenaMin) continue;
			if(cenaMin!=null  && c.getCenaPoDanu()>cenaMax) continue;
			
			//provera automobila
			Automobil a=autoRep.findById(o.getAutomobilId()).orElse(null);
			if(a==null) {
				throw new Exception ("pretragaOglasa: za oglas"+ o.getId()+" nisu nadjena kola !");
			}
			
			//ako je markaId null predji na sledecu proveru, ako je nije null porveri da li je jednaka markiAutaId trenutnog oglasa
			//ako su jednake predji na sledecu proveru, ako nisu jednake obustavi proveru i predji na sledeci oglas
			if(markaAutId!=null && a.getMarkaAutomobilaId()!=markaAutId) continue;
			if(modelAutId != null && a.getModelAutomobilaId() != modelAutId) continue;
			if(klasaAutId != null && a.getKlasaAutomobilaId() != klasaAutId) continue;
			if(tipMenjacaId != null && a.getTipMenjacaId() != tipMenjacaId) continue;
			if(tipGorivaId != null && a.getVrstaGorivaId() != tipGorivaId) continue;
			if(brojSedZaDec != null && a.getBrojSedistaZaDecu() != brojSedZaDec) continue;
			if(colDmgWaiv != null && a.isCollisionDamageWaiver() != colDmgWaiv) continue;
			if(kilometraza != null && a.getPredjenaKilometraza() > kilometraza) continue; //<= trazimo
			
			retDTO.add(oglasMapper.toImgDTO(o,a,c));				
		}
			return retDTO;
	}
	
	
	private boolean terminSlobodan(LocalDateTime odPretraga, LocalDateTime doPretraga,
			List<HashMap<String, LocalDateTime>> zauzetiTermini, LocalDateTime odOglas, LocalDateTime doOglas) {
		//uslova da termin bude slobodan = da datum/nterval pretrage bude unutar intervala oglasa, ali da se ne preklapa sa terminima koji su vezani za taj oglas
		
		if(odPretraga==null && doPretraga==null) { //nisu unete vredosti datuma za pretragu, proveri da li je oglas trenutno aktuelan
			LocalDateTime sadasnjost=LocalDateTime.now();	//izbacice oglase koji nisu trenutno aktuelni
			return danUnutarIntervala(sadasnjost, odOglas, doOglas);	
		
		}
		else if(odPretraga!=null && doPretraga==null) {	//unet samo pocetni datum za pretragu
			if(!danUnutarIntervala(odPretraga,odOglas,doOglas)) { //ako se pocetni datum pretrage ne nalazi unutar perioda u kojem je oglas aktuelan vrati false	
				return false;									//ako je aktuelan vrsi se provera nad svim terminima oglasa
			}
			for(HashMap<String, LocalDateTime> termin : zauzetiTermini) {	//uporediti sa svim terminima
				if(danUnutarIntervala(odPretraga, termin.get("od"),  termin.get("do"))) {//ako je dan u pretrazi unutar intervala termina => ima preklopa sa vec zauzetim termino vrati false
					return false;
				}
			}
		}	
		else if(doPretraga!=null && odOglas==null)  {	//unet samo krajnji datum za pretragu
			if(!danUnutarIntervala(odPretraga,odOglas,doOglas)) {	//oglas mora biti aktuelan u periodu za koji je unet krajnji datum, ako nije vrati false
				return false;										//ako je aktuelan vrsi se provera nad svim terminima
			}
			for(HashMap<String, LocalDateTime> termin : zauzetiTermini) {//uporediti sa svim terminima
				if(danUnutarIntervala(doPretraga, termin.get("od"),  termin.get("do"))) {	//da li je uneti datum za kraj unutar termina
					//ako jeste znaci da ima preklopa sa vec zauzetim terminom, vraca se false, ne gleda se dalje
					return false;
				}
			}
		}
		else {	//situacija u kojoj su uneti i pocetni i kranjji datum za pretragu
			if(odOglas.isBefore(odPretraga) && doOglas.isAfter(doPretraga)) {
				//interval od-do pretrage mora biti unutar intervala od-do oglasa, ako je tacno uporediti sa svakim terminom, ne sme biti preklapanja
				for(HashMap<String, LocalDateTime> termin : zauzetiTermini) {
					boolean nemaPreklapanja=doPretraga.isBefore(termin.get("od")) || odPretraga.isAfter(termin.get("do"));
					//opcije da nema preklapanja: 1. kraj pretraga je pre pocetka vec zauzetog termina, ili
												//2. pocetak pretrage je posle zavrsetka termina.
					if(nemaPreklapanja==false)	
						return false;//ima preklapanja, vrati false
				}
			}else return false;	//interval od-do pretrage NIJE UNUTAR intervala od-do oglasa,
		}
		return true;	//prosao sve provere, oglas je slobodan za navedeni termin
	}
	
	private boolean danUnutarIntervala(LocalDateTime dan, LocalDateTime pocetak, LocalDateTime kraj) {//da li je locadateTime unutar termina
		//dan mora biti posle pocetka ali i pre kraja da bi bio unutar intervala
		return dan.isAfter(pocetak) &&  dan.isBefore(kraj);
	} 
/*******************************************************KRAJ METODA ZA PRETRAGU***********************************************************************/
	public List<OglasDetailsImgDTO> getAllWithImages() throws Exception {
		List<Oglas> pom = oglasRep.findAll();				//pokupi sve oglase
		List<OglasDetailsImgDTO> retDTO = new ArrayList<>();
		for(Oglas o:pom) {	//proveri svaki pojedinacno oglas sa parametrima zahteva
			Cenovnik c=cenRep.findById(o.getCenovnikId()).orElse(null);
			if(c==null) {
				throw new Exception ("pretragaOglasa: za oglas"+ o.getId()+" nije nadjen cenovnik!");
			}
			//provera automobila
			Automobil a=autoRep.findById(o.getAutomobilId()).orElse(null);
			if(a==null) {
				throw new Exception ("pretragaOglasa: za oglas"+ o.getId()+" nisu nadjena kola !");
			}
			
			retDTO.add(oglasMapper.toImgDTO(o,a,c));				
		}
			return retDTO;
	}
}	

