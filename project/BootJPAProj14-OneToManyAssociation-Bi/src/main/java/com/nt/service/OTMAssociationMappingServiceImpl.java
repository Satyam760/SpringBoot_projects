package com.nt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepostitory;
import com.nt.repository.IPhoneNumberRepostitory;

@Service("OToMService")
public class OTMAssociationMappingServiceImpl implements IOTMAssociationMgmtSevice {

	@Autowired
	private IPersonRepostitory personRepo;
	@Autowired
	private IPhoneNumberRepostitory phoneRepo;
	
	@Override
	public void saveDataUsingParent() {
		//create parent obj
		Person per=new Person("raja","hyd");
		//create child obj
		PhoneNumber ph1=new PhoneNumber(999999999l,"airtel","personal");
		PhoneNumber ph2=new PhoneNumber(888888888l,"jio","official");
		
		//add parent to child
		ph1.setPerson(per); ph2.setPerson(per);
		
		//add child to parent
		Set<PhoneNumber>phoneSet=new HashSet();
		phoneSet.add(ph1); phoneSet.add(ph2);
		
		per.setContactDetails(phoneSet);
		
		//save the parent obj
		personRepo.save(per);
		System.out.println("Person and his Associated phoneNumber are saved(Parent to Child)");
		
	}

	@Override
	public void saveDataUsingChild() {
		//create parent obj
		Person per =new Person("satyam","delhi");
		//create child obj
				PhoneNumber ph1=new PhoneNumber(777777777l,"airtel","personal");
				PhoneNumber ph2=new PhoneNumber(666666666l,"vi","official");
				
				//add parent to child
				ph1.setPerson(per); ph2.setPerson(per);
				
				//add child to parent
				Set<PhoneNumber>phoneSet=new HashSet();
				phoneSet.add(ph1); phoneSet.add(ph2);
				
				per.setContactDetails(phoneSet);
				
				//save the parent obj
				phoneRepo.save(ph1); phoneRepo.save(ph2);
				System.out.println("Person and his Associated phoneNumber are saved(Child to Parent)");
				

	}

	@Override
	public void loadDataUsingParent() {
		Iterable<Person>it=personRepo.findAll();
		
		it.forEach(per->{
			System.out.println("parent :: "+per);
			//get child of each parent
			Set<PhoneNumber>child=per.getContactDetails();
			child.forEach(ph->{
				System.out.println("child :: "+ph.getMobileNo());
			});
			
		});
		
	}//method

}//class
