package com.mybooking.demo.serviceimpl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.booking.BookingRequestDto;
import com.mybooking.demo.dto.booking.PaymentDetailDTO;
import com.mybooking.demo.exceptions.InvalidPurchaseException;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.model.rdbms.PurchaseItem;
import com.mybooking.demo.service.BookingService;
import com.mybooking.demo.service.MovieTimeslotService;
import com.mybooking.demo.service.PaymentService;
import com.mybooking.demo.service.PurchaseService;
import com.mybooking.demo.service.SeatReservationService;
import com.mybooking.demo.service.TheaterService;

/*
 * Functional Requirement: Book movie tickets by selecting 
 * a theater, timing, preferred seats for the day
 */
@Service
public class BookingServiceImpl extends BaseServiceImpl implements BookingService {

	private TheaterService theaterService;
	private MovieTimeslotService movieTimeslotService;
	private PurchaseService purchaseService;
	private PaymentService paymentService;
	private SeatReservationService seatReservationService;

	@Autowired
	public BookingServiceImpl(TheaterService theaterService, MovieTimeslotService movieTimeslotService,
			PurchaseService purchaseService, PaymentService paymentService,
			SeatReservationService seatReservationService) {
		this.theaterService = theaterService;
		this.movieTimeslotService = movieTimeslotService;
		this.purchaseService = purchaseService;
		this.paymentService = paymentService;
		this.seatReservationService = seatReservationService;
	}

	@Override
	public Boolean blockSeats(BookingRequestDto bookingRequest) {

		/* Validate theater-screen details */
		var screen = theaterService.validateAndGetTheater(bookingRequest.getTheaterId(),
				bookingRequest.getScreenId());

		/* validate Movie Timeslot */
		var movieTimeSlot = movieTimeslotService.validateAndGetMovieTimeslot(screen,
				bookingRequest.getBookingDateTimeSlot());

		/* Check requested seats are valid or not */
		movieTimeslotService.validSeatsOrNot(movieTimeSlot, bookingRequest.getSeatIds());

		/* Create Purchase */
		Purchase purchase = purchaseService.preparePurchase(movieTimeSlot, bookingRequest.getSeatIds());

		/*
		 * Try to acquire the lock for the request seats If get the lock -> apply the
		 * lock (Update Version and Mark the seats as "In-Progress") and Persist the
		 * purchase. Else -> do nothing and return that these seats are not available
		 */
		return seatReservationService.blockSeats(bookingRequest.getSeatIds(), purchase);
	}

	/*
	 * The client(web or mobile) can get the success from the PaymentGateway. 
	 * Then client calls this API 
	 */
	@Override
	public Long processSuccessfulPayment(Long purchaseId, PaymentDetailDTO paymentDto) {

		Optional<Purchase> requestedPurchase = purchaseService.getPurchase(purchaseId);
		if (requestedPurchase.isEmpty()) {
			throw new InvalidPurchaseException("Invalid purchase");
		}
		Purchase purchase = requestedPurchase.get();

		/* Validate the payment details with Payment Gateway */
		boolean isSuccess = paymentService.validatePaymentDetailsWithPaymentGateway(paymentDto);
		if (isSuccess) {
			Set<Long> seatIds = purchase.getPurchaseItems().stream().map(PurchaseItem::getSeatId)
					.collect(Collectors.toSet());
			var order = seatReservationService.bookSeats(seatIds, purchase, paymentDto.getPaymentId());
			return order != null ? order.getId() : 0l;
		} else {
			// receiving failed payment... there can be many possible things so will do as
			// per requirement
			return 0l;
		}
	}

	/*
	 * The client(web or mobile) can get the failed/abort payment from the PaymentGateway. 
	 * Then client calls this API 
	 */
	@Override
	public Boolean processFailedPayment(Long purchaseId, PaymentDetailDTO paymentDto) {
		Optional<Purchase> requestedPurchase = purchaseService.getPurchase(purchaseId);
		if (requestedPurchase.isEmpty()) {
			throw new InvalidPurchaseException("Invalid purchase");
		}
		Purchase purchase = requestedPurchase.get();

		/* Validate the payment details with Payment Gateway */
		boolean isFailed = paymentService.validatePaymentDetailsWithPaymentGateway(paymentDto);
		if (isFailed) {
			Set<Long> seatIds = purchase.getPurchaseItems().stream().map(PurchaseItem::getSeatId)
					.collect(Collectors.toSet());
			return seatReservationService.unblockTickets(seatIds, purchase);
		} else {
			// receiving successful payment... there can be many possible things so will do
			// as
			// per requirement
			return false;
		}
	}
}
