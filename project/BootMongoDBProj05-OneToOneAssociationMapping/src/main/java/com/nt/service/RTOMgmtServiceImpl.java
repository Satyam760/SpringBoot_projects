package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docoment.DrivingLicense;
import com.nt.docoment.Person;
import com.nt.repository.IDrivingLicenseRepository;
import com.nt.repository.IPersonRepository;

@Service("rtoService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IDrivingLicenseRepository licecseRepo;

	@Override
	public String registerPersonWithDrivingLicense(Person per) {
		return "Person with Driving License is saved with id value :: "+personRepo.save(per).getPid();
	}

	@Override
	public String registerDrivingLicenseWithPerson(DrivingLicense license) {
		return "DrivingLicense with Person id saved with id value :: "+licecseRepo.save(license).getId();
	}

	@Override
	public List<Person> showAllPersonDetails() {
		
		return personRepo.findAll();
	}

	@Override
	public List<DrivingLicense> showAllLicenseDetails() {
		
		return licecseRepo.findAll();
	}

}
