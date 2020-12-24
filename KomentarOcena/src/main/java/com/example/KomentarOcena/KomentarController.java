package com.example.KomentarOcena;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KomentarController {
	
	@GetMapping(value="testKomentar")
	public String TestKomentarController() {
		return "uspesno nalazenje servisa komentar !";
	}
}