package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PERSON")
@Setter
@Getter
@RequiredArgsConstructor

public class Person implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	@Column(length = 20)
	private String paddrs;
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="person")
	private Set<PhoneNumber>contactDetails;

	public Person() {
		System.out.println("Person.Person()");
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	
	
	
	
}
