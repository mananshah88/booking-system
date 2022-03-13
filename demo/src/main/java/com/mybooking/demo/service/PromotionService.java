package com.mybooking.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.mybooking.demo.model.rdbms.Promotion;
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

	public Promotion getPromotion(String promotionCode);
	
	public List<Promotion> getSelfAppliedPromotions();

	public boolean isPurchaseElligibleForPromotion(Purchase purchase, Promotion promotion);

	public BigDecimal calculateDiscount(Purchase purchase, Promotion promotion);

}
