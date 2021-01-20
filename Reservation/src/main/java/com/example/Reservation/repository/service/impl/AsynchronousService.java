//package com.example.Reservation.repository.service.impl;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.stereotype.Service;
//
//import com.example.Reservation.model.Rezervacija;
//import com.example.Reservation.repository.RezervacijaRepository;
//import com.example.Reservation.repository.service.RezervacijaService;
//
//@Service
//public class AsynchronousService {
//
//	@Autowired
//	private ApplicationContext appContext;
//	@Autowired
//	private TaskScheduler taskScheduler;
//	@Autowired
//	private RezervacijaService rServ;
//	@Autowired
//	private RezervacijaRepository rRep;
//	
//	public void executeAsync(Long rezId) {
//		System.out.println("Zadatak kreiran "+LocalDateTime.now());
//
//
//		taskScheduler.schedule(new Runnable() {
//			
//			@Override
//			public void run() {
//
//				Rezervacija r=rRep.findById(rezId).orElse(null);
//				if(r!=null) {
//					System.out.println(r.getStatusRezervacije());
//				}else System.out.println("Rezervacija nije preuzeta");
//				System.out.println("Zadatak izvrsen "+LocalDateTime.now());
//				
//			}
//		}, new Date(System.currentTimeMillis()+1000*5));
//	}
//}
