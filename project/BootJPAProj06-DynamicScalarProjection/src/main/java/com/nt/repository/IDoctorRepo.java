package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;
import com.nt.view.ResultView;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	public <T extends ResultView>Iterable<T> findByIncomeBetween(double start,double end,Class<T>classs);
	
}


