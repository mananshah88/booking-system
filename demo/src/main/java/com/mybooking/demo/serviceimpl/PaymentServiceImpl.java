package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.PaymentDetailDTO;
import com.mybooking.demo.service.PaymentService;

@Service
public class PaymentServiceImpl extends BaseServiceImpl implements PaymentService {

	/*
	 * Call the Payment Gateway API with the identifier we receive on
	 * successful/failed transaction and check actually payment gateway has
	 * authorized and received the payment or not.
	 */
	
	/*
	 * If we have multiple payment gateways then we can choose Strategy Design
	 * pattern here. System will decide runtime (from the request) that... which
	 * payment gateway is passed so which payment gateway needs to invoke...
	 */
	public boolean validatePaymentDetailsWithPaymentGateway(PaymentDetailDTO paymentDto) {
		return true;
	}

}
