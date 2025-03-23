package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTM_DOCTOR")
@Setter
@Getter
@RequiredArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer did;
	@NonNull
	@Column(length = 20)
	private String dname;
	@NonNull
	@Column(length = 20)
	private String specialization;
	
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "JPA_MTM_DOCTOR_PATIENT",joinColumns=@JoinColumn(name="doctor_id",referencedColumnName="did"),
	  inverseJoinColumns=@JoinColumn(name="patient_id",referencedColumnName = "pid"))
	private List<Patient> patient;
	
	public Doctor() {
		System.out.println("Doctor.Doctor()");
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", specialization=" + specialization + "]";
	}
	
}
