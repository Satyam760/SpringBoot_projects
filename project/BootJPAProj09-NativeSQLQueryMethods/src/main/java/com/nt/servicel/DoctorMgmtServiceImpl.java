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
	public String insertDoctor(String name, String specialization, double income) {
		int count =doctorRepo.registerDoctor(name, income, specialization);
		return count==0?"Doctor not registered":"Doctor is registered";
	}

	@Override
	public String showSystemDate() {
		return doctorRepo.showSystemDate();
	}

	@Override
	public String createTempDBTable() {
		int count=doctorRepo.createTempTable();
		return count==0?"DB table is created":"DB table is not created";
	}

	

	

	
		
}
