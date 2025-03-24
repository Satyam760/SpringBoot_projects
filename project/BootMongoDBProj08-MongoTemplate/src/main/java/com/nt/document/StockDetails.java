package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "StockDetails_Info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockDetails {
	@Id
	private Integer stockId;
	private String stockName;
	private Double price;
	private String exchangeName;
	
}
