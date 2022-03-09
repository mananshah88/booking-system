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

import com.mybooking.demo.dto.account.ChangePasswordRequestDTO;
import com.mybooking.demo.dto.account.SignupRequestDTO;
import com.mybooking.demo.dto.account.SocialSignupRequestDTO;
import com.mybooking.demo.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/*
	 * Scenario: Any customer(s) wants to sign-up to the platform then they can
	 * register themselves by this API. Assumption: Partner is also a customer of
	 * the platform. (Reason: Partner can also book the ticket as a normal Customer.
	 * 
	 */
	@PostMapping("/signup")
	@ResponseBody
	public ResponseEntity<Boolean> doSignUp(@RequestBody SignupRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.signUp(signUpRequestDTO), HttpStatus.OK);
	}

	@PostMapping("/socialmedia/signup")
	@ResponseBody
	public ResponseEntity<Boolean> doSocialSignUp(@RequestBody SocialSignupRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.socialSignUp(signUpRequestDTO), HttpStatus.OK);
	}

	@GetMapping("/forgetPassword")
	@ResponseBody
	public ResponseEntity<Boolean> doForgetPassword(@RequestParam(required = true) String email) {
		return new ResponseEntity<>(customerService.forgetPassword(email), HttpStatus.OK);
	}

	@PostMapping("/changePassword")
	@ResponseBody
	public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordRequestDTO signUpRequestDTO) {
		return new ResponseEntity<>(customerService.changePassword(signUpRequestDTO), HttpStatus.OK);
	}
}
