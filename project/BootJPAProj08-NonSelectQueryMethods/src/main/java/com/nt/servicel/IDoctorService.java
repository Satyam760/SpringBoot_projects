package com.nt.servicel;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public int appraiseDoctorsByIncomeRange(String specialization,double hikePercentage);
	public int fireDoctorsByIncomeRange(double start,double end);
}
