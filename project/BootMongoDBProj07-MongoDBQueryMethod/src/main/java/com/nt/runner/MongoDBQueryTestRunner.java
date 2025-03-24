package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.repository.IEmployeeRepository;

@Component
public class MongoDBQueryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*empRepo.getEmpDataByAddrs("jack").forEach(row->{
			for(Object val:row) {
				System.out.println(val+" ");
			}
			System.out.println();
		});;*/
		
		//empRepo.getEmpAllDataByAddrs("arn").forEach(System.out::println);
		//empRepo.getEmpAllDataByNameAndAddrs("satyam","arn").forEach(System.out::println);
		//empRepo.getEmpAllDataBySalaryRange(1000.0, 1000000.0).forEach(System.out::println);
		//empRepo.getEmpAllDataByAddresses("hyd","arn").forEach(System.out::println);
		
		/*empRepo.getEmpAllDataByEnameChars("S").forEach(System.out::println);
		empRepo.getEmpAllDataByEnameChars("^s").forEach(System.out::println);//starts with 's'
		empRepo.getEmpAllDataByEnameChars("m$").forEach(System.out::println);//ends with 'm'
		*/
		
		//System.out.println("Emps count having salary in range :: "+empRepo.getEmpAllDataCountBySalaryRange(1000.0, 100000.0));

		empRepo.getEmpAllDataBySortName().forEach(System.out::println);
		
		
		
		
	}

}
