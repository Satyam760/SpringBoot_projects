package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.servicel.IDoctorService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("______________Natice SQL Queries________________________");
		System.out.println(service.insertDoctor("jani", "Cardio", 240000.0));
		
		System.out.println("System date and time :: "+service.showSystemDate());
		
		System.out.println(service.createTempDBTable());
		
	}

}
