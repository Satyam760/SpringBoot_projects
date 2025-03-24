package com.nt.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.entity.Numberobj;

@Service("numService")
public class CalculatorService {
	
	
	public Integer addNumber(@RequestBody Numberobj obj) {
		return  (obj.getNum1()+obj.getNum2());
	}
	

}
