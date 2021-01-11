//package com.example.Reservation.repository.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.Reservation.model.TUser;
//import com.example.Reservation.repository.TUserRepository;
//
//@Service
//public class TUserService {
//	
//	@Autowired
//	private  TUserRepository  tuserRepository;
//	
//	public List< TUser> getAllTUser(){
//		List< TUser>  tuserKlinCentra = new ArrayList<>();
//			tuserRepository.findAll().forEach(tuserKlinCentra::add);
//			return tuserKlinCentra;
//		}
//
//		public TUser findOne(Long id) {
//			return tuserRepository.findById(id).orElseGet(null);
//		}
//		
//		public TUser addTUser(TUser tuser)throws Exception{
//			  if (tuser.getId() != null) {
//		            throw new Exception(
//		                    "Id mora biti null prilikom perzistencije novog entiteta.");
//		        }
//			  TUser savedTUserKlinCentra = tuserRepository.save(tuser);
//		        return savedTUserKlinCentra;
//			
//		}
//		
//		public TUser updateTUser(Long id, TUser tuser) throws Exception {
//			Optional<TUser> tuserKlinCentraToUpadet = tuserRepository.findById(id);
//			if (tuserKlinCentraToUpadet == null) {
//		           throw new Exception("Trazeni entitet nije pronadjen.");
//		    }
//			TUser updateTUserKilCentra = tuserRepository.save(tuser);
//			return updateTUserKilCentra;
//		}
//		
//		public void deleteTUser(Long id) {
//			tuserRepository.deleteById(id);
//		}
//		public TUser findByUsername(String username) {
//			List<TUser>  all=tuserRepository.findAll().stream().collect(Collectors.toList());
//			for(TUser u : all){
//				if(u.getKorisnickoIme().equals(username))
//					return u;
//			}
//			return null;
//		}
//		
//
//}
