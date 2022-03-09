package com.mybooking.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybooking.demo.dto.partner.PartnerDetailsForAdminDTO;
import com.mybooking.demo.dto.partner.TheaterRequestDto;
import com.mybooking.demo.service.PartnerService;

@RestController
@RequestMapping(value = "/partner")
public class PartnerController {

	@Autowired
	PartnerService partnerService;

	/* Partner can view its theater-screen details */
	@GetMapping("/{partnerId}/theater")
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<?> getTheaterDetails(@PathVariable Integer partnerId) {
		return ResponseEntity.ok().body(partnerService.getTheaterDetails(partnerId));
	}
	
	/* Partner can add a new theater/screen */
	@PutMapping("/{partnerId}/theater")
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<Boolean> addTheaterAndScreens(@PathVariable Integer partnerId,
			@Valid @RequestBody TheaterRequestDto theaterScreenRequestDto) {
		return new ResponseEntity<>(partnerService.addTheaterAndScreens(partnerId, theaterScreenRequestDto),
				HttpStatus.OK);
	}

	/* Partner can update a existing theater/screen details */
	@PostMapping("/{partnerId}/theater")
	@ResponseBody
	// @PreAuthorize("@currentUserServiceImpl.isTheSamePartner(#partnerId)")
	public ResponseEntity<Boolean> updateTheaterAndScreens(@PathVariable Integer partnerId,
			@Valid @RequestBody TheaterRequestDto theaterRequestDto) {
		return new ResponseEntity<>(partnerService.updateTheaterAndScreens(partnerId, theaterRequestDto),
				HttpStatus.OK);
	}
	
	
	/*
	 * As an Admin of the mybooking.com, he can get all the lists of Partners which
	 * are on boarded on the platform
	 * 
	 */
	@GetMapping("/all")
	@ResponseBody
	// Assuming if token/JsessionId is invalid then it will be discard by the security framework in pre-filters... 
	// RBAC:: Spring Security(spring-boot-starter-security dependency + @PreAuthorize annotation  
    // @PreAuthorize("@currentUserServiceImpl.isAdmin()")
	public ResponseEntity<List<PartnerDetailsForAdminDTO>> listAllPartners() {
		return new ResponseEntity<>(partnerService.getAllPartners(), HttpStatus.OK);
	}
}
