package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;


@Component("hotel")
@Data
@ConfigurationProperties(prefix="org.hotel")
public class Hotel {
	
	private Integer hotelId;
	private String hotelName;
	private String hotelAddrs;
	private String mobileNo;
	private MenuItemPrices price;
	
}
