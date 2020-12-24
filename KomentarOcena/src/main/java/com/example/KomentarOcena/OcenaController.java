package com.example.KomentarOcena;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcenaController {
	@GetMapping(value = "/all")
	//@PreAuthorize("hasRole('ROLE_ANONYMOUS')") <-ovo je rola koju ima neko ko nije ulogovan
	//moze da se stavi i da vise rola ima pristup => ima na neku kako se kuca to
	public String TestOcenController() {
		return "Ovde moze svako da udje";
	}

	@GetMapping(value = "/test")
	@PreAuthorize("hasRole('ROLE_TEST')")
	public String test() {
		return "Ovde moze samo ko ima TEST ulogu";
	}
}
