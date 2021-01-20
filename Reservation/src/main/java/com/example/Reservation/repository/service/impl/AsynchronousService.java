package com.example.Reservation.repository.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;

import com.example.Reservation.model.CommonData;
import com.example.Reservation.model.Rezervacija;
import com.example.Reservation.repository.CommonDataRepository;
import com.example.Reservation.repository.RezervacijaRepository;
import com.example.Reservation.repository.service.RezervacijaService;

@Service
public class AsynchronousService {

	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private TaskScheduler taskScheduler;
	@Autowired
	private CommonDataRepository cmdRep;
	@Autowired
	private RezervacijaRepository rRep;
	
	public void proveraPlacanja(Long rezId) {
		Rezervacija r=rRep.findById(rezId).orElse(null);
		if(r!=null) {
			System.out.println("\\nStatus rezervacije sa id= "+rezId+" je "+r.getStatusRezervacije());
			if(r.getStatusRezervacije().toLowerCase().equals("reserved")) {
				//kreiraj rok za placanje 12h (60 sekundi)
				System.out.println("Kreiranje provere placanja za rezervaciju sa id= "+rezId+". Vreme :"+LocalDateTime.now());
				taskScheduler.schedule(new Runnable() {
					@Override
					public void run() {		
						System.out.println("\\nIzvrsenje provere placanja za rezervaciju sa id= "+rezId+". Vreme :"+LocalDateTime.now());
						Rezervacija r=rRep.findById(rezId).orElse(null);
						if(r.getStatusRezervacije().toLowerCase().equals("reserved")) {
							//Status i dalje reserved, otkazi rezervaciju
							r.setStatusRezervacije("CANCELED");
							
							CommonData c=cmdRep.findById(r.getCommonDataId()).orElse(null);
							if(c!=null) {
								c.setDatumIzmene(LocalDateTime.now());
								c=cmdRep.save(c);
								r.setCommonDataId(c.getId());
							}else {
								System.out.println("Za rezervaciju sa id= "+rezId+" nije pronadjen commonData");
							}
							r=rRep.save(r);
							System.out.println("Rezervacija sa id= "+rezId+" nije placena u roku, status promenjene u "+r.getStatusRezervacije());
						}else System.out.println("Rezervacija sa id= "+rezId+" je placena ili otkazana, njen trenutni status je :" +r.getStatusRezervacije());
					}
				}, new Date(System.currentTimeMillis()+1000*60));
			}
		}else System.out.println("Rezervacija sa id= "+rezId+" nije preuzeta/pronadjena u bazi");		
	}
	//ako rezervacija nije obradjena od strane agenta u roku od 24h autmoatski je otkazi
	public void proveraObrade(Long rezId) {
		Rezervacija r=rRep.findById(rezId).orElse(null);
		if(r!=null) {
			System.out.println("Kreiranje provere obrade za rezervaciju sa id= "+rezId+". Vreme :"+LocalDateTime.now());
			taskScheduler.schedule(new Runnable() {

				@Override
				public void run() {
					System.out.println("\\nIzvrsenje provere placanja za rezervaciju sa id= "+rezId+". Vreme :"+LocalDateTime.now());
					Rezervacija r=rRep.findById(rezId).orElse(null);
					if(r.getStatusRezervacije().toLowerCase().equals("pending")) {
						//rezervacija nije obradjena, otkazi je
						r.setStatusRezervacije("CANCELED");
						CommonData c=cmdRep.findById(r.getCommonDataId()).orElse(null);
						if(c!=null) {
							c.setDatumIzmene(LocalDateTime.now());
							c=cmdRep.save(c);
							r.setCommonDataId(c.getId());
						}else {
							System.out.println("Za rezervaciju sa id= "+rezId+" nije pronadjen commonData");
						}
						r=rRep.save(r);
						System.out.println("Rezervacija sa id= "+rezId+" nije obradjena u roku, status promenjen u "+r.getStatusRezervacije());

					}else System.out.println("Rezervacija sa id= "+rezId+" je obradjena, njen trenutni status je :" +r.getStatusRezervacije());
	
				}	
			}, new Date(System.currentTimeMillis()+1000*60*2));

		}else System.out.println("Rezervacija sa id= "+rezId+" nije preuzeta/pronadjena u bazi");		
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    return new ConcurrentTaskScheduler(); //single threaded by default
	}
}
   
