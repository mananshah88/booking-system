package com.mybooking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybooking.demo.repository.nosql.FirstCollectionRepository;
import com.mybooking.demo.repository.rdbms.FirstTableRepository;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloWorldController {

	@Autowired
	FirstTableRepository ftr;
	
	@Autowired
	FirstCollectionRepository fcr;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<String> hello() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello World ");
		sb.append(ftr.findAll());
		sb.append(fcr.findAll());
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}

}
