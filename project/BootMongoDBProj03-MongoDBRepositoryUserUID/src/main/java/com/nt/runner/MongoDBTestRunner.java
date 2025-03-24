package com.nt.runner;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
		/*//create Employee obj
		Employee emp =new Employee(new Random().nextInt(1000000),"hari","hyd",5678.99, true);
		System.out.println(service.saveEmployee(emp));*/
		
		
		/*Optional<Employee>opt=service.showEmployeeById(103187);
		if(opt.isPresent()) {
			System.out.println("Employee details :: "+opt.get());
		}
		else {
			System.out.println("Employee not found");
		}*/
		
		service.searchEmployeeBySalaryRange(2000,10000).forEach(System.out::println);
		
		System.out.println(service.searchEmployeeByName("hari"));
		
	}

}
