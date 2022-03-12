package com.mybooking.demo.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybooking.demo.base.BaseServiceImpl;
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
	public boolean blockSeats(Set<Long> seatIds, Purchase purchase) {
		Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
				SeatBookingStatus.AVAILABLE.getStatus());
		if (reservations != null && !reservations.isEmpty()) {
			reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.IN_PROGRESS.getStatus()));
			purchase.setBookingStatus(PurchaseStatus.IN_CHECKOUT.getStatus());

			reservationRepo.saveAll(reservations);
			purchaseRepo.save(purchase);
			return true;
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public Order bookSeats(Set<Long> seatIds, Purchase purchase, Long paymentId) {
		Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
				SeatBookingStatus.IN_PROGRESS.getStatus());
		if (reservations != null && !reservations.isEmpty()) {
			reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.BOOKED.getStatus()));
			purchase.setBookingStatus(PurchaseStatus.PAYMENT_SUCCESS.getStatus());

			reservationRepo.saveAll(reservations);
			return orderRepository.save(new Order(purchase, paymentId, getLoggedInCustomerId(), getCurrentDateTime()));
		} else {
			// Need to discuss because its erroneous case... Need to handle differently
			return null;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public boolean unblockTickets(Set<Long> seatIds, Purchase purchase) {
		Set<SeatReservation> reservations = reservationRepo.findBySeatIdInAndBookingStatus(seatIds,
				SeatBookingStatus.IN_PROGRESS.getStatus());
		if (reservations != null && !reservations.isEmpty()) {
			reservations.forEach(r -> r.setBookingStatus(SeatBookingStatus.AVAILABLE.getStatus()));
			purchase.setBookingStatus(PurchaseStatus.PAYMENT_FAILED.getStatus());

			reservationRepo.saveAll(reservations);
			purchaseRepo.save(purchase);
			return true;
		} else {
			// Need to discuss because its erroneous case... Need to handle differently
			return false;
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
