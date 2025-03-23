package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	public List<Doctor>findBydocNameEquals(String name);
	public List<Doctor>findBydocNameIs(String name);
	public List<Doctor>findBydocName(String name);
	public List<Doctor>findBydocNameStartingWith(String name);
	public List<Doctor>findBydocNameEndingWith(String name);
	public List<Doctor>findBydocNameContaining(String name);
	public List<Doctor>findBydocNameEqualsIgnoreCase(String name);
	public List<Doctor>findBydocNameContainingIgnoreCase(String name);
	public List<Doctor>findBydocNameLike(String name);
	
	//finder method with multiple properties based condtions
	public List<Doctor>findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
	public List<Doctor>findBySpecializationInOrIncomeBetween(List<String>specials,double startRange,double endRange);
	
}


