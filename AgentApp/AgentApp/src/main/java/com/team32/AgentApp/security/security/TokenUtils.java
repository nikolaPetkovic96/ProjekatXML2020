package com.team32.AgentApp.security.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.team32.AgentApp.model.entitet.User;
import com.team32.AgentApp.security.common.TimeProvider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//Klasa koja generise tokene i radi sve sanjima;
@Component
public class TokenUtils {
	// Izdavac tokena
	@Value("spring-security-example")
	private String APP_NAME;
	
	// Tajna koju samo backend aplikacija treba da zna kako bi mogla da generise i proveri JWT https://jwt.io/
	@Value("somesecret")
	public String SECRET;

	// Period vazenja sedam dana u sekundama
	@Value("604800000")
	private int EXPIRES_IN;


	//Naziv hedera u kojem ce biti token se zove Authorzation i kroz koji ce se prosledjivati JWT u komunikaciji server-klijent
	@Value("Authorization")
	private String AUTH_HEADER;

	
	//Razliciti uredjaji imaju razlicite expiresion date...
	//Moguce je generisati JWT za razlicite klijente (npr. web i mobilni klijenti nece imati isto trajanje JWT, 
	//JWT za mobilne klijente ce trajati duze jer se mozda aplikacija redje koristi na taj nacin)
	static final String AUDIENCE_UNKNOWN = "unknown";
	static final String AUDIENCE_WEB = "web";
	static final String AUDIENCE_MOBILE = "mobile";
	static final String AUDIENCE_TABLET = "tablet";

	@Autowired
	TimeProvider timeProvider;

	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

	// Funkcija za generisanje JWT token
	public String generateToken(String username, String role) {
		System.out.println("Usao u generateToken!");
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(username)
				.setAudience(generateAudience())
				.setIssuedAt(timeProvider.now())
				.setExpiration(generateExpirationDate())
				.claim("role", role) //postavljanje proizvoljnih podataka u telo JWT tokena
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
	}

	private String generateAudience() {
//		Moze se iskoristiti org.springframework.mobile.device.Device objekat za odredjivanje tipa uredjaja sa kojeg je zahtev stigao.
		
//		String audience = AUDIENCE_UNKNOWN;
//		if (device.isNormal()) {
//			audience = AUDIENCE_WEB;
//		} else if (device.isTablet()) {
//			audience = AUDIENCE_TABLET;
//		} else if (device.isMobile()) {
//			audience = AUDIENCE_MOBILE;+2
//		}
		return AUDIENCE_WEB;
	}

	private Date generateExpirationDate() {
		return new Date(timeProvider.now().getTime() + EXPIRES_IN);
	}

	//IStekao tokena a korisnik je i dalje validan onda se ovo koristi da refresuje token;
	// Funkcija za refresh JWT tokena
	public String refreshToken(String token) {
		System.out.println("Usao u refreshToken!");
		String refreshedToken;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(timeProvider.now());
			refreshedToken = Jwts.builder()
					.setClaims(claims)
					.setExpiration(generateExpirationDate())
					.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = this.getIssuedAtDateFromToken(token);
		return (!(this.isCreatedBeforeLastPasswordReset(created, lastPasswordReset))
				&& (!(this.isTokenExpired(token)) || this.ignoreTokenExpiration(token)));
	}

	// Funkcija za validaciju JWT tokena
	public Boolean validateToken(String token, UserDetails userDetails) {
		System.out.println("Usao u validateToken!");
		User user = (User) userDetails;
		final String username = getUsernameFromToken(token);
		final Date created = getIssuedAtDateFromToken(token);
		
		return (username != null && username.equals(userDetails.getUsername())
				&& !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
	}

	
	//Izvlacenje odredjenih podataka iz tokena:
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getIssuedAtDateFromToken(String token) {
		Date issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = claims.getIssuedAt();
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}

	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			audience = claims.getAudience();
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public int getExpiredIn() {
		return EXPIRES_IN;
	}

	// Funkcija za preuzimanje JWT tokena iz zahteva
	public String getToken(HttpServletRequest request) {
		System.out.println("Usao u getToken!");
		String authHeader = getAuthHeaderFromHeader(request);

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		
		System.out.println("Problem sa token authHeader!");
		return null;
	}

	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER);
	}
	
	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		return expiration.before(timeProvider.now());
	}

	private Boolean ignoreTokenExpiration(String token) {
		String audience = this.getAudienceFromToken(token);
		return (audience.equals(AUDIENCE_TABLET) || audience.equals(AUDIENCE_MOBILE));
	}

	// Funkcija za citanje svih podataka iz JWT tokena
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

}