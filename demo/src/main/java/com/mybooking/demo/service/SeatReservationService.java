package com.mybooking.demo.service;

import java.util.Set;

import com.mybooking.demo.dto.PurchaseResponseDto;
import com.mybooking.demo.model.rdbms.Purchase;

public interface SeatReservationService {

	public PurchaseResponseDto blockSeats(Set<Long> seatIds, Purchase purchase);

	public PurchaseResponseDto bookSeats(Set<Long> seatIds, Purchase purchase, Long paymentId);

	public PurchaseResponseDto unblockTickets(Set<Long> seatIds, Purchase purchase);

//	public SeatReservation testMethod(int no);

}
