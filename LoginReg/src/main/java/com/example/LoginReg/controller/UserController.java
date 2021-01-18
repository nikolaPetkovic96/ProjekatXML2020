package com.example.LoginReg.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoginReg.config.auth.JwtAuthenticationRequest;
import com.example.LoginReg.model.UserDTO;
import com.example.LoginReg.model.UserTokenState;
import com.example.LoginReg.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private HttpServletResponse httpServletResponse;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws IOException {
		try {
			UserTokenState a = userService.login(authenticationRequest);
			return ResponseEntity.ok(a);
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials!");
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public UserDTO register(@RequestBody UserDTO user) {
		return userService.registerUser(user);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/register-admin", method = RequestMethod.POST)
	public UserDTO registerAdmin(@RequestBody UserDTO user) {
		return userService.registerAgentOrAdmin(user, "admin");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/register-agent", method = RequestMethod.POST)
	public UserDTO registerAdgent(@RequestBody UserDTO user) {
		return userService.registerAgentOrAdmin(user, "agent");
	}

	// za agenta i admina
	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	public UserDTO activateAccount(@RequestBody Map<String, String> user) {
		return userService.activateAgentOrAdmin(user);
	}

	@RequestMapping(value = "/activate-user", method = RequestMethod.GET)
	public ResponseEntity<String> activateUSer(@RequestParam("id") String id, @RequestParam("secret") String secret) {
		if(userService.activateUser(id, secret) == true) {
			String test = "http://localhost:8082/login";
			return ResponseEntity.status(302).header("Location", test).body("All good!");
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials!");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/deactivate/{id}", method = RequestMethod.GET)
	public boolean deactivate(@PathVariable("id") Long user) {
		return userService.deactivate(user,"neaktivan");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/block/{id}", method = RequestMethod.GET)
	public boolean block(@PathVariable("id") Long user) {
		return userService.deactivate(user,"obrisan");
	}

	// TODO refresh token
	/*
	 * @RequestMapping(value = "/refresh", method = RequestMethod.POST) public
	 * ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {
	 * String token = tokenUtils.getToken(request); if
	 * (this.tokenUtils.canTokenBeRefreshed(token, null)) { String refreshedToken =
	 * tokenUtils.refreshToken(token); int expiresIn = tokenUtils.getExpiredIn();
	 * return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn)); }
	 * else { UserTokenState userTokenState = new UserTokenState(); return
	 * ResponseEntity.badRequest().body(userTokenState); } }
	 */
	 @PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "", method = RequestMethod.GET)
	// PARAMETAR type odredjuje koje korisnike hoces, ako ga ne posaljes dobices sve
	// moguce vredsnoti: admin, user, agent
	// to se u zahtevu kuca kao localnhost..../api/user?type=admin
	public List<UserDTO> getUsers(HttpServletRequest request, @RequestParam("type") Optional<String> type) {
		return userService.getUsers(type.orElse(null));
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public HashMap<String, Object> auth(HttpServletRequest request) {
		return userService.doAuth(request);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/permissions", method = RequestMethod.GET)
	public void changePersmissions(@RequestParam("id") Long id, @RequestParam("comment") Optional<Boolean> comment,
			@RequestParam("reservation") Optional<Boolean> reservation, @RequestParam("message") Optional<Boolean> message) {
		userService.changePermissions(id, comment.orElse(null), reservation.orElse(null), message.orElse(null));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@RequestMapping(value = "/profile/update", method = RequestMethod.PUT)
	public UserDTO changeUser(@RequestBody UserDTO user) {
		return userService.changeUser(user);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public UserDTO myProfile() {
		return userService.getMyProfile();
	}

}
