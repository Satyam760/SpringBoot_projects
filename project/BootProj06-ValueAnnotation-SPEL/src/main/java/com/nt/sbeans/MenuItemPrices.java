package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menup")
@Data
public class MenuItemPrices {

	@Value("${menu.dosarate}")
	private Double dosaPrice;
	@Value("${menu.idlrate}")
	private Double idlyPrice;
	@Value("${menu.poharate}")
	private Double pohaPrice;
	@Value("${menu.vprate}")
	private Double vadaPavPrice;
	
}
