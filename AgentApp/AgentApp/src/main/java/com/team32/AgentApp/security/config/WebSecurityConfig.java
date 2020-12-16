package com.team32.AgentApp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.team32.AgentApp.security.auth.RestAuthenticationEntryPoint;
import com.team32.AgentApp.security.auth.TokenAuthenticationFilter;
import com.team32.AgentApp.security.security.TokenUtils;
import com.team32.AgentApp.service.impl.CustomUserDetailsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //ovo nam omogucava da se na kotrolerima lepi @PreOuthorised i provera rola;
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Implementacija PasswordEncoder-a koriscenjem BCrypt hashing funkcije.
	// BCrypt po defalt-u radi 10 rundi hesiranja prosledjene vrednosti.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Servis koji se koristi za citanje podataka o korisnicima aplikacije
	//Zato sto ce se ona njegova metoda loadByUsername stalno trigerovati da pita za prava;
	@Autowired
	private CustomUserDetailsService jwtUserDetailsService;

	// Handler za vracanje 401 kada klijent sa neodogovarajucim korisnickim imenom i lozinkom pokusa da pristupi resursu
	// Neautorizovani pristup zastcenim resursima (univerzalni exception handler)
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	
	//AuthetnicationManager nam radi auntentifikaciju, dovoljno ga samo injekotvati.
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	// Definisemo uputstvo za authentication managera koji servis da koristi da izvuce podatke o korisniku koji zeli da se autentifikuje,
	//kao i kroz koji enkoder da provuce lozinku koju je dobio od klijenta u zahtevu da bi adekvatan hash koji dobije kao rezultat bcrypt algoritma uporedio sa onim koji se nalazi u bazi (posto se u bazi ne cuva plain lozinka)
	// Definisemo nacin autentifikacije
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	// Injektujemo implementaciju iz TokenUtils klase kako bismo mogli da koristimo njene metode za rad sa JWT u TokenAuthenticationFilteru
	@Autowired
	TokenUtils tokenUtils;

	// Definisemo prava pristupa odredjenim URL-ovima
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// komunikacija izmedju klijenta i servera je stateless
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				// za neautorizovane zahteve posalji 401 gresku onu RestAuthenticationEntryPoint iz security.auth
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

				// svim korisnicima dopusti da pristupe putanjama /**, /h2-console/** i /api/foo
				.authorizeRequests().antMatchers("/**").permitAll().antMatchers("/home").permitAll().antMatchers("/auth/login").permitAll()  
				
				// svaki zahtev mora biti autorizovan !!! A to definisem kod same metode u kontroleru sa @PreAuthorize(pa rola);
				.anyRequest().authenticated().and()
				
				//ovaj cors() je za webConfig klasu
				.cors().and()

				// presretni svaki zahtev filterom, rekli da pre basic autenifikacionog filtera prvo ovaj nas custom (za tokene) potera.
				.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
						BasicAuthenticationFilter.class);

		http.csrf().disable(); //disejblujemo kada koristimo tokene, da kada neko drugi salje zahtev sa nase ulogovane sesije. 
	}

	// Generalna bezbednost aplikacije ovde stavljamo sta sve, svi korisnici  mogu.
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
		web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");//svako moze da se registurje ovo je bilo dodato opciono...
		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
				"/**/*.css", "/**/*.js");
	}

}
