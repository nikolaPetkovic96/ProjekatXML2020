package com.example.LoginReg.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.LoginReg.config.TokenUtils;
import com.example.LoginReg.config.auth.JwtAuthenticationRequest;
import com.example.LoginReg.model.Authority;
import com.example.LoginReg.model.TAdresa;
import com.example.LoginReg.model.TUser;
import com.example.LoginReg.model.UserDTO;
import com.example.LoginReg.model.UserTokenState;
import com.example.LoginReg.repository.AuthorityRepository;
import com.example.LoginReg.repository.TAdresaRepository;
import com.example.LoginReg.repository.TUserRepository;

//TODO razbiti na vise klasa?
@Service
public class UserService {
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TUserRepository userRepository;
	@Autowired
	private TAdresaRepository adresaRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private EmailService emailService;

	public HashMap<String, Object> doAuth(HttpServletRequest request) {
		String username;
		Long userId=-500L;
		Authentication t = SecurityContextHolder.getContext().getAuthentication();
		try {
			String authToken = tokenUtils.getToken(request);
			username = tokenUtils.getUsernameFromToken(authToken);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (tokenUtils.validateToken(authToken, userDetails)) {
				List<SimpleGrantedAuthority> ats = userDetails.getAuthorities().stream()
						.map(x -> new SimpleGrantedAuthority(((Authority) x).getName())).collect(Collectors.toList());
				TUser user = userRepository.findOneByKorisnickoIme(username);
				userId=user.getId();
				t = new RememberMeAuthenticationToken(user.getId().toString(), userDetails, ats);
			}
		} catch (Exception e) {
			List<GrantedAuthority> roles = new LinkedList<>();
			roles.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
			t = new RememberMeAuthenticationToken("Not Logged In", "Not Logged In", roles);
		}
		HashMap<String, Object> ret = new HashMap<>();
		ret.put("username", t.getName());
		ret.put("userid", userId);
		Collection<? extends String> xdxdxdd = t.getAuthorities().stream().map(x -> x.getAuthority())
				.collect(Collectors.toList());
		ret.put("roles", xdxdxdd.toArray());
		return ret;
	}

	public UserTokenState login(JwtAuthenticationRequest authenticationRequest) {
		TUser user = userRepository.findOneByKorisnickoIme(authenticationRequest.getUsername());
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenUtils.generateToken(user.getKorisnickoIme(), user.getId(),
				user.getAuthorities().get(0).getName());
		int expiresIn = tokenUtils.getExpiredIn();
		return new UserTokenState(jwt, expiresIn);
	}

	public UserDTO registerUser(UserDTO user) {
		TUser u = fromDTO(user);
		u.setStatus("aktivan");
		// TODO validarte
		// Moze se validaciaj dodati, npr da se vrati neka greska kad email nije
		// jedinstven i slicno...
		Authority a = authorityRepository.findOneByName("ROLE_USER");

		TAdresa adr = getAddressFromDTO(user);
		u.getAuthorities().add(a);
		u.setStatus("neaktivan");
		try {
			adresaRepository.saveAndFlush(adr);
			u.setAdresaId(adr.getId());
			userRepository.saveAndFlush(u);
		}

		catch (Exception e) {
			if (adr.getId() != null)
				adresaRepository.delete(adr);
			throw new DataIntegrityViolationException("Data not valid!");
		}
		return user;
	}

	public UserDTO registerAgentOrAdmin(UserDTO user, String type) {
		TUser u = fromDTO(user);
		u.setStatus("neaktivan");
		u.setKorisnickoIme(u.getEmail());
		u.setLozinka(encoder.encode(new Date().toString()));
		Authority a = null;
		if (type.equals("admin"))
			a = authorityRepository.findOneByName("ROLE_ADMIN");
		if (type.equals("agent"))
			a = authorityRepository.findOneByName("ROLE_AGENT");
		u.getAuthorities().add(a);
		TAdresa adr = getAddressFromDTO(user);
		try {
			adresaRepository.saveAndFlush(adr);
			u.setAdresaId(adr.getId());
			userRepository.saveAndFlush(u);
			emailService.sendActivationEmail(u);

		}

		catch (Exception e) {
			if (adr.getId() != null)
				adresaRepository.delete(adr);
			throw new DataIntegrityViolationException("Data not valid!");
		}
		return user;
	}

	public UserDTO activateAgentOrAdmin(Map<String, String> user) {
		Long id = Long.parseLong((user.get("id")));
		if (!userRepository.existsById(id))
			throw new DataIntegrityViolationException("Data not valid!");

		TUser u = userRepository.findById(id).get();
		if (!u.getLozinka().equals(user.get("secret")))
			throw new DataIntegrityViolationException("Data not valid!");

		u.setKorisnickoIme(user.get("korisnickoIme"));
		u.setLozinka(encoder.encode(user.get("lozinka")));

		u.setStatus("aktivan");
		try {
			userRepository.saveAndFlush(u);
		}

		catch (Exception e) {
			throw new DataIntegrityViolationException("Data not valid!");
		}
		return toDTO(u);
	}

	public boolean activateUser(String ids, String secret) {
		Long id = Long.parseLong(ids);
		if (!userRepository.existsById(id))// pogrresan id
			throw new DataIntegrityViolationException("Data not valid!");

		TUser u = userRepository.findById(id).get();
		if (u.getStatus().equals("aktivan"))// vec je aktiviran
			throw new DataIntegrityViolationException("Data not valid!");
		if (!encoder.encode(u.getEmail()).equals(secret))// pogresan secret
			throw new DataIntegrityViolationException("Data not valid!");

		u.setStatus("aktivan");
		try {
			userRepository.saveAndFlush(u);
		}

		catch (Exception e) {
			throw new DataIntegrityViolationException("Data not valid!");
		}
		return true;
	}

	public List<UserDTO> getUsers(String type) {
		if (type == null)
			return userRepository.findAll().stream().map(u -> toDTO(u)).collect(Collectors.toList());
		if (type.equals("admin")) {
			Authority a = authorityRepository.findOneByName("ROLE_ADMIN");
			return userRepository.findAllByAuthorities_Name(a.getName()).stream().map(u -> toDTO(u))
					.collect(Collectors.toList());
		}
		if (type.equals("agent")) {
			Authority a = authorityRepository.findOneByName("ROLE_AGENT");
			return userRepository.findAllByAuthorities_Name(a.getName()).stream().map(u -> toDTO(u))
					.collect(Collectors.toList());
		} else {
			Authority a = authorityRepository.findOneByName("ROLE_USER");
			return userRepository.findAllByAuthorities_Name(a.getName()).stream().map(u -> toDTO(u))
					.collect(Collectors.toList());
		}

	}

	private UserDTO toDTO(TUser u) {
		UserDTO user = new UserDTO();
		user.setEmail(u.getEmail());
		user.setId(u.getId());
		user.setIme(u.getIme());
		user.setJmbg(u.getJmbg());
		user.setKorisnickoIme(u.getKorisnickoIme());
		user.setNazivFirme(u.getNazivFirme());
		user.setPol(u.getPol());
		user.setPoslovniMaticniBroj(u.getPoslovniMaticniBroj());
		user.setPrezime(u.getPrezime());
		user.setStatus(u.getStatus());
		Map<String, String> adr = new HashMap<>();
		TAdresa a = adresaRepository.findById(u.getAdresaId()).get();

		adr.put("broj", a.getBroj());
		adr.put("postanskiBroj", a.getPostanskiBroj());
		adr.put("mesto", a.getMesto());
		adr.put("ulica", a.getUlica());
		user.setTAdresa(adr);
		user.setAllowedToCommend(u.isAllowedToCommend());
		user.setAllowedToMakeReservation(u.isAllowedToMakeReservation());
		user.setAllowedToMessage(u.isAllowedToMessage());

		String a1 = u.getAuthorities().get(0).getName();
		if (a1.equals("ROLE_ADMIN"))
			user.setUloga("admin");
		else if (a1.equals("ROLE_AGENT"))
			user.setUloga("agent");
		else
			user.setUloga("user");

		return user;

	}

	private TUser fromDTO(UserDTO user) {
		TUser u = new TUser();
		// TODO dodati da bude neaktivan, pa da se salje mejl za potvrdu
		u.setStatus(user.getStatus());
		u.setPol(user.getPol());
		u.setEmail(user.getEmail());
		u.setKorisnickoIme(user.getKorisnickoIme());
		if (user.getLozinka() != null)
			u.setLozinka(encoder.encode(user.getLozinka()));
		u.setIme(user.getIme());
		u.setPrezime(user.getPrezime());
		u.setJmbg(user.getJmbg());
		return u;
	}

	private TAdresa getAddressFromDTO(UserDTO user) {
		TAdresa adr = new TAdresa();
		adr.setBroj(user.getTAdresa().get("broj"));
		adr.setPostanskiBroj((user.getTAdresa().get("postanskiBroj")));
		adr.setMesto(user.getTAdresa().get("mesto"));
		adr.setUlica(user.getTAdresa().get("ulica"));
		return adr;
	}

	public boolean deactivate(Long id) {
		if (!userRepository.existsById(id))// pogrresan id
			throw new DataIntegrityViolationException("Data not valid!");

		TUser u = userRepository.findById(id).get();
		if (u.getStatus().equals("neaktivan"))// vec je aktiviran
			throw new DataIntegrityViolationException("Data not valid!");
		u.setStatus("neaktivan");
		try {
			userRepository.saveAndFlush(u);
		}

		catch (Exception e) {
			throw new DataIntegrityViolationException("Data not valid!");
		}
		return true;
	}

	public void changePermissions(Long id, Boolean comment, Boolean reservation, Boolean message) {
		if (!userRepository.existsById(id))// pogrresan id
			throw new DataIntegrityViolationException("Data not valid!");

		TUser u = userRepository.findById(id).get();
		if (comment != null)
			u.setAllowedToCommend(comment);
		if (reservation != null)
			u.setAllowedToMakeReservation(reservation);
		if (message != null)
			u.setAllowedToMessage(message);
		try {
			userRepository.saveAndFlush(u);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data not valid!");
		}
	}

	public UserDTO changeUser(UserDTO user) {
		TUser u = userRepository.findOneByKorisnickoIme(user.getKorisnickoIme());
		if (!encoder.matches(user.getStaraLozinka(), u.getLozinka()))
			throw new DataIntegrityViolationException("Wrong password!");
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getJmbg() != null)
			u.setJmbg(user.getJmbg());
		if (user.getPol() != null)
			u.setPol(user.getPol());
		if (user.getNazivFirme() != null)
			u.setNazivFirme(user.getNazivFirme());
		if (user.getPoslovniMaticniBroj() != null)
			u.setPoslovniMaticniBroj(user.getPoslovniMaticniBroj());
		if (user.getPrezime() != null)
			u.setPrezime(user.getPrezime());
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getIme() != null)
			u.setIme(user.getIme());
		if (user.getLozinka() != null)
			u.setLozinka(encoder.encode(user.getLozinka()));

		Map<String, String> adr = user.getTAdresa();
		if (adr != null) {
			TAdresa a = adresaRepository.findById(u.getAdresaId()).get();
			TAdresa newa = getAddressFromDTO(user);
			if (newa.getBroj() != null)
				a.setBroj(newa.getBroj());
			if (newa.getMesto() != null)
				a.setMesto(newa.getMesto());
			if (newa.getUlica() != null)
				a.setUlica(newa.getUlica());
			if (newa.getPostanskiBroj() != null)
				a.setPostanskiBroj(newa.getPostanskiBroj());
			adresaRepository.save(a);

		}
		userRepository.save(u);

		return user;
	}

	public UserDTO getMyProfile() {
		String n=SecurityContextHolder.getContext().getAuthentication().getName();
		TUser u = userRepository.findOneByKorisnickoIme(n);
		return toDTO(u);
	}
}
