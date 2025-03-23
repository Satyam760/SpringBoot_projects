package com.nt.servicel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public int appraiseDoctorsByIncomeRange(String specialization, double hikePercentage) {
		int count=doctorRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
		return count;
	}

	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		int count =doctorRepo.removeDoctorsByIncomeRange(start, end);
		return count;
	}

	

	
		
}
