package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.dto.account.ChangePasswordRequestDTO;
import com.mybooking.demo.dto.account.SignupRequestDTO;
import com.mybooking.demo.dto.account.SocialSignupRequestDTO;
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

}
