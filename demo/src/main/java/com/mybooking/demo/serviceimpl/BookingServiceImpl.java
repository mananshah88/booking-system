package com.mybooking.demo.serviceimpl;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.BookingRequestDto;
import com.mybooking.demo.dto.PaymentDetailDTO;
import com.mybooking.demo.dto.PromotionRequestDto;
import com.mybooking.demo.dto.PurchaseResponseDto;
import com.mybooking.demo.model.rdbms.Promotion;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.model.rdbms.PurchaseItem;
import com.mybooking.demo.service.BookingService;
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
public class BookingServiceImpl extends BaseServiceImpl implements BookingService {

	private TheaterService theaterService;
	private MovieTimeslotService movieTimeslotService;
	private PurchaseService purchaseService;
	private PromotionService promotionService;
	private PaymentService paymentService;
	private SeatReservationService seatReservationService;

	@Autowired
	public BookingServiceImpl(TheaterService theaterService, MovieTimeslotService movieTimeslotService,
			PurchaseService purchaseService, PaymentService paymentService, PromotionService promotionService,
			SeatReservationService seatReservationService) {
		this.theaterService = theaterService;
		this.movieTimeslotService = movieTimeslotService;
		this.purchaseService = purchaseService;
		this.paymentService = paymentService;
		this.promotionService = promotionService;
		this.seatReservationService = seatReservationService;
	}

	@Override
	public PurchaseResponseDto blockSeats(BookingRequestDto bookingRequest) {

		/* Validate theater-screen details */
		var screen = theaterService.validateAndGetTheater(bookingRequest.getTheaterId(), bookingRequest.getScreenId());

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
	 * The client(web or mobile) can get the success from the PaymentGateway. Then
	 * client calls this API
	 */
	@Override
	public PurchaseResponseDto processSuccessfulPayment(Long purchaseId, PaymentDetailDTO paymentDto) {

		Purchase purchase = purchaseService.getPurchase(purchaseId);

		/* Validate the payment details with Payment Gateway */
		boolean isSuccess = paymentService.validatePaymentDetailsWithPaymentGateway(paymentDto);
		if (isSuccess) {
			Set<Long> seatIds = purchase.getPurchaseItems().stream().map(PurchaseItem::getSeatId)
					.collect(Collectors.toSet());
			return seatReservationService.bookSeats(seatIds, purchase, paymentDto.getPaymentId());
		} else {
			// receiving failed payment... there can be many possible things so will do as
			// per requirement
			return new PurchaseResponseDto("ERROR_104",
					"Payment is failed/aborted but customer is behaving like successful payment.");
		}
	}

	/*
	 * The client(web or mobile) can get the failed/abort payment from the
	 * PaymentGateway. Then client calls this API
	 */
	@Override
	public PurchaseResponseDto processFailedPayment(Long purchaseId, PaymentDetailDTO paymentDto) {

		Purchase purchase = purchaseService.getPurchase(purchaseId);

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
			return new PurchaseResponseDto("ERROR_105",
					"Payment is done but customer is behaving like its failed payment.");
		}
	}

	@Override
	public PurchaseResponseDto applyPromotionCode(PromotionRequestDto promotionRequestDto) {

		// check purchase is valid or not
		Purchase purchase = purchaseService.getPurchase(promotionRequestDto.getPurchaseId());

		if (promotionRequestDto.getPromotionCode() != null && !promotionRequestDto.getPromotionCode().isEmpty()) {
			// Promotion code is applied then check it is valid or not
			Promotion promotion = promotionService.getPromotion(promotionRequestDto.getPromotionCode());

			// If it is valid then check all the criteria are fulfilled or not
			if (promotionService.isPurchaseElligibleForPromotion(purchase, promotion)) {

				// If criteria are fulfilled then calculate the discount
				BigDecimal discount = promotionService.calculateDiscount(purchase, promotion);

				// Apply the discount in the purchase.
				purchase = purchaseService.applyPromotionOnPurchase(purchase, discount,
						promotionRequestDto.getPromotionCode());

				purchaseService.save(purchase);

			} else {
				return new PurchaseResponseDto("ERROR_106", "Promtion critrias are not fulfilled");
			}
		}
		return null;
	}

}
