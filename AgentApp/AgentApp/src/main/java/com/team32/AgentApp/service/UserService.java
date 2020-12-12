package com.team32.AgentApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;
	
	public List<User> getAllUser(){
		List<User>  users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			return users;
		}

		public User findOne(Long id) {
			return userRepository.findById(id).orElseGet(null);
		}
		
		public User addUser(User user)throws Exception{
			  if (user.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  User savedUser = userRepository.save(user);
		        return savedUser;
			
		}
		
		public User updateUser(Long id, User user) throws Exception {
			Optional<User> userToUpadet = userRepository.findById(id);
			if (userToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			User updateUser = userRepository.save(user);
			return updateUser;
		}
		
		public void deleteUser(Long id) {
			userRepository.deleteById(id);
		}

}
