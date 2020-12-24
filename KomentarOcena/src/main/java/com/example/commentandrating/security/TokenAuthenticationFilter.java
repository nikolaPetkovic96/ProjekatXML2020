package com.example.commentandrating.security;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

//Filter koji ce presretati svaki zahtev klijenta ka serveru
//Sem nad putanjama navedenim u WebSecurityConfig.configure(WebSecurity web)
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getHeader("username");
		List<SimpleGrantedAuthority> roles = new LinkedList<>();

		if (username != null) {
			String[] r = request.getHeader("roles").replace(",", "").replace("[", "").replace("]", "").split(" ");
			for (String rr : r) {
				rr = rr.trim();
				if (rr.equals(""))
					continue;
				roles.add(new SimpleGrantedAuthority(rr));
			}

			RememberMeAuthenticationToken authentication = new RememberMeAuthenticationToken(username, username, roles);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		chain.doFilter(request, response);
	}

}