package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.booking.PaymentDetailDTO;
import com.mybooking.demo.service.PaymentService;

@Service
public class PaymentServiceImpl extends BaseServiceImpl implements PaymentService {

	// Call the Payment Gateway API with the identifier we receive on
	// successful/failed
	// transaction and check actually payment gateway has authorized and received
	// the payment or not.
	public boolean validatePaymentDetailsWithPaymentGateway(PaymentDetailDTO paymentDto) {
		return true;
	}

}
