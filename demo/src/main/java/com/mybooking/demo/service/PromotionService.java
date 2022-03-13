package com.mybooking.demo.service;

import java.util.Date;

import com.mybooking.demo.model.rdbms.Purchase;

public interface PromotionService {

	/*
	 * Functional Requirement: 
	 * • Booking platform offers in selected cities and theatres
         ◦ 50% discount on the third ticket
         ◦ Tickets booked for the afternoon show get a 20% discount
	 */
	public Purchase applyPromotion(Long cityId, Long theaterId, Long screenId, Integer noOfTickets, Date timeslot,
			Long purchaseId);

}
