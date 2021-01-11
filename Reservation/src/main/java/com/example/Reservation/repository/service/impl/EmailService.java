//package com.example.Reservation.repository.service.impl;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpMethod;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import com.example.Reservation.model.Izvestaj;
//
//@Service
//public class EmailService {
//	@Autowired
//	private JavaMailSender javaMailSender;
//	@Autowired
//	private Environment env;
//
////	@Async
////	public void sendActivationEmail(User u) {
////		SimpleMailMessage mail = new SimpleMailMessage();
////		mail.setTo("zarexblage00@gmail.com");
////		mail.setFrom(env.getProperty("spring.mail.username"));
////		mail.setSubject("Aktivacioni email");
////		String body = null;
////		//TODO moze neka strancia da  se napravi, da ne prikaze samo true
//////		if (u.getAuthorities().get(0).getName().equals("ROLE_USER"))
////			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
////					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
////					+ "LINK NA KOM JE STRANICA ZA PODESAVANJE LOZNKE/" + "?id=" + u.getId() + "&secret="
////					+ u.getLozinka();
//////		else
////			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
////					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
////					+ "http://localhost:2020/loginreg-service/api/user/activate-user" + "?id=" + u.getId() + "&secret="
////					+ u.getLozinka();
////		mail.setText(body);
////		javaMailSender.send(mail);
////	}
//	
//	@Async
//	public void sendBillEmail(Long userId, Izvestaj i) {
//		UserInfo user=getUserInfo(userId);
//		
//		SimpleMailMessage mail = new SimpleMailMessage();
//		mail.setTo(user.getEmail());
//		mail.setFrom(env.getProperty("spring.mail.username"));
//		mail.setSubject("Dodatni troškovi");
//		String body = null;
//		body = "Poštovani/na " + user.getIme() + " " + user.getPrezime()
//			+ "\nOvom priliko Vas obaveštavamo da ste prilikom Vaše poslednje rezervacije prešli " + i.getPredjenaKilometraza() + " km"  
//			+ "\ni time prekoračili planiranu kilometražu za iznajmljeno vozilo za " + i.getPrekoracenaKilometraza() + " km"
//			+ "\nTime ste ostvarili dodatne troškove u vrednosti od " + i.getDodatniTroskovi() + " dinara."
//			+ "\nMolimo Vas da izmirite vaše dugovanje u najkraćem mogućem roku."
//			+ "\nDok to ne učinite nećete biti u mogućnosti da iznajmljujete ni jedno novo vozilo."
//			+ "\n"
//			+ "\n Srdačan pozdrav.";
//		mail.setText(body);
//		javaMailSender.send(mail);
//	}
//	
//	private UserInfo getUserInfo(Long userId) {
//		List<Map> users = (List<Map>) RESTClient.getClient().forService(Services.LOGIN).withPath("/api/user")
//				.withMethod(HttpMethod.GET).send();
//			UserInfo user= new UserInfo();
//			for (Map m : users) {
//				if(m.get("id").equals(userId)) {
//					user.setEmail((String) m.get("email"));
//					user.setId((Long) m.get("id"));
//					user.setIme((String) m.get("ime"));
//					user.setPrezime((String) m.get("prezime"));
//					user.setUsername((String) m.get("username"));
//				}
//				else
//					continue;
//				
//			}return user;
//	}
//
//	private class UserInfo{
//		private String username;
//		private Long id;
//		private String ime;
//		private String prezime;
//		private String email;
//		public UserInfo(String username, Long id, String ime, String prezime, String email) {
//			super();
//			this.username = username;
//			this.id = id;
//			this.ime = ime;
//			this.prezime = prezime;
//			this.email = email;
//		}
//		public UserInfo() {
//			// TODO Auto-generated constructor stub
//		}
//		public String getUsername() {
//			return username;
//		}
//		public void setUsername(String username) {
//			this.username = username;
//		}
//		public Long getId() {
//			return id;
//		}
//		public void setId(Long id) {
//			this.id = id;
//		}
//		public String getIme() {
//			return ime;
//		}
//		public void setIme(String ime) {
//			this.ime = ime;
//		}
//		public String getPrezime() {
//			return prezime;
//		}
//		public void setPrezime(String prezime) {
//			this.prezime = prezime;
//		}
//		public String getEmail() {
//			return email;
//		}
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		
//	}
//}
