package com.mybooking.demo.service;

import com.mybooking.demo.dto.PurchaseResponseDto;

public interface NotificationService {

	public void notifyCustomer(PurchaseResponseDto purchaseResponseDto);

}
