package com.mybooking.demo.service;

import com.mybooking.demo.dto.booking.PaymentDetailDTO;

public interface PaymentService {

	public boolean validatePaymentDetailsWithPaymentGateway(PaymentDetailDTO paymentDto);
}
