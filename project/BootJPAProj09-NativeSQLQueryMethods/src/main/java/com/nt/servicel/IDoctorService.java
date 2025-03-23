package com.nt.servicel;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public String insertDoctor(String name,String specialization,double income);
	public String showSystemDate();
	public String createTempDBTable();
	
}
