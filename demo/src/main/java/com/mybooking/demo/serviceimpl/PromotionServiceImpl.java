package com.mybooking.demo.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.service.MovieTimeslotService;
import com.mybooking.demo.service.PaymentService;
import com.mybooking.demo.service.PromotionService;
import com.mybooking.demo.service.PurchaseService;
import com.mybooking.demo.service.SeatReservationService;
import com.mybooking.demo.service.TheaterService;

/*
 * Functional Requirement: Book movie tickets by selecting 
 * a theater, timing, preferred seats for the day
 */
@Service
public class PromotionServiceImpl extends BaseServiceImpl implements PromotionService {

	private TheaterService theaterService;
	private MovieTimeslotService movieTimeslotService;
	private PurchaseService purchaseService;
	private PaymentService paymentService;
	private SeatReservationService seatReservationService;

	@Autowired
	public PromotionServiceImpl(TheaterService theaterService, MovieTimeslotService movieTimeslotService,
			PurchaseService purchaseService, PaymentService paymentService,
			SeatReservationService seatReservationService) {
		this.theaterService = theaterService;
		this.movieTimeslotService = movieTimeslotService;
		this.purchaseService = purchaseService;
		this.paymentService = paymentService;
		this.seatReservationService = seatReservationService;
	}

	@Override
	public Purchase applyPromotion(Long cityId, Long theaterId, Long screenId, Integer noOfTickets,
			Date timeslot, Long purchaseId) {
		// check promotion is valid or not
		// check purchase is valid or not
		// If promotionCode is applied or not then check it fulfills the requirement or not
		// Check if there is any implicit(hidden) promotions running or not...if yes then check the restrictions and ...
		return null;
	}

	

}
