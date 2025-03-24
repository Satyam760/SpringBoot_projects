package com.nt.runner;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		 Employee emp=new Employee(UUID.randomUUID().toString(),new Random().nextInt(100000), "ramu","delhi",54565.54, true);
	     System.out.println(service.saveEmployee(emp));
		
		
		
	}

	

}
