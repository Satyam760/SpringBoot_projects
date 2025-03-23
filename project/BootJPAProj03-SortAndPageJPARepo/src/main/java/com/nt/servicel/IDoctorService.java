package com.nt.servicel;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public String deleteDoctorsByIdsInBatch(List<Integer>ids);
	public Doctor getDoctorById(int id);
	public List<Doctor>showDoctroByExampleData(Doctor doctor,boolean ascOrder,String...args);
	public String groupDoctorRegistrations(List<Doctor>list);
	
	
}
