package com.mybooking.demo.service;

import com.mybooking.demo.dto.BookingRequestDto;
import com.mybooking.demo.dto.PaymentDetailDTO;
import com.mybooking.demo.dto.PromotionRequestDto;
import com.mybooking.demo.dto.PurchaseResponseDto;

public interface BookingService {

	/*
	 * Functional Requirement: Book movie tickets by selecting a theater, timing,
	 * preferred seats for the day
	 */
	public PurchaseResponseDto blockSeats(BookingRequestDto bookingRequest);

	public PurchaseResponseDto applyPromotionCode(PromotionRequestDto promotionRequestDTO);

	public PurchaseResponseDto processSuccessfulPayment(Long purchaseId, PaymentDetailDTO paymentDto);

	public PurchaseResponseDto processFailedPayment(Long purchaseId, PaymentDetailDTO paymentDto);

}
