package com.example.LoginReg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
///TODO premestiti u poseban servis? 

import com.example.LoginReg.model.TUser;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Environment env;

	@Async
	public void sendActivationEmail(TUser u) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(u.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacioni email");
		String body = null;
		//TODO moze neka strancia da  se napravi, da ne prikaze samo true
		if (u.getAuthorities().get(0).getName().equals("ROLE_USER"))
			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
					+ "LINK NA KOM JE STRANICA ZA PODESAVANJE LOZNKE/" + "?id=" + u.getId() + "&secret="
					+ u.getLozinka();
		else
			body = "Postovani  " + u.getIme() + " " + u.getPrezime()
					+ ",\nDa biste aktivirali svoj nalog, potrebno je da kliknete na sledeci link: "
					+ "http://localhost:2020/loginreg-service/api/user/activate-user" + "?id=" + u.getId() + "&secret="
					+ u.getLozinka();
		mail.setText(body);
		javaMailSender.send(mail);
	}
}
