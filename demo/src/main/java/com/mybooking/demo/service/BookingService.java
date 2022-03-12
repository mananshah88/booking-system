package com.mybooking.demo.service;

import com.mybooking.demo.dto.booking.BookingRequestDto;
import com.mybooking.demo.dto.booking.PaymentDetailDTO;

public interface BookingService {

	/*
	 * Functional Requirement: Book movie tickets by selecting a theater, timing,
	 * preferred seats for the day
	 */
	public Boolean blockSeats(BookingRequestDto bookingRequest);

	public Long processSuccessfulPayment(Long purchaseId, PaymentDetailDTO paymentDto);

	public Boolean processFailedPayment(Long purchaseId, PaymentDetailDTO paymentDto);

}
