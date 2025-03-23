package com.nt.servicel;

import java.util.Optional;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("docID(Before save::)"+doctor.getDocId());
		System.out.println("docID(Before save::)"+doctor);
		Doctor doc = doctorRepo.save(doctor);
		System.out.println("docID(After save::)"+doc);
		return "Doctor obj is saved with ID value ::"+doc.getDocId();
	}

	@Override
	public long fetchDoctorCount() {
		return doctorRepo.count();
	}

	@Override
	public boolean checkDoctorAvaibility(Integer id) {
		return doctorRepo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctor() {
		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	@Override
	public Doctor showDoctorById(Integer ids) {
		Optional<Doctor>opt=doctorRepo.findById(ids);
		if(opt.isPresent())
			return opt.get();
		else
		     throw new IllegalArgumentException("Invalid Doctor Id");
	}

	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		//load obj
		Optional<Doctor>opt = doctorRepo.findById(id);
		if(opt.isPresent()) {
			Doctor doc=opt.get();
			float newIncome=doc.getIncome()+(doc.getIncome()*(hikePercentage/100f));
			//set new income to obj
			doc.setIncome(newIncome);
			//partially update  the obj
			return doctorRepo.save(doc).getDocId()+" is updated with "+newIncome;
		}
		
		return id+"doctor not found";
	}

	@Override
	public String updateOrRegisterDoctor(Doctor doctor) {
		//load Doctor obj
		Optional<Doctor>opt=doctorRepo.findById(doctor.getDocId());
		if(opt.isPresent()) {
			doctorRepo.save(doctor);
			return doctor.getDocId()+" Doctor details are found and save";
		}
		else {
			return "Doctor is saved with id value :"+doctorRepo.save(doctor).getDocId();
		}
		
	}

	@Override
	public String deleteDoctorById(Integer id) {
		Optional<Doctor>opt=doctorRepo.findById(id);
		if(opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id + " Doctor is deleted";
		}
		else {
			return id +" Doctor id not found for deletion";
		}
	}
	
	
	
	
	

}
