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
	public List<Doctor> showDoctorByIncomeRange(double startRange, double endRange) {
		
		return doctorRepo.searchDoctorsByIncomeRange(startRange, endRange);
	}

	@Override
	public List<Doctor> searchDoctorBySpecialization(String sp1, String sp2) {
		List<Doctor>list=doctorRepo.searchDoctoresBySpecialization(sp1, sp2);
		return list;
	}

	@Override
	public List<Object[]> searchDoctoresDataByIncome(double start, double end) {
		List<Object[]>list=doctorRepo.searchDoctoresDataByIncome(start, end);
		return list;
	}

	@Override
	public List<String> searchAllDoctoresNameByIncomeRange(double start, double end) {
		List<String>list=doctorRepo.searchAllDoctoresNameByIncomeRange(start, end);
		return list;
	}

	@Override
	public Doctor searchDoctorByNamedocName(String name) {
		Doctor doc=doctorRepo.showDoctorInfoByName(name);
		return doc;
	}

	@Override
	public Object searchDoctorDataByName(String name) {
		Object obj=doctorRepo.showDoctorDataByName(name);
		return obj;
	}

	@Override
	public String searchDoctorSpecializationByName(String name) {
		String result=doctorRepo.showDoctorSpecializationByName(name);
		return result;
	}

	@Override
	public int showDoctorNamesCount() {
		int count=doctorRepo.fetchDoctorNameCount();
		return count;
	}

	@Override
	public Object showDAggregateData() {
		Object obj=doctorRepo.fetchAggregateData();
		return obj;
	}

		
}
