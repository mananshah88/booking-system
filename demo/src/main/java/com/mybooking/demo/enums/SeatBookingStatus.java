package com.mybooking.demo.enums;

public enum SeatBookingStatus {

	AVAILABLE(0), IN_PROGRESS(1), BOOKED(2);

	int status;

	SeatBookingStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
