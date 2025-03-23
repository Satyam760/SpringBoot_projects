package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
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
@Table(name="CUSTOMER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	@Nonnull
	@Column(length = 20)
	private String custName;
	@Nonnull
	@Column(length = 20)
	private String custAddrs;
	@Nonnull
	private LocalDateTime dob;
	@Nonnull
	private LocalTime top;
	@Nonnull
	private LocalDate dop;
	
	
}
