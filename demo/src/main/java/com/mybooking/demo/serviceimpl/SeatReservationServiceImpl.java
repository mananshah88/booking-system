package com.mybooking.demo.serviceimpl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.PurchaseItemResponseDto;
import com.mybooking.demo.dto.PurchaseResponseDto;
import com.mybooking.demo.enums.PurchaseStatus;
import com.mybooking.demo.enums.SeatBookingStatus;
import com.mybooking.demo.model.rdbms.Order;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.model.rdbms.SeatReservation;
import com.mybooking.demo.repository.rdbms.OrderRepository;
import com.mybooking.demo.repository.rdbms.PurchaseRepository;
import com.mybooking.demo.repository.rdbms.SeatReservationRepository;
import com.mybooking.demo.service.SeatReservationService;

@Service
public class SeatReservationServiceImpl extends BaseServiceImpl implements SeatReservationService {

	private SeatReservationRepository reservationRepo;
	private PurchaseRepository purchaseRepo;
	private OrderRepository orderRepository;

	@Autowired
	public SeatReservationServiceImpl(SeatReservationRepository reservationRepo, PurchaseRepository purchaseRepo,
			OrderRepository orderRepository) {
		this.reservationRepo = reservationRepo;
		this.purchaseRepo = purchaseRepo;
		this.orderRepository = orderRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 5, readOnly = false, rollbackFor = Exception.class)
	public PurchaseResponseDto blockSeats(Set<Long> seatIds, Purchase purchase) {
		try {
			Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
					SeatBookingStatus.AVAILABLE.getStatus());

			if (reservations != null && !reservations.isEmpty()) {
				reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.IN_PROGRESS.getStatus()));
				purchase.setBookingStatus(PurchaseStatus.IN_CHECKOUT.getStatus());

				reservationRepo.saveAll(reservations);
				purchase = purchaseRepo.save(purchase);

				return new PurchaseResponseDto(purchase.getId(), purchase.getQuantity(), purchase.getTotalamount(),
						purchase.getTax(), purchase.getPromotionCode(), purchase.getDiscount(),
						purchase.getPayableamount(),
						purchase.getPurchaseItems().stream()
								.map(pi -> new PurchaseItemResponseDto(pi.getSeatId(), pi.getPrice()))
								.collect(Collectors.toList()),
						"SUCCESS00", "Seat is blocked. Please pay the money.");
			} else {
				return new PurchaseResponseDto("ERROR_102", "Seat is already booked OR in progress.");
			}
		} catch (PersistenceException e) {
			// LockTimeoutException , PessimisticLockException
			return new PurchaseResponseDto("ERROR_101",
					"Someone is trying to block the seat. Currently seat is not available. Please try after some time.");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public PurchaseResponseDto bookSeats(Set<Long> seatIds, Purchase purchase, Long paymentId) {
		Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
				SeatBookingStatus.IN_PROGRESS.getStatus());
		if (reservations != null && !reservations.isEmpty()) {
			reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.BOOKED.getStatus()));
			purchase.setBookingStatus(PurchaseStatus.PAYMENT_SUCCESS.getStatus());
			reservationRepo.saveAll(reservations);
			var order = orderRepository
					.save(new Order(purchase, paymentId, getLoggedInCustomerId(), getCurrentDateTime()));
			return new PurchaseResponseDto(order.getId(), "SUCCESS00", "Seat is booked/confirmed.");
		} else {
			// Need to discuss because its erroneous case... Need to handle differently
			return new PurchaseResponseDto("ERROR_103", "Something went wrong");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public PurchaseResponseDto unblockTickets(Set<Long> seatIds, Purchase purchase) {
		Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
				SeatBookingStatus.IN_PROGRESS.getStatus());
		if (reservations != null && !reservations.isEmpty()) {
			reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.AVAILABLE.getStatus()));
			purchase.setBookingStatus(PurchaseStatus.PAYMENT_FAILED.getStatus());

			reservationRepo.saveAll(reservations);
			purchaseRepo.save(purchase);
			return new PurchaseResponseDto("SUCCESS00", "Marked the seats as available");
		} else {
			// Need to discuss because its erroneous case... Need to handle differently...
			// either booked/or_already available
			return new PurchaseResponseDto("SUCCESS00", "Marked the seats as available");
		}
	}

//	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public SeatReservation testMethod(int no) {
//		String threadName = Thread.currentThread().getName();
//		System.out.println("In thread::" + threadName);
//		SeatReservation ssr = null;
//		
//		if (no == 1) {
//			System.out.println( threadName + " ::In if");
//			try {
//				ssr = repo.findBySeatIdAndBookingStatus(1, "AVAILABLE");
//			} catch (Exception e) {
//				System.out.println("Got the Exception::" + e.getMessage());
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println( threadName + " ::In else");
//		}
//
//		System.out.println("After try-catch::Thread::"+threadName + ", Found::" + ssr);
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(ssr != null) {
//			System.out.println("Thread::"+threadName + ", Found::" + ssr);
//			ssr.setBookingStatus("In Progress");
//			repo.save(ssr);
//		} else {
//			System.out.println("Thread::"+threadName + ", Not Found::" + ssr);
//		}
//		return ssr;
//	}

}
