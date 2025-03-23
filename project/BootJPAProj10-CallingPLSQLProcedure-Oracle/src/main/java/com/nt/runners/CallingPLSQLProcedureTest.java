package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorManagementService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {

	@Autowired
	private IDoctorManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
	
		//invoke the b.method
		service.showDoctorByIncomeRange(50000,100000).forEach(System.out::println);

	}

}
