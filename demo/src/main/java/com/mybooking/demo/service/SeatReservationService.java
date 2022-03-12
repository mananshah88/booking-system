package com.mybooking.demo.service;

import java.util.Set;

import com.mybooking.demo.model.rdbms.Order;
import com.mybooking.demo.model.rdbms.Purchase;

public interface SeatReservationService {

	public boolean blockSeats(Set<Long> seatIds, Purchase purchase);

	public Order bookSeats(Set<Long> seatIds, Purchase purchase, Long paymentId);

	public boolean unblockTickets(Set<Long> seatIds, Purchase purchase);

//	public SeatReservation testMethod(int no);

}
