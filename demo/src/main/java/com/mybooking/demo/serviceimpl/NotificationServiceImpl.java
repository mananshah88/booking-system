package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.PurchaseResponseDto;
import com.mybooking.demo.service.NotificationService;

@Service
public class NotificationServiceImpl extends BaseServiceImpl implements NotificationService {

	/*
	 * Adapter design pattern:
	 * Here, We can create a wrapper class(OR utility class) by which
	 * application can pass the details and system will notify customers directly
	 * by using 3rd Party libraries
	 */

	@Override
	public void notifyCustomer(PurchaseResponseDto purchaseResponseDto) {
		// send email-sms notification

		// emailUtility.sendEmail();
		// smsUtility.sendSMS();
	}

}
