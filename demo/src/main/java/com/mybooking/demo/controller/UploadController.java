package com.mybooking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybooking.demo.dto.upload.UploadRequestDTO;
import com.mybooking.demo.service.UploadService;

@RestController
@RequestMapping(value = "/partner/upload")
public class UploadController {

	@Autowired
	UploadService uploadService;

	@PutMapping
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<Boolean> addTheaterAndScreens(@RequestBody UploadRequestDTO uploadRequestDTO) {
		return new ResponseEntity<>(uploadService.uploadDetails(uploadRequestDTO), HttpStatus.OK);
	}

	@PostMapping
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<Boolean> updateTheaterAndScreens(@RequestBody UploadRequestDTO uploadRequestDTO) {
		return new ResponseEntity<>(uploadService.modifyDetails(uploadRequestDTO), HttpStatus.OK);
	}
	
	@DeleteMapping
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<Boolean> deleteTheaterAndScreens(@RequestBody UploadRequestDTO uploadRequestDTO) {
		return new ResponseEntity<>(uploadService.modifyDetails(uploadRequestDTO), HttpStatus.OK);
	}
}
