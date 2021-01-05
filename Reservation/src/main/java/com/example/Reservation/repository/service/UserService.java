package com.example.Reservation.repository.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Reservation.model.TUser;
import com.example.Reservation.repository.UserRepository;
import com.sun.el.stream.Optional;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository userRepository;
	
	public List<TUser> getAllUser(){
		List<TUser>  users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			return users;
		}

		public TUser findOne(Long id) {
			return userRepository.findById(id).orElseGet(null);
		}
		
		public TUser addUser(TUser user)throws Exception{
			  if (user.getId() != null) {
		            throw new Exception(
		                    "Id mora biti null prilikom perzistencije novog entiteta.");
		        }
			  TUser savedUser = userRepository.save(user);
		        return savedUser;
			
		}
		
		public TUser updateUser(Long id, TUser user) throws Exception {
			TUser userToUpadet = userRepository.findById(id).orElse(null);
			if (userToUpadet == null) {
		           throw new Exception("Trazeni entitet nije pronadjen.");
		    }
			TUser updateUser = userRepository.save(user);
			return updateUser;
		}
		
		public void deleteUser(Long id) {
			userRepository.deleteById(id);
		}
		
	//ZA SECURITY
		
		public TUser findByUsername(String username) throws UsernameNotFoundException {
			return userRepository.findByKorisnickoIme(username);
		}
		
//		//Override nad save je uradjen kako bi se password enkriptovao
//		public User save(UserRequest userRequest) {
//			User u = new User();
//			u.setUsername(userRequest.getUsername());
//			u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//			//u.setEmail(userRequest.getE);
//			u.setEnabled(true);
//			
//			List<Authority> auth = authService.findByName("ROLE_USER");
//			u.setAuthorities(auth);
//			
//			u = this.userRepository.save(u);
//			return u;
//		}

}
