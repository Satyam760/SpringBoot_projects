package com.nt.service;

import java.util.List;

import com.nt.docoment.DrivingLicense;
import com.nt.docoment.Person;

public interface IRTOMgmtService {
	
	public String registerPersonWithDrivingLicense(Person per);
	public String registerDrivingLicenseWithPerson(DrivingLicense license);
	public List<Person>showAllPersonDetails();
	public List<DrivingLicense>showAllLicenseDetails();
	
	
}
