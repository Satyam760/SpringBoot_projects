package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
public class MenuItemPrices {

	
	private Double dosaPrice;
	
	private Double idlyPrice;
	
	private Double pohaPrice;
	
	private Double vadaPavPrice;
	
}
