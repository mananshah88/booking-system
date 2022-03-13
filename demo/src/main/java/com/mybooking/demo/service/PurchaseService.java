package com.mybooking.demo.service;

import java.util.Set;

import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Purchase;

public interface PurchaseService {

	public Purchase getPurchase(Long purchaseId);

	public Purchase preparePurchase(MovieTimeslot movieTimeSlot, Set<Long> seats);

	public Purchase applyPromotionOnPurchase(Purchase purchase, Double discount, String promotionCode);
	
	public Purchase save(Purchase purchase);
}
