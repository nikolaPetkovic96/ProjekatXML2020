package com.example.KomentarOcena;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcenaController {
	@GetMapping(value="/testOcena")
	public String TestOcenController() {
		return "uspesno nalazenje servisa Ocene";
	}
}
