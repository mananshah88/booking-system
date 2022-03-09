package com.mybooking.demo.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybooking.demo.dto.customer.ChangePasswordRequestDTO;
import com.mybooking.demo.dto.customer.CustomerProfileRequestDto;
import com.mybooking.demo.dto.customer.CustomerProfileResponseDto;
import com.mybooking.demo.dto.customer.SignupRequestDTO;
import com.mybooking.demo.dto.customer.SocialSignupRequestDTO;

public interface CustomerService {

	public Boolean signUp(@RequestBody SignupRequestDTO signUpRequestDTO);

	public Boolean socialSignUp(@RequestBody SocialSignupRequestDTO signUpRequestDTO);

	public Boolean forgetPassword(@RequestParam(required = true) String email);

	public Boolean changePassword(@RequestBody ChangePasswordRequestDTO signUpRequestDTO);

	public CustomerProfileResponseDto getProfileDetails();

	public Boolean modifyProfileDetails(CustomerProfileRequestDto customerProfileRequestDto);

}
