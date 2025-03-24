package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("hotel")
public class Hotel {
	
	@Value("12345")
	private Integer hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.addrs}")
	private String hotelAddrs;
	@Value("${hotel.contact}")
	private String mobileNo;
	
	@Value("${customer.name}")
	private String custName;
	@Value("#{menup.dosaPrice+menup.pohaPrice}")  //spel for arithmetic operation
	private Double billAmount;
	
	@Value("${os.name}")
	private String osName;
	@Value("${user.name}")
	private String windowUser;
	
	@Value("${Path}")
	private String pathData;

	@Override
	public String toString() {
		return "Hotel::\n hotelId=" + hotelId + ",\n hotelName=" + hotelName + ",\n hotelAddrs=" + hotelAddrs + ",\n mobileNo="
				+ mobileNo + ", \ncustName=" + custName + ",\n billAmount=" + billAmount + ",\n osName=" + osName
				+ ",\n windowUser=" + windowUser + ",\n pathData=" + pathData ;
	}
	
}
