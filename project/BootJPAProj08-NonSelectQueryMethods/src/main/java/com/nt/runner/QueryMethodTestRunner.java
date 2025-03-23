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
		
//		int result=service.appraiseDoctorsByIncomeRange("Cardio", 10);
//		System.out.println("no.of records that are effected :: "+result);
		
		
		int result=service.fireDoctorsByIncomeRange(100000, 500000);
		System.out.println("delete doctors count :: "+result);
	}

}
