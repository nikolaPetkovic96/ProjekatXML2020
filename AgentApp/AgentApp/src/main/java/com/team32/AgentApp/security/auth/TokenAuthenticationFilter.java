package com.team32.AgentApp.security.auth;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.team32.AgentApp.model.entitet.Authority;
import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.security.security.TokenUtils;

//Filter koji ce presretati svaki zahtev klijenta ka serveru
//Sem nad putanjama navedenim u WebSecurityConfig.configure(WebSecurity web)
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private TokenUtils tokenUtils;

	private UserDetailsService userDetailsService;

	public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
		this.tokenUtils = tokenHelper;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Usao u TokenAuthentificationFilter!");
		String username;
		String authToken = tokenUtils.getToken(request);

		if (authToken != null) {
			// uzmi username iz tokena
			username = tokenUtils.getUsernameFromToken(authToken);
			
			if (username != null) {
				// uzmi user-a na osnovu username-a
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				User user = (User) userDetails;
				List<Authority> authorities = (List<Authority>) user.getAuthorities();
				// proveri da li je prosledjeni token validan
				if (tokenUtils.validateToken(authToken, userDetails)) {
					// kreiraj autentifikaciju
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		
		// prosledi request dalje u sledeci filter
		chain.doFilter(request, response);
	}

}