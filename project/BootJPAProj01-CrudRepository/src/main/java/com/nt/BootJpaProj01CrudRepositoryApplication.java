package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.servicel.IDoctorService;

@SpringBootApplication
public class BootJpaProj01CrudRepositoryApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootJpaProj01CrudRepositoryApplication.class, args);
		
		//get service class obj
		IDoctorService service = ctx.getBean("doctorService",IDoctorService.class);
		
		try {
			//create Doctor class obj
			Doctor doctor = new Doctor();
			doctor.setDocName("kunu");
			doctor.setSpecialization("MD-Special");
			doctor.setIncome(90000.00f);
			
			//invoke the b.method
			String result=service.registerDoctor(doctor);
			System.out.println(result);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//count() 
		try {
			System.out.println();
			System.out.println("Count Recoreds are ::"+service.fetchDoctorCount());
			System.out.println();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/*//exictById() method
		try {
			System.out.println("Doctor Id is available ::"+service.checkDoctorAvaibility(200));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//findAll() method
		/*try {
			Iterable<Doctor>it=service.showAllDoctor();
			//java 8-forEach
			it.forEach(doc->{
				System.out.println(doc);
				});
		System.out.println("----------------------------------------");	
		//java 8-advance forEach
		it.forEach(doc->System.out.println(doc));
		System.out.println("----------------------------------------");
		//java 8-forEach static method
		it.forEach(System.out::println);
		System.out.println("-----------------------------------------");
		//java 5-advance for loop
		    for(Doctor doc:it) {
			    System.out.println(doc);
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//findAllById method 
		/*try {
			service.showAllDoctorByIds(List.of(1,2,102,152,153)).forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//fingById() method
		/*try {
			System.out.println(service.showDoctorById(102));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//update by id
		/*try {
			System.out.println("doctor Info :: "+service.showDoctorById(152));
			System.out.println(service.updateDoctorIncomeById(152, 10.0f));
			System.out.println("doctor Info :: "+service.showDoctorById(152));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//update or insert new id
		/*try {
			Doctor doc=new Doctor();
			doc.setDocId(1);
			doc.setDocName("Rahul");
			doc.setIncome((float) 55000.00);
			doc.setSpecialization("Cardio");
			System.out.println(service.updateOrRegisterDoctor(doc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*//deleteById() method
		try {
			System.out.println(service.deleteDoctorById(10));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		
		
		
		
		
		//close IOC container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
