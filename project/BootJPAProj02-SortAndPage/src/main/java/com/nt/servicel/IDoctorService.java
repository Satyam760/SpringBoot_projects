package com.nt.servicel;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public Iterable<Doctor>showDoctorBySorting(boolean asc,String... args);
	public Page<Doctor>showDoctorInfoByPage(int pageNO,int pageSize,boolean asc,String...arg);
	public void showDataThroughPagination(int pageSize);
	
	
}
