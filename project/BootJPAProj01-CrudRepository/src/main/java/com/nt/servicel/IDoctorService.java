package com.nt.servicel;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public long fetchDoctorCount();
	public boolean checkDoctorAvaibility(Integer id);
	public Iterable<Doctor>showAllDoctor();
	public Iterable<Doctor>showAllDoctorByIds(Iterable<Integer>ids);
	public Doctor showDoctorById(Integer ids);
	public String updateDoctorIncomeById(Integer id,float hikePercentage);
	public String updateOrRegisterDoctor(Doctor doctor);
	public String deleteDoctorById(Integer id);
	
	
	
}
