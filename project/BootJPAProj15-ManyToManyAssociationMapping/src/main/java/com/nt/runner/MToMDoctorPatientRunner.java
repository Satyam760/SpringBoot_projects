package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMToMManagementService;

@Component
public class MToMDoctorPatientRunner implements CommandLineRunner {

	@Autowired
	private IMToMManagementService service;
	@Override
	public void run(String... args) throws Exception {
		//service.saveDataUsingDoctor();
		
		//service.saveDataUsingPatient();
		
		//service.loadDataUsingDoctor();
		
		service.loadDataUsingPatient();
		
	}

}
