package com.nt.servicel;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... args) {
		//prepare the sort obj
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,args);
		//use repo
		Iterable<Doctor>it=doctorRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctorInfoByPage(int pageNO, int pageSize, boolean asc, String... arg) {
		//prepare the sort obj
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, arg);
		//prepare Pageable obj
		Pageable pageable =PageRequest.of(pageNO,pageSize,sort);
		//use the repo
		Page<Doctor>page= doctorRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDataThroughPagination(int pageSize) {
		//decide the no.of pages
		long count= doctorRepo.count();
		long pageCount = count/pageSize;
		if(count%pageCount!=0)
			pageCount++;
		
		for(int i=0;i<pageCount;++i) {
			//create pageable obg
			Pageable pageable =PageRequest.of(i,pageSize);
			//get each page recorde
			Page<Doctor>page=doctorRepo.findAll(pageable);
			System.out.println("page :: "+(page.getNumber()+1)+" records of "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			System.out.println("_____________________________________________");
			
		}
		
	}

	
	
	
}
