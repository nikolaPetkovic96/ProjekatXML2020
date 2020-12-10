package com.example.KomentarOcena.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	// Neautorizovani pristup zastcenim resursima
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				// za neautorizovane zahteve posalji 401 gresku
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
				//TODO: putanje na koje se pusta svako, moze has role da se stavi pa da se pusta samo odredjena rola
				//na nivou metoda sa hasrole se isto to moze regulisati
				.authorizeRequests().antMatchers("/api/user/**").permitAll()
	
				// svaki zahtev mora biti autorizovan, ovo se ne menja
				 .anyRequest().authenticated().and()
				.addFilterBefore(new TokenAuthenticationFilter(), BasicAuthenticationFilter.class);


		http.csrf().disable();
	}

	// Generalna bezbednost aplikacije
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
		// TODO putanje za koje se ignorise security
		// web.ignoring().antMatchers(HttpMethod.POST, "/api/auth/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/",  "/webjars/**", "/*.html", "/favicon.ico",
				"/**/*.html", "/**/*.png", "/**/*.css", "/**/*.js");
	}

}
