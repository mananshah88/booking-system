package com.mybooking.demo.enums;

public enum PurchaseStatus {

	IN_CHECKOUT(0), PAYMENT_INITATED(1), PAYMENT_SUCCESS(2), PAYMENT_ABORTED(3), PAYMENT_FAILED(4);

	int status;

	PurchaseStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
