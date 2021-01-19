package com.team32.AgentApp.controller;
import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.DTO.AdresaDTO;
import com.team32.AgentApp.DTO.OglasDTO;
import com.team32.AgentApp.DTO.OglasDetailsDTO;
import com.team32.AgentApp.DTO.OglasDetailsImgDTO;
import com.team32.AgentApp.DTO.OglasNewDTO;

import com.team32.AgentApp.model.entitet.CommonData;
import com.team32.AgentApp.model.entitet.Narudzbenica;
import com.team32.AgentApp.model.entitet.Oglas;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.tentitet.Adresa;
import com.team32.AgentApp.security.exception.ResourceConflictException;
import com.team32.AgentApp.service.AdresaService;
import com.team32.AgentApp.service.CommonDataService;
import com.team32.AgentApp.service.NarudzbenicaService;
import com.team32.AgentApp.service.OglasService;
import com.team32.AgentApp.service.UserService;

@RestController
public class OglasController {
		@Autowired
		private OglasService oglasService;
		@Autowired
		private CommonDataService comDataService;
		@Autowired
		private UserService userService;
		@Autowired
		private NarudzbenicaService narudzbService;
		
		@Autowired
		private AdresaService adresaService;
		
		//GET ALL
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.GET, value="/oglas", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDTO>> getAllOglas() {
		
			List<Oglas> allOglas = oglasService.getAllOglas();
			
			List<OglasDTO> oglasiDTO = new ArrayList<>();
			for (Oglas o : allOglas) {
				
				OglasDTO oglasDTO = oglasService.getOglasFullDetails(o);
				
				oglasiDTO.add(oglasDTO);
			}
			// convert komentar to DTOs
			return new ResponseEntity<>(oglasiDTO, HttpStatus.OK);
		}
		
		
		//GET ALL
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.GET, value="/oglas/img", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDetailsImgDTO>> getAllOglasWithImg(Principal principal) throws Exception {

			//Preuzima se user iz sesije koji je trenutno ulogovan
			String username = principal.getName();
			User loggedAgent = userService.findByUsername(username);
			
			List<Oglas> allAgentsOglas = oglasService.getAllOglasByAgentId(loggedAgent.getId());
			
			List<OglasDetailsImgDTO> oglasiDTO = new ArrayList<>();
			for (Oglas o : allAgentsOglas) {
				
				OglasDetailsImgDTO oglasDTO = oglasService.getOglasFullDetailsImg(o);
				
				oglasiDTO.add(oglasDTO);
			}
			// convert komentar to DTOs
			return new ResponseEntity<>(oglasiDTO, HttpStatus.OK);
		}
		
		
		//GET ALL
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.GET, value="/oglas/agent", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<OglasDTO>> getAllAgentsOglas(Principal principal) {
		
			//Preuzima se user iz sesije koji je trenutno ulogovan
			String username = principal.getName();
			User loggedAgent = userService.findByUsername(username);
			
			
			List<Oglas> allAgentsOglas = oglasService.getAllOglasByAgentId(loggedAgent.getId());
			
			List<OglasDTO> oglasiDTO = new ArrayList<>();
			for (Oglas o : allAgentsOglas) {
				
				OglasDTO oglasDTO = oglasService.getOglasFullDetails(o);
				
				oglasiDTO.add(oglasDTO);
			}
			// convert komentar to DTOs
			return new ResponseEntity<>(oglasiDTO, HttpStatus.OK);
		}

		//GET
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.GET, value="/oglas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> getOglas(@PathVariable("id") Long id){
			OglasDTO oglasDTO = new OglasDTO();
			
			Oglas oglas = oglasService.findOne(id);
			if(oglas == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			oglasDTO = oglasService.getOglasFullDetails(oglas);

			return new ResponseEntity<>(oglasDTO, HttpStatus.OK);
		}
		
		//GET
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.GET, value="/oglas/{id}/details", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDetailsDTO> getOglasDetail(@PathVariable("id") Long id){
			
			Oglas oglas = oglasService.findOne(id);
			if(oglas == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(oglasService.getOglasFullDetailsMilisec(oglas), HttpStatus.OK);
		}
		
		//POST
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(method=RequestMethod.POST, value="/oglas",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<OglasDTO> addOglas(Principal principal, @RequestBody OglasNewDTO dto)  throws Exception {
			Oglas savedOglas = new Oglas();
			
			//Preuzima se user iz sesije koji je trenutno ulogovan
			String username = principal.getName();
			User loggedAgent = userService.findByUsername(username);
			
			if(isIntervalSlobodan(loggedAgent.getId(), dto)==false) {
				throw new Exception("Ad already exists!");
			}
			
			//Prilkom kreiranja novog oglasa odmah se kreira i commonData koji pamti ko je kreirao oglas i kada.
			CommonData commonData = setCommonData(loggedAgent.getId());
			
			//Prilkom kreiranja novog oglasa odmah se kreira i nova adresa vezana za taj oglas.
			Adresa adresa = setAdresa(dto, loggedAgent.getId());
			//Izvrsi se cuvanje nove adrese i kreira na osnovu povratne vrednosti(nje same) DTO.
			AdresaDTO adresaDTO = new AdresaDTO(adresaService.addAdresa(adresa));
			
			System.out.println("Od datuma dto: " + dto.getOdDatuma());
			System.out.println("Od datuma: "  + LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
			System.out.println("Do datuma dto: " + dto.getDoDatuma());
			System.out.println("Do datuma: "  + LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
			
			savedOglas.setId(dto.getId());
			savedOglas.setOdDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
			savedOglas.setDoDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
			savedOglas.setAutomobilId(dto.getAutomobilId());
			savedOglas.setCenovnikId(dto.getCenovnikId());
			savedOglas.setPlaniranaKilometraza(dto.getPlaniranaKilometraza());
			
			savedOglas.setAdresaId(adresaDTO.getId());
			savedOglas.setCommonDataId(commonData.getId());

			savedOglas = oglasService.addOglas(savedOglas);
			
			//vraca OglasDTO samo zato da bi se proverilo da li su dobri datumi uneti u citljivom formatu
			return new ResponseEntity<>(new OglasDTO(savedOglas), HttpStatus.CREATED);
		}
		
		
		//DELETE
		@PreAuthorize("hasRole('ROLE_AGENT')")
		@RequestMapping(value="/oglas/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Void> deleteOglas(@PathVariable Long id) {
			Oglas oglas = oglasService.findOne(id);
			if (oglas != null) {
				
				List<HashMap<String, LocalDateTime>> imaZauzetihTermina = getZauzetiTermini(narudzbService.getAllNarudzbeniceByOglasId(oglas.getId()));
				
				if(imaZauzetihTermina.size() == 0){
					Adresa adresa =  adresaService.findOne(oglas.getAdresaId());
					//obrise se adresa vezana za oglas
					adresaService.deleteAdresa(adresa.getId());
					//obrise se i commonData te adrese
					comDataService.deleteCommonData(adresa.getCommonDataId());
					
					//obrise se sam oglas
					oglasService.deleteOglas(id);
					//obrise se commonData tog oglasa
					comDataService.deleteCommonData(oglas.getCommonDataId());
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}else {
					throw new ResourceConflictException(oglas.getId(), "There are reservations connected to this ad!");
				}

			} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
		}
		
		//POMOCNE METODE
		
		//Pomocna metoda za kreiranje novog commonData
		public CommonData setCommonData(Long userId) throws Exception {
			CommonData commonData = new CommonData();
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumKreiranja(now);
			commonData.setUserId(userId); 
			commonData = comDataService.addCommonData(commonData);	
			return commonData;
		}
		
		//Pomocna metoda za azuriranje postojeceg commonData
		public CommonData updateCommonData(Long comDataId) throws Exception {
			CommonData commonData = comDataService.findOne(comDataId);
			LocalDateTime now = LocalDateTime.now();
			commonData.setDatumIzmene(now);
			commonData = comDataService.updateCommonData(comDataId, commonData);
			return commonData;
		}
		
		//Pomocna metoda koja kreiran novu adresu i povezuje je sa oglasom
		public Adresa setAdresa(OglasNewDTO dto, Long userId) throws Exception {
			Adresa adresa = new Adresa();
			adresa.setMesto(dto.getAdresa().getMesto());
			adresa.setPostanskiBroj(dto.getAdresa().getPostanskiBroj());
			adresa.setUlica(dto.getAdresa().getUlica());
			adresa.setBroj(dto.getAdresa().getBroj());
			
			//Prilkom kreiranja nove adrese odmah se kreira i commonData koji pamti ko je kreirao adresu i kada.
			CommonData adresaCommonData = setCommonData(userId);
			adresa.setCommonDataId(adresaCommonData.getId());
			
			return adresa;
		}
		
		//Pomocna metoda koja azurira adresu prilikom azuriranja oglasa sa kojim je povezana
		public Adresa updateAdresa(OglasNewDTO dto, Long adresaId) throws Exception {
			Adresa adresa =  adresaService.findOne(adresaId);
			adresa.setMesto(dto.getAdresa().getMesto());
			adresa.setPostanskiBroj(dto.getAdresa().getPostanskiBroj());
			adresa.setUlica(dto.getAdresa().getUlica());
			adresa.setBroj(dto.getAdresa().getBroj());
			
			//Prilkom izmene adrese odmah se menja i commonData koji pamti kada je izmena izvrsena.
			CommonData adresaCommonData = updateCommonData(adresa.getCommonDataId());
			adresa.setCommonDataId(adresaCommonData.getId());
			
			return adresa;
		}
		
		/****
		 * 
		 * @param Lista narudzbenica
		 * @return Zauzete termine iz narudzbenica tog oglasa <HashMap<String, LocalDateTime>
		 */
		//Pomocna metoda koja sluzi za izvlacenje zauzetih termina iz narudzbenica tog oglasa.
		public List<HashMap<String, LocalDateTime>> getZauzetiTermini(List<Narudzbenica> narudzbenice) {
			List<HashMap<String, LocalDateTime>> zauzetiTermini = new  ArrayList<HashMap<String, LocalDateTime>>();
			for (Narudzbenica n : narudzbenice) {
				//ovaj deo koda potencijalno izmeniti za TerminDTO:
				HashMap<String, LocalDateTime> hash_map = new HashMap<String, LocalDateTime>();
				hash_map.put("odDatuma", n.getOdDatuma());
				hash_map.put("doDatuma", n.getDoDatuma());
				System.out.println("Initial Mappings are: " + hash_map);
				zauzetiTermini.add(hash_map);
			}
			
			return zauzetiTermini;
		}
		
		/****
		 * 
		 * @param agentId id agenta tipa long za preuzimanje samo njegovih oglasa
		 * @param dto Novi oglas za ciji interval se proverava da li se preklapa sa drugim oglasima istog automobila 
		 * @return Boolean true ako je interval za novi oglas slobodan, u suprotnom vrati false
		 */
		//Provera da li se novi oglas poklapa sa neki drugi vec kreiranim oglasom za interval i utomobil 
		//(za razlicite automobile mogu postojati oglasi u istom terminu)... 
		public boolean isIntervalSlobodan(Long agentId, OglasNewDTO dto){
			List<Oglas> oglas = oglasService.getAllOglasByAgentId(agentId);
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
		//Za vracanje iz LocalDateTime to milisec Iskoristiti kod oglasa za vracanje termina zauzetosti...
//		Long test = savedOglas.getOdDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
//		Long test1 = savedOglas.getDoDatuma().atZone(TimeZone.getDefault().toZoneId()).toInstant().toEpochMilli();
//		
//		System.out.println("Ponovo u milisec odDatuma: " + test);
//		System.out.println("Ponovo iz milisec  u odDatuma: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(test), TimeZone.getDefault().toZoneId()));
//
//		System.out.println("Ponovo u milisec doDatuma: " + test1);
//		System.out.println("Ponovo iz milisec  u doDatuma: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(test1), TimeZone.getDefault().toZoneId()));
		
		
		
//		//PUT NE MOZE se menjati oglas, moze samo da se obrise i kreira novi... 
//		@RequestMapping(method=RequestMethod.PUT, value="/oglas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//		public ResponseEntity<OglasNewDTO> updateOglas(@RequestBody OglasNewDTO dto) throws Exception{
//			
//			Oglas updatedOglas = oglasService.findOne(dto.getId());
//			if(updatedOglas == null) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
//			
//			CommonData commonData = updateCommonData(updatedOglas.getCommonDataId());
//			
//			//Ukoliko se menja adresa oglasa.
//			Adresa adresa = updateAdresa(dto, updatedOglas.getAdresaId());
//			//Izvrsi se cuvanje izmenjene adrese i kreira na osnovu povratne vrednosti(nje same) DTO.
//			AdresaDTO updatedAdresaDTO = new AdresaDTO(adresaService.updateAdresa(adresa.getId(), adresa));
//			
//			updatedOglas.setId(dto.getId());	
//			updatedOglas.setOdDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getOdDatuma()), TimeZone.getDefault().toZoneId()));
//			updatedOglas.setDoDatuma(LocalDateTime.ofInstant(Instant.ofEpochMilli(dto.getDoDatuma()), TimeZone.getDefault().toZoneId()));
//			updatedOglas.setAutomobilId(dto.getAutomobilId());
//			updatedOglas.setCenovnikId(dto.getCenovnikId());
//			updatedOglas.setPlaniranaKilometraza(dto.getPlaniranaKilometraza());
//			//Ne updejtuje se id automobila i id adrese
//			updatedOglas.setCommonDataId(commonData.getId());
//			updatedOglas = oglasService.updateOglas(updatedOglas.getId(), updatedOglas);
//			
//			return new ResponseEntity<>(new OglasNewDTO(updatedOglas, updatedAdresaDTO),HttpStatus.OK);
//		}
		
		
}
