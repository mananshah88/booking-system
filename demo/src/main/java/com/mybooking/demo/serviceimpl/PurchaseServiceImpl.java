package com.mybooking.demo.serviceimpl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.enums.PurchaseStatus;
import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.model.rdbms.PurchaseItem;
import com.mybooking.demo.model.rdbms.SeatDetails;
import com.mybooking.demo.repository.rdbms.PurchaseRepository;
import com.mybooking.demo.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseRepository purchaseRepo;

	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepo) {
		this.purchaseRepo = purchaseRepo;
	}

	@Override
	public Optional<Purchase> getPurchase(Long purchaseId) {
		return purchaseRepo.findById(purchaseId);
	}

	@Override
	public Purchase preparePurchase(MovieTimeslot movieTimeSlot, Set<Long> seatIds) {
		Double totalamount = movieTimeSlot.getSeatDetails().stream().map(SeatDetails::getPrice).reduce(0d, Double::sum);
		Double tax = getTax(totalamount);
		Double discount = getPromotion();
		Purchase purchase = new Purchase(seatIds.size(), totalamount, tax, discount,
				getPayableamount(totalamount, tax, discount), PurchaseStatus.IN_CHECKOUT.getStatus());
		movieTimeSlot.getSeatDetails().forEach(
				seatDetail -> purchase.addPurchaseItem(new PurchaseItem(seatDetail.getId(), seatDetail.getPrice())));
		return purchase;
	}

	public Double getPayableamount(Double totalamount, Double tax, Double discount) {
		return (totalamount + tax - discount);
	}

	/*
	 * we can keep tax calculation here... we can store tax configuration either in
	 * the configuration file like application.properties or in the database-table
	 */
	public Double getTax(Double totalamount) {
		return 0d;
	}

	/* We can keep the discount logic here... */
	public Double getPromotion() {
		return 0d;
	}

}
