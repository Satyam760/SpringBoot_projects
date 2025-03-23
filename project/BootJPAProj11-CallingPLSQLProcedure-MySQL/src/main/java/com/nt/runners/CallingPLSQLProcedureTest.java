package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeManagementService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {

	@Autowired
	private IEmployeeManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
	
		//invoke the b.method
		service.showEmployeeBySalaryRange(5000,20000).forEach(System.out::println);

	}

}
