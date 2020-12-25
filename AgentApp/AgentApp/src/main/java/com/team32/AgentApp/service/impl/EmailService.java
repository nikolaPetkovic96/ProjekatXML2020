package com.team32.AgentApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

	public void sendTestEmail() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("jelena.boroja1@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacioni email");
		String body = null;
		body = "Pozdrav ovo je poruka izgenerisana od strane Markove genijalne aplikacije!";
		mail.setText(body);
		javaMailSender.send(mail);
		
	}
}
