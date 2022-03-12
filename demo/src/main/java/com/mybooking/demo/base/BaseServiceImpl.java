package com.mybooking.demo.base;

import java.util.Date;

public class BaseServiceImpl {

	/* We can get/inject the Logged in Customer Id from the session/token */
	public Integer getLoggedInCustomerId() {
		return 1;
	}

	/* Everytime it returns the current date */
	public Date getCurrentDateTime() {
		return new Date();
	}
	
}
