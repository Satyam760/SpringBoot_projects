package com.nt.servicel;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public List<Doctor>showDoctorByIncomeRange(double startRange,double endRange);
	public List<Doctor>searchDoctorBySpecialization(String sp1,String sp2);
	public List<Object[]>searchDoctoresDataByIncome(double start,double end);
	public List<String>searchAllDoctoresNameByIncomeRange(double start,double end);
	
	public Doctor searchDoctorByNamedocName(String name);
	public Object searchDoctorDataByName(String name);
	public String searchDoctorSpecializationByName(String name);
	
	public int showDoctorNamesCount();
	public Object showDAggregateData();
	
}
