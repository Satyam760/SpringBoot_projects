package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.servicel.IDoctorService;

@Component
public class PandSTestRepoRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*service.showDoctorBySorting(true,"docName","income").forEach(System.out::println);
		System.out.println("\n-----------------------------------------------------------\n");
		service.showDoctorBySorting(true,"docName").forEach(System.out::println);
		*/
		
		/*System.out.println("----------------------Find All Page --------------------");
		try {
			//service.showDoctorInfoByPage(0,4, false, "specialization");
			Page<Doctor>page=service.showDoctorInfoByPage(0, 3, true, "docName");
			System.out.println("page Number :: "+page.getNumber());
			System.out.println("page count :: "+page.getTotalPages());
			System.out.println("Is it first Page :: "+page.isFirst());
			System.out.println("Is it last Page :: "+page.isLast());
			System.out.println("Page size :: "+page.getSize());
			System.out.println("page Element count :: "+page.getNumberOfElements());
				if(	!page.isEmpty()) {	
				List<Doctor>list=page.getContent();
					list.forEach(System.out::println);
				}
				else {
				System.out.println("no page found");
				}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		service.showDataThroughPagination(3);
		
		
		
		
		
	}

}
