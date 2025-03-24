package com.nt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "Employee_Info_USERID")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
	
	@Id
	private Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private String eaddrs;
	@NonNull
	private Double salary;
	@NonNull
	private Boolean isVaccinated;
	
	
}
