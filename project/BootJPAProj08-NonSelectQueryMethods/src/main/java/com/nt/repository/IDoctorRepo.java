package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;


public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	
	@Query("UPDATE Doctor SET income=income+(income*:percentage/100.0) WHERE specialization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpecialization(String sp,double percentage);    
    
	@Query("DELETE FROM Doctor Where income>=:start AND income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorsByIncomeRange(double start,double end);    
    

}


