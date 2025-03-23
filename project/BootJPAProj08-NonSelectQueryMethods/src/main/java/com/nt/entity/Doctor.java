package com.nt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Doctor {
	
	public Doctor() {
		System.out.println("Doctor:0-param constructor ::+p"+this.getClass());
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docId;
	
	@Nonnull
	private String docName;
	@Nonnull
	private String specialization;
	@Nonnull
	private Float income;
	
}
