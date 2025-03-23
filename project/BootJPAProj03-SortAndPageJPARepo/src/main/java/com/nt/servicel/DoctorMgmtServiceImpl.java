package com.nt.servicel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		//load the entities class
		List<Doctor>list=doctorRepo.findAllById(ids);
		doctorRepo.deleteAllByIdInBatch(ids);
		
		return list.size()+" no.of recoreds are deleted";
	}

	@Override
	public Doctor getDoctorById(int id) {
		//Doctor doctor=doctorRepo.getById(id);  //deprecated
		//Doctor doctor=doctorRepo.getOne(id);   //deprecated
		Doctor doctor=doctorRepo.getReferenceById(id);  //new method
		
		return doctor;
	}

	@Override
	public List<Doctor> showDoctroByExampleData(Doctor doctor, boolean ascOrder, String... args) {
		//prepare the sort obj
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,args);
		//Example obj
		Example example=Example.of(doctor);
		//use the repo
		List<Doctor>list=doctorRepo.findAll(example,sort);
		//return the collection
		return list;
	}

	@Override
	public String groupDoctorRegistrations(List<Doctor> list) {
		doctorRepo.saveAllAndFlush(list);
		return list.size()+" no.of records are saved";
	}
	
}
