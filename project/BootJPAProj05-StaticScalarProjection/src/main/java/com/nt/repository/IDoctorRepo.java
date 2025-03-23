package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;
import com.nt.view.ResultView;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	public Iterable<ResultView> findBySpecializationIn(List<String>specials);
	
}


