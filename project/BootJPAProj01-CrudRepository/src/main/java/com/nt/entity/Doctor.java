package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
public class Doctor {
	@Column(name="DOC_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docId;
	@Column(name="DOC_NAME",length=25)
	private String docName;
	//@Transient   //using @Transient we can't perform store into dp table column values
	@Column(name="SPECIALIZATION",length = 25)
	private String specialization;
	@Column(name="INCOME")
	private Float income;
	
}
