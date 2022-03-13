package com.mybooking.demo.authorization;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseLogger;
import com.mybooking.demo.enums.AccessRole;

@Service
public class CurrentUserServiceImpl extends BaseLogger {

	public boolean isAdmin() {
		if (AccessRole.ADMIN.getValue() != getUserType()) {
			info("Loggedin User is not an Admin.");
			return false;
		}
		info("Loggedin User is Admin.");
		return true;
	}

	public boolean isPartner() {
		if (AccessRole.PARTNER.getValue() != getUserType()) {
			info("Loggedin User is not a Partner.");
			return false;
		}
		info("Loggedin User is Partner.");
		return true;
	}

	public boolean isTheSamePartner(Integer id) {
		if (AccessRole.PARTNER.getValue() != getUserType()) {
			info("Loggedin User is not a Partner.");
			return false;
		}
		if(!id.equals(getCustomerIdFromTheTokenOrSession())) {
			info("Loggedin User(Partner) is trying to fetch other Partner's details.");
			return false;
		}
		info("Loggedin User is the real Partner.");
		return true;
	}

	public boolean isCustomer() {
		if (AccessRole.CUSTOMER.getValue() != getUserType()) {
			info("Loggedin User is not a Customer.");
			return false;
		}
		info("Loggedin User is Customer.");
		return true;
	}

	public Integer getUserType() {
		/*
		 * 1. Get token (OAuth Token/Access Token) from the request OR 
		 * 1. Get session-details(if it is session-based app) 
		 * 2. Sometimes token contains the information of "type" or "role"...If it is the case then validate that information OR 
		 * 2. fetch customerId/or other identifier from the token and fetch similar information from the DataBase 
		 * 3. Validate the details and 
		 * 4. return the validated result.
		 */

		/*
		 * Possible Return types: AccessRole.CUSTOMER(1), AccessRole.ADMIN(2),
		 * AccessRole.PARTNER(3)
		 */
		return 1;
	}
	
	public Integer getCustomerIdFromTheTokenOrSession() {
		/*
		 * 1. Get token (OAuth Token/Access Token) from the request OR 
		 * 1. Get session-details(if it is session-based app) 
		 * 2. return customer-id from there
		 */
		return 1;
	}
}
