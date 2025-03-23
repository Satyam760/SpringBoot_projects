package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IPatientRepository;

@Service("mtmService")
public class MToMManagementServiceImpl implements IMToMManagementService {
	
	@Autowired
	private IDoctorRepository docRepo;
	@Autowired
	private IPatientRepository patRepo;

	@Override
	public void saveDataUsingDoctor() {
		Doctor doc1=new Doctor("satyam","physican");
		Doctor doc2=new Doctor("kunu", "ortho");
		
		Patient patient1=new Patient("raja",24,"heart");
		Patient patient2=new Patient("ram",28,"leg");
		Patient patient3=new Patient("rajesh",20,"kidney");
		Patient patient4=new Patient("ramesh",34,"stomach");
		
		//add patient to doctor
		doc1.setPatient(List.of(patient1,patient2));
		doc2.setPatient(List.of(patient3,patient4));
		
		//add doctors to patient
		patient1.setDoctors(List.of(doc1));
		patient2.setDoctors(List.of(doc1));
		patient3.setDoctors(List.of(doc1,doc2));
		patient4.setDoctors(List.of(doc1));
		
		docRepo.saveAll(List.of(doc1,doc2));
		
		System.out.println("Doctors and their patients are saved");

	}

	@Override
	public void saveDataUsingPatient() {
		Doctor doc1=new Doctor("raman", "physican");
		Doctor doc2=new Doctor("hariOwm","cardio");
		
		Patient pat1=new Patient("sonu",45,"head");
		Patient pat2=new Patient("ramu",40,"hand");
		Patient pat3=new Patient("sami",47,"leg");
		Patient pat4=new Patient("tommy",41,"eye");
		
		//add patient to doctor
		List<Patient>doc1Patient=new ArrayList();
		doc1Patient.add(pat1); doc1Patient.add(pat2); doc1Patient.add(pat3);
		doc1.setPatient(doc1Patient);
		
		List<Patient>doc2Patient=new ArrayList();
		doc2Patient.add(pat3); doc2Patient.add(pat4); 
		doc1.setPatient(doc2Patient);
		
		//add doctor to patient
		List<Doctor>pat1Doctor=new ArrayList();
		pat1Doctor.add(doc1);
		pat1.setDoctors(pat1Doctor);
		
		List<Doctor>pat2Doctor=new ArrayList();
		pat2Doctor.add(doc1); pat2Doctor.add(doc2);
		pat2.setDoctors(pat2Doctor);
		
		List<Doctor>pat3Doctor=new ArrayList();
		pat3Doctor.add(doc1);
		pat3.setDoctors(pat3Doctor);
		
		List<Doctor>pat4Doctor=new ArrayList();
		pat4Doctor.add(doc2);
		pat4.setDoctors(pat4Doctor);
		
		patRepo.saveAll(List.of(pat1,pat2,pat3,pat4));
		System.out.println("Patient and their Doctor info is saved ");
		

	}

	@Override
	public void loadDataUsingDoctor() {
		List<Doctor>list=docRepo.findAll();
		list.forEach(doc->{
			System.out.println("Parent :: "+doc);
			//get parent of a doctor
			List<Patient>patient=doc.getPatient();
			patient.forEach(pat->{
				System.out.println("Child :: "+pat);
			});
			System.out.println("-------------------------------------------------------");
		});
		
	}

	@Override
	public void loadDataUsingPatient() {
		List<Patient>list=patRepo.findAll();
		list.forEach(pat->{
			System.out.println("Child :: "+pat);
			//get doctor of each patient
			List<Doctor>docor=pat.getDoctors();
			docor.forEach(doc->{
				System.out.println("Parent :: "+doc);
			});
			System.out.println("-------------------------------------------------------\n");
		});
		

	}

}
