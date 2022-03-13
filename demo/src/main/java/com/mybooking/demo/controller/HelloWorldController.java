package com.mybooking.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloWorldController {

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!!", HttpStatus.OK);
	}

//	@PutMapping
//	@ResponseBody
//	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
//	public ResponseEntity<Boolean> addTheaterAndScreens(@RequestBody UploadRequestDTO uploadRequestDTO) {
//		return new ResponseEntity<>(uploadService.uploadDetails(uploadRequestDTO), HttpStatus.OK);
//	}

}
