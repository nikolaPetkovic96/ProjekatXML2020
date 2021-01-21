package com.team32.AgentApp.controller;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.model.entitet.UserTokenState;
import com.team32.AgentApp.repository.UserRepository;
import com.team32.AgentApp.security.auth.JwtAuthenticationRequest;
import com.team32.AgentApp.security.security.TokenUtils;
import com.team32.AgentApp.soap.SyncService;
import com.team32.AgentApp.soap.dto.client.KomunikacijaClient;
import com.team32.AgentApp.soap.dto.token.TokenResponse;


//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private KomunikacijaClient komunikacijaClient;
	
	@Autowired
	private SyncService syncService;
	
	@Autowired
	private UserRepository userRep;
	

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {
		
		//Svaki put 
		userRep.saveAll(komunikacijaClient.getAllUsers());

		Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		System.out.println("U loginu user.getUsername: " + user.getUsername());
		String jwt = tokenUtils.generateToken(user.getUsername(),"ROLE_AGENT", user.getId());
		int expiresIn = tokenUtils.getExpiredIn();
		
		//Treba jos get
		TokenResponse bekToken = komunikacijaClient.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		user.setToken(bekToken.getToken());
		
		userRep.save(user);
	
		syncService.init();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

}