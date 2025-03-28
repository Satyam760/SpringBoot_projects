package com.nt.entity;

import java.io.Serializable;
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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTM_PATIENT")
@Setter
@Getter
@RequiredArgsConstructor
public class Patient implements Serializable{
	@Id
	@SequenceGenerator(name="gen1",sequenceName="pid_mtm_seq",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	private Integer age;
	@NonNull
	@Column(length = 20)
	private String problem;
	@ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "JPA_MTM_DOCTOR_PATIENT",joinColumns=@JoinColumn(name="patient_id",referencedColumnName="pid"),
	  inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName = "did"))
	private List<Doctor>doctors;
	
	public Patient() {
		System.out.println("Patient.Patient()");
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", age=" + age + ", problem=" + problem + "]";
	}
	
	
	
}
