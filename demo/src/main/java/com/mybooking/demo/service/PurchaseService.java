package com.mybooking.demo.service;

import java.util.Optional;
import java.util.Set;

import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Purchase;

public interface PurchaseService {

	public Optional<Purchase> getPurchase(Long purchaseId);

	public Purchase preparePurchase(MovieTimeslot movieTimeSlot, Set<Long> seats);

}
