package com.example.LoginReg.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoginReg.config.TokenUtils;
import com.example.LoginReg.config.auth.JwtAuthenticationRequest;
import com.example.LoginReg.model.Authority;
import com.example.LoginReg.model.TUser;
import com.example.LoginReg.model.UserTokenState;
import com.example.LoginReg.repository.TUserRepository;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TUserRepository userRepository;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder encoder;

	/*
	 * @Autowired private CustomUserDetailsService userDetailsService;
	 * 
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws AuthenticationException, IOException {
		TUser user = userRepository.findOneByKorisnickoIme(authenticationRequest.getUsername());
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenUtils.generateToken(user.getKorisnickoIme(),user.getId(),user.getAuthorities().get(0).getName());
		int expiresIn = tokenUtils.getExpiredIn();
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody Map<String, String> data)
			throws AuthenticationException, IOException {
		//TODO srediti registraciju
		TUser user = new TUser();
		user.setKorisnickoIme(data.get("username"));
		user.setLozinka(encoder.encode(data.get("password")));
		userRepository.save(user);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "/register-admin", method = RequestMethod.POST)
	public ResponseEntity<?> registerAdmin(@RequestBody Map<String, String> data)
			throws AuthenticationException, IOException {
		//TODO srediti registraciju
		TUser user = new TUser();
		user.setKorisnickoIme(data.get("username"));
		user.setLozinka(encoder.encode(data.get("password")));
		userRepository.save(user);
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {
		String token = tokenUtils.getToken(request);
		if (this.tokenUtils.canTokenBeRefreshed(token, null)) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();
			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public Map<String,Object> redisAuth(HttpServletRequest request) {
		String username;
		Authentication t = SecurityContextHolder.getContext().getAuthentication();
		try {
			String authToken = tokenUtils.getToken(request);

			// uzmi username iz tokena
			username = tokenUtils.getUsernameFromToken(authToken);

			// uzmi user-a na osnovu username-a
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			//TODO dodati stvarne role, ya sada se samo doda test
			// proveri da li je prosledjeni token validan
			if (tokenUtils.validateToken(authToken, userDetails)) {				
				//List<SimpleGrantedAuthority> ats=new LinkedList<>();
				
				//ats.add((new SimpleGrantedAuthority("ROLE_TEST")));
				List<SimpleGrantedAuthority> ats = userDetails.getAuthorities().stream()
						.map(x -> new SimpleGrantedAuthority(((Authority) x).getName())).collect(Collectors.toList());
				// kreiraj autentifikaciju
				t = new RememberMeAuthenticationToken(userDetails.getUsername(),
						userDetails, ats);
			}
		} catch (Exception e) {
			List<GrantedAuthority> roles = new LinkedList<>();
			roles.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
			t = new RememberMeAuthenticationToken("Not Logged In",
				"Not Logged In", roles);
		}
		HashMap< String, Object> ret=new HashMap<>();
		ret.put("username", t.getName());
		Collection<? extends String> xdxdxdd= t.getAuthorities().stream().map(x->x.getAuthority()).collect(Collectors.toList());
		ret.put("roles",xdxdxdd.toArray());
		return ret;
	}

}
