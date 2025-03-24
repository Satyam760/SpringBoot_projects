package com.nt.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.docoment.DrivingLicense;
import com.nt.docoment.Person;
import com.nt.service.IRTOMgmtService;


@Component
public class OneToOneAssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IRTOMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*//parent to child
		try {
			Person per=new Person("sam","vizag");
			DrivingLicense license=new DrivingLicense("4-wheeler",LocalDate.now());
			per.setLicenseDetails(license);
			System.out.println(service.registerPersonWithDrivingLicense(per));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*//child to parent
		try {
			Person per=new Person("kunu","delhi");
			DrivingLicense license=new DrivingLicense("2-wheeler",LocalDate.now());
			license.setPersonDetails(per);
			System.out.println(service.registerDrivingLicenseWithPerson(license));
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}*/
		
		System.out.println("===========Parent to Child===============");
		service.showAllPersonDetails().forEach(per->{
			System.out.println("Parent :: "+per);
			DrivingLicense license=per.getLicenseDetails();
			System.out.println("Child :: "+license);
		});
		
		System.out.println();
		
		System.out.println("===========Child to Parent===============");
		service.showAllLicenseDetails().forEach(per->{
			System.out.println("Parent :: "+per);
			Person license=per.getPersonDetails();
			System.out.println("Child :: "+license);
		});
		
		
	}
		
}
