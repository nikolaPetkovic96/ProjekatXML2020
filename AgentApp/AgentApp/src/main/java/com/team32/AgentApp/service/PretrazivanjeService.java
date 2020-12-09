package com.team32.AgentApp.service;
//package com.example.Messages.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Messages.SchemaToJava2.model.entitet.Pretrazivanje;
//import com.example.Messages.SchemaToJava2.model.user.Administrator;
//import com.example.Messages.repository.AdministratorRepository;
//import com.example.Messages.repository.PretrazivanjeRepository;
//
//@Service
//public class PretrazivanjeService {
//	
//	@Autowired
//	private  PretrazivanjeRepository  pretrazivanjeRepository;
//	
//	public List< Pretrazivanje> getAllPretrazivanje(){
//		List< Pretrazivanje>  pretrazivanjeKlinCentra = new ArrayList<>();
//			pretrazivanjeRepository.findAll().forEach(pretrazivanjeKlinCentra::add);
//			return pretrazivanjeKlinCentra;
//		}
//
//		public Pretrazivanje findOne(Long id) {
//			return pretrazivanjeRepository.findById(id).orElseGet(null);
//		}
//		
//		public Pretrazivanje addPretrazivanje(Pretrazivanje pretrazivanje)throws Exception{
//			  if (pretrazivanje.getId() != null) {
//		            throw new Exception(
//		                    "Id mora biti null prilikom perzistencije novog entiteta.");
//		        }
//			  Pretrazivanje savedPretrazivanjeKlinCentra = pretrazivanjeRepository.save(pretrazivanje);
//		        return savedPretrazivanjeKlinCentra;
//			
//		}
//		
//		public Pretrazivanje updatePretrazivanje(Long id, Pretrazivanje pretrazivanje) throws Exception {
//			Optional<Pretrazivanje> pretrazivanjeKlinCentraToUpadet = pretrazivanjeRepository.findById(id);
//			if (pretrazivanjeKlinCentraToUpadet == null) {
//		           throw new Exception("Trazeni entitet nije pronadjen.");
//		    }
//			Pretrazivanje updatePretrazivanjeKilCentra = pretrazivanjeRepository.save(pretrazivanje);
//			return updatePretrazivanjeKilCentra;
//		}
//		
//		public void deletePretrazivanje(Long id) {
//			pretrazivanjeRepository.deleteById(id);
//		}
//
//}
