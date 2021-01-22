package com.example.LoginReg.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.LoginReg.model.TUser;
import com.example.LoginReg.repository.TUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	protected final Log LOGGER = LogFactory.getLog(getClass());

	@Autowired
	private TUserRepository userRepository;

	// Funkcija koja na osnovu username-a iz baze vraca objekat User-a
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		TUser user = userRepository.findOneByKorisnickoIme(username);
//		if (user == null) {
//			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//		} else {
//			boolean enabled = user.getStatus().equals("aktivan") ? true : false;
//
//			User u = new User(user.getKorisnickoIme(), user.getLozinka(), enabled, enabled, true, !user.getStatus().equals("blokiran"),
//					user.getAuthorities());
//			// User u = new User(user.getKorisnickoIme(), user.getLozinka(),
//			// user.getAuthorities());
//
//			return u;
//		}
//	}

	/*
	 * // Funkcija pomocu koje korisnik menja svoju lozinku public void
	 * changePassword(String oldPassword, String newPassword) {
	 * 
	 * Authentication currentUser =
	 * SecurityContextHolder.getContext().getAuthentication(); String username =
	 * currentUser.getName();
	 * 
	 * if (authenticationManager != null) { LOGGER.debug("Re-authenticating user '"
	 * + username + "' for password change request.");
	 * 
	 * authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(username, oldPassword)); } else {
	 * LOGGER.debug("No authentication manager set. can't change Password!");
	 * 
	 * return; }
	 * 
	 * LOGGER.debug("Changing password for user '" + username + "'");
	 * 
	 * Agent user = (Agent) loadUserByUsername(username);
	 * 
	 * // pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati // ne
	 * zelimo da u bazi cuvamo lozinke u plain text formatu
	 * user.setPassword(passwordEncoder.encode(newPassword));
	 * userRepository.save(user);
	 * 
	 * }
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TUser user = userRepository.findOneByKorisnickoIme(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
//		boolean enabled = user.getStatus().equals("aktivan") ? true : false;
			boolean enabled = false;
			if (user.getStatus().equals("aktivan") || user.getStatus().equals("neaktivan")) {
				enabled = true;
			}
			System.out.println("LOGIN DEBUG: ");
			System.out.println("Status: " + user.getStatus());
			System.out.println("enabled " + enabled);

			User u = new User(user.getKorisnickoIme(), user.getLozinka(), enabled, enabled, true,
					!user.getStatus().equals("obrisan"), user.getAuthorities());
			// User u = new User(user.getKorisnickoIme(), user.getLozinka(),
			// user.getAuthorities());

			return u;
		}
	}

}
