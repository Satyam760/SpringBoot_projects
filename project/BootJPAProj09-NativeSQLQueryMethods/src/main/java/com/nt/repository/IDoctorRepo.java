package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;


public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	
	@Query(value="INSERT INTO JPA_DOCTOR_INFO(DOC_ID,DOC_NAME,INCOME,SPECIALIZATION) VALUES(JPA_DOCTOR_INFO_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery = true)
	@Modifying
	@Transactional
	public int registerDoctor(String name,double income,String special);    
    
	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery = true)
	public String showSystemDate();  
	
	@Query(value="CREATE TABLE TEMP(col1 number(5))",nativeQuery = true)
    @Modifying
    @Transactional
    public int createTempTable();

}


