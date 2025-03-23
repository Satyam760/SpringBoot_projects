package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	/*//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=? AND doc.income<=?")//-->Throws the IllegalArgumentException
	public List<Doctor>searchDoctorsByIncomeRange(double start,double end);
	*/
	
	/*@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor>searchDoctorsByIncomeRange
	          (@Param("start")double startRange,@Param("end")double endRange);
	*/
	
	@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor>searchDoctorsByIncomeRange(double start,double end);
	
	//select     Entity Query(Doctor) 
	@Query("From Doctor WHERE specialization IN(:sp1,:sp2)ORDER BY specialization")
	public List<Doctor>searchDoctoresBySpecialization(String sp1,String sp2);
	
	//select    Projection Query with specific multiple column value(like [])
	@Query("SELECT docId,docName,income,specialization FROM Doctor WHERE  income between :start and :end")
	public List<Object[]>searchDoctoresDataByIncome(double start,double end);
	
	//select    Projection Query with specific single column value
	@Query("SELECT docName FROM Doctor WHERE  income between :start and :end")
	public List<String>searchAllDoctoresNameByIncomeRange(double start,double end);
		 
	
	
	//These all method having only one record if 2 is found in DB table exception is rise
	//entity query having single record
	@Query("FROM Doctor WHERE docName=:name")
	public Doctor showDoctorInfoByName(String name);
	//scalar query having single record with multiple column value
    @Query("SELECT docId,docName FROM Doctor WHERE docName=:name")
	public Object showDoctorDataByName(String name);
  //scalar query having single record with single column value
    @Query("SELECT specialization FROM Doctor WHERE docName=:name")
	public String showDoctorSpecializationByName(String name);
	
	
	@Query("SELECT count(distinct docName)FROM Doctor")
    public int fetchDoctorNameCount();
	@Query("SELECT count(*),max(income),min(income),avg(income),sum(income) FROM Doctor")
    public Object fetchAggregateData();
    
    
	

}


