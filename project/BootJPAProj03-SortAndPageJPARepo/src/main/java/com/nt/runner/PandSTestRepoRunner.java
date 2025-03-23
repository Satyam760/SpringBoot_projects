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
		// System.out.println(service.deleteDoctorsByIdsInBatch(List.of(5633,2)));

		/*try {
			Doctor doct= service.getDoctorById(52);
			System.out.println(doct==null?"doctor not found":doct);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		Doctor doctor = new Doctor();
		doctor.setDocName("rahul");
		doctor.setSpecialization("famous");
		List<Doctor>list=service.showDoctroByExampleData(doctor, true, "docName","income");
		list.forEach(System.out::println);
		
		/*try {
			Doctor doct1=new Doctor("sam","Artho",70000.00f);
			Doctor doct2=new Doctor("kiran","Sprcial",60000.00f);
			List<Doctor>list=List.of(doct1,doct2);
			String msg=service.groupDoctorRegistrations(list);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

	}

}
