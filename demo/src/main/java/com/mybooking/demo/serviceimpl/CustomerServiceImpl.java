package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.dto.customer.ChangePasswordRequestDTO;
import com.mybooking.demo.dto.customer.CustomerProfileRequestDto;
import com.mybooking.demo.dto.customer.CustomerProfileResponseDto;
import com.mybooking.demo.dto.customer.SignupRequestDTO;
import com.mybooking.demo.dto.customer.SocialSignupRequestDTO;
import com.mybooking.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Boolean signUp(SignupRequestDTO signUpRequestDTO) {
		return true;
	}

	@Override
	public Boolean socialSignUp(SocialSignupRequestDTO signUpRequestDTO) {
		return true;
	}

	@Override
	public Boolean forgetPassword(String email) {
		return true;
	}

	@Override
	public Boolean changePassword(ChangePasswordRequestDTO signUpRequestDTO) {
		return true;
	}

	@Override
	public CustomerProfileResponseDto getProfileDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modifyProfileDetails(CustomerProfileRequestDto customerProfileRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
