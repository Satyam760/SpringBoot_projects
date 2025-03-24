package com.nt.runner;

import java.util.List;

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
		/*try {
			Employee emp=new Employee(1001, "jack", "delhi", 1234.56,true);
			System.out.println(service.saveEmployee(emp));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Employee emp=new Employee(1002, "ram", "hyd", 123456.56,false);
			Employee emp1=new Employee();
			emp1.setEno(1003);emp1.setEname("satyam");emp1.setEaddrs("arn");
			service.saveAllEmployee(List.of(emp,emp1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//get all Employee Documents
		//service.showAllEmployee().forEach(System.out::println);
		
		//System.out.println(service.showEmployeeById("64e59bc15f0deb609843fa61"));
		
		service.showAllEmployees(true,"ename","eaddrs").forEach(System.out::println); 
		                                               //true=asending and false=descending order
		
		
		
		
	}

}
