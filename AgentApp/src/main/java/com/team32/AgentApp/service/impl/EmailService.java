package com.team32.AgentApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.team32.AgentApp.model.entitet.Izvestaj;
import com.team32.AgentApp.model.entitet.User;
///TODO premestiti u poseban servis? 

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Environment env;

	@Async
	public void sendActivationEmail(User u) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("zarexblage00@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacioni email");
		String body = null;
		//TODO moze neka strancia da  se napravi, da ne prikaze samo true
//		if (u.getAuthorities().get(0).getName().equals("ROLE_USER"))
			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
					+ "LINK NA KOM JE STRANICA ZA PODESAVANJE LOZNKE/" + "?id=" + u.getId() + "&secret="
					+ u.getLozinka();
//		else
			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
					+ "http://localhost:2020/loginreg-service/api/user/activate-user" + "?id=" + u.getId() + "&secret="
					+ u.getLozinka();
		mail.setText(body);
		javaMailSender.send(mail);
	}
	
	@Async
	public void sendBillEmail(User user, Izvestaj i) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Dodatni troškovi");
		String body = null;
		body = "Poštovani/na " + user.getIme() + " " + user.getPrezime()
			+ "\nOvom priliko Vas obaveštavamo da ste prilikom Vaše poslednje rezervacije prešli " + i.getPredjenaKilometraza() + " km"  
			+ "\ni time prekoračili planiranu kilometražu za iznajmljeno vozilo za " + i.getPrekoracenaKilometraza() + " km"
			+ "\nTime ste ostvarili dodatne troškove u vrednosti od " + i.getDodatniTroskovi() + " dinara."
			+ "\nMolimo Vas da izmirite vaše dugovanje u najkraćem mogućem roku."
			+ "\nDok to ne učinite nećete biti u mogućnosti da iznajmljujete ni jedno novo vozilo."
			+ "\n"
			+ "\n Srdačan pozdrav.";
		mail.setText(body);
		javaMailSender.send(mail);
	}
}
