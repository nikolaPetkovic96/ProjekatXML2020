package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.user.TUser;
import com.example.Messages.repository.TUserRepository;

@Service
public class TUserService {
	
	@Autowired
	private  TUserRepository  tuserRepository;
	
	public List< TUser> getAllTUser(){
		List< TUser>  tuserKlinCentra = new ArrayList<>();
			tuserRepository.findAll().forEach(tuserKlinCentra::add);
			return tuserKlinCentra;
		}

		public TUser findOne(Long id) {
			return tuserRepository.findById(id).orElseGet(null);
		}
		
		public TUser addTUser(TUser tuser)throws Exception{
			  if (tuser.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  TUser savedTUserKlinCentra = tuserRepository.save(tuser);
		        return savedTUserKlinCentra;
			
		}
		
		public TUser updateTUser(Long id, TUser tuser) throws Exception {
			Optional<TUser> tuserKlinCentraToUpadet = tuserRepository.findById(id);
			if (tuserKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			TUser updateTUserKilCentra = tuserRepository.save(tuser);
			return updateTUserKilCentra;
		}
		
		public void deleteTUser(Long id) {
			tuserRepository.deleteById(id);
		}

}
