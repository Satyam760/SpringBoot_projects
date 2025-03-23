package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="CALLER_TUNE_INFO")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class CallerTuneInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneId;
	
	@Nonnull
	@Column(length = 20)
	private String tuneName;
	
	@Nonnull
	@Column(length = 20)
	private String movieName;

	@Version
	@Column(name="UPDATE_COUNT")
	private Integer updatedCount;
	
	@CreationTimestamp
	@Column(name="SERVICE_OPTED_ON")
	private LocalDateTime serviceOptedOn;
	
	@UpdateTimestamp
	@Column(name="LASTLY_UPDATED_ON")
	private LocalDateTime lastlyUpdatedOn;
	
	
	
}
