package com.mybooking.demo.service;

import com.mybooking.demo.dto.PaymentDetailDTO;

public interface PaymentService {

	public boolean validatePaymentDetailsWithPaymentGateway(PaymentDetailDTO paymentDto);
}
