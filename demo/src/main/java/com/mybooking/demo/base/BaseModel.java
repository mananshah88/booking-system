package com.mybooking.demo.base;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* We can get/inject the Logged in Customer Id from the session/token */
	public Integer getLoggedInCustomerId() {
		return 1;
	}

	public Date getCurrentDateTime() {
		return new Date();
	}
}