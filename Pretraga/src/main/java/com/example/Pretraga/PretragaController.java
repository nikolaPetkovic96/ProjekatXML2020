package com.example.Pretraga;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
public class PretragaController {
	/*@GetMapping(value="/testPretraga")
	public String testPretraga() {
		return "uspesno nalazenje servisa pretrage!";
	}*/
	
	@RequestMapping(method=RequestMethod.GET, value="/pretraga", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<AutomobilPretragaDTO>> Pretraga(@RequestParam(value="br_sedista_za_decu") int br_sedista_za_decu,
													@RequestParam(value="col_dmg_waiver") boolean cool_dmg_waiver, 
													@RequestParam(value="predj_km") int predj_km,
													@RequestParam(value="plan_km") int plan_km,
													@RequestParam(value="model") String model,
													@RequestParam(value="marka") String marka,
													@RequestParam(value="klasa") String klasa,
													@RequestParam(value="gorivo") String gorivo,
													@RequestParam(value="menjac") String menjac
											
			) {
			return new ResponseEntity<>(new ArrayList<AutomobilPretragaDTO>(),HttpStatus.OK);
	}
}
