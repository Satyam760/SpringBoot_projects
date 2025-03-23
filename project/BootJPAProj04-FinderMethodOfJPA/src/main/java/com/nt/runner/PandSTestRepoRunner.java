package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;

@Component
public class PandSTestRepoRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void run(String... args) throws Exception {
		//finder methods
				doctorRepo.findBydocNameEquals("ram").forEach(System.out::println);
				
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameIs("kunu").forEach(System.out::println);
				
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocName("satyamshoo").forEach(System.out::println);
		
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameStartingWith("r").forEach(System.out::println);
		
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameEndingWith("o").forEach(System.out::println);
				
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameContaining("a").forEach(System.out::println);
				
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameEqualsIgnoreCase("RAs").forEach(System.out::println);
		
				
				System.out.println("--------------------------------------------");
				doctorRepo.findBydocNameContainingIgnoreCase("s").forEach(System.out::println);
		
				
		System.out.println("--------------------------------------------");
		doctorRepo.findBydocNameLike("%o").forEach(System.out::println);
		System.out.println("--------------------------------------------");
		doctorRepo.findBydocNameLike("%a%").forEach(System.out::println);
		System.out.println("--------------------------------------------");
		doctorRepo.findBydocNameLike("______").forEach(System.out::println);
		System.out.println("--------------------------------------------");
		doctorRepo.findBydocNameLike("r%").forEach(System.out::println);
		
		System.out.println("--------------------------------------------");
		doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual
		        (100000,1000000).forEach(System.out::println);

		System.out.println("--------------------------------------------");
		doctorRepo.findBySpecializationInOrIncomeBetween
		        (List.of("Cardio","MD-Artho"),1000000,1000000).forEach(System.out::println);

		
		
	}

}
