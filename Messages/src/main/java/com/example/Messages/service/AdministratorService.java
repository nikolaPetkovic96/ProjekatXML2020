package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.repository.AdministratorRepository;


@Service
public class AdministratorService {
	
	@Autowired
	private  AdministratorRepository  adminRepository;
	
	public List< Administrator> getAllAdministrator(){
		List< Administrator>  adminKlinCentra = new ArrayList<>();
			adminRepository.findAll().forEach(adminKlinCentra::add);
			return adminKlinCentra;
		}

		public Administrator findOne(Long id) {
			return adminRepository.findById(id).orElseGet(null);
		}
		
		public Administrator addAdministrator(Administrator administrator)throws Exception{
			  if (administrator.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  Administrator savedAdminKlinCentra = adminRepository.save(administrator);
		        return savedAdminKlinCentra;
			
		}
		
		public Administrator updateAdministrator(Long id, Administrator administrator) throws Exception {
			Optional<Administrator> adminKlinCentraToUpadet = adminRepository.findById(id);
			if (adminKlinCentraToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			Administrator updateAdminKilCentra = adminRepository.save(administrator);
			return updateAdminKilCentra;
		}
		
		public void deleteAdministrator(Long id) {
			adminRepository.deleteById(id);
		}
}
