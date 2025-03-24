package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Numberobj;
import com.nt.service.CalculatorService;

@RestController
public class NumberController {
	
	@Autowired
	CalculatorService service;
	
	@PostMapping("/number")
	public int addNumber(@RequestBody Numberobj number) {
		
		int no = number.getNum1() + number.getNum2();
		return no;
		
	}
	
	@GetMapping("/number")
	public int addNumberGet(@RequestParam Integer num1,@RequestParam Integer num2) {
		
		return num1 + num2;
		
	}
	
	@GetMapping("/number1")
	public int addNumberGet(Numberobj obj) {
		
		return service.addNumber(obj);
		
	}

}
