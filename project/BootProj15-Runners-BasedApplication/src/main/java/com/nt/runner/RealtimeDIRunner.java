package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@Component
public class RealtimeDIRunner implements CommandLineRunner {
	
	@Autowired
	private PayrollOperationController controller;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("RealtimeDIRunner.run()");
		try {
			//invoke the b.logic on controller class
			List<Employee> list=controller.showEmployeeByDesgs("MANAGER","CLEARK","SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
