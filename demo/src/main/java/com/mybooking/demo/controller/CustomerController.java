package com.mybooking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybooking.demo.dto.customer.ChangePasswordRequestDTO;
import com.mybooking.demo.dto.customer.CustomerProfileRequestDto;
import com.mybooking.demo.dto.customer.CustomerProfileResponseDto;
import com.mybooking.demo.dto.customer.SignupRequestDTO;
import com.mybooking.demo.dto.customer.SocialSignupRequestDTO;
import com.mybooking.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/*
	 * Any customer(s) wants to sign-up to the platform then they can register
	 * themselves by this API. 
	 * Assumption: Partner is also one type of customer of the platform. 
	 * (Reason: Partner can also buy/book the ticket as a normal Customer.)
	 */
	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<Boolean> doSignUp(@RequestBody SignupRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.signUp(signUpRequestDTO), HttpStatus.OK);
	}

	/* Purpose is same as above. 
	 * But the difference is Authentication by social-media. 
	 * */
	@PostMapping("/socialmedia/signup")
	@ResponseBody
	public ResponseEntity<Boolean> doSocialSignUp(@RequestBody SocialSignupRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.socialSignUp(signUpRequestDTO), HttpStatus.OK);
	}

	/*
	 * Any User can click on "forget password" to get an email/otp notification by
	 * which he/she can set the new password.
	 */
	@GetMapping("/forgetPassword")
	@ResponseBody
	public ResponseEntity<Boolean> doForgetPassword(@RequestParam(required = true) String email) {
		return new ResponseEntity<>(customerService.forgetPassword(email), HttpStatus.OK);
	}

	/* Any User can set the new password */
	@PostMapping("/changePassword")
	@ResponseBody
	public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.changePassword(signUpRequestDTO), HttpStatus.OK);
	}
	
	/* Any Customer can view his/her profile details */
	@GetMapping("/profile")
	@ResponseBody
	public ResponseEntity<CustomerProfileResponseDto> getProfileDetails() {
		return new ResponseEntity<>(customerService.getProfileDetails(), HttpStatus.OK);
	}
	
	/* Any Customer can modify his/her profile details */
	@PostMapping("/profile")
	@ResponseBody
	public ResponseEntity<Boolean> modifyProfileDetails(CustomerProfileRequestDto customerProfileRequestDto) {
		return new ResponseEntity<>(customerService.modifyProfileDetails(customerProfileRequestDto), HttpStatus.OK);
	}
}
