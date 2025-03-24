package com.nt.docoment;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection = "DrivingLicenses_Info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class DrivingLicense {
	@Id
	private String id;
	@NonNull
	private String type;
	@NonNull
	private LocalDate expiryTime;
	private Person personDetails;
	
	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", type=" + type + ", expiryTime=" + expiryTime + "]";
	}
	
}
