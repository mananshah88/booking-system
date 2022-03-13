package com.mybooking.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.enums.PurchaseStatus;
import com.mybooking.demo.exceptions.InvalidPurchaseException;
import com.mybooking.demo.model.rdbms.MovieTimeslot;
import com.mybooking.demo.model.rdbms.Promotion;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.model.rdbms.PurchaseItem;
import com.mybooking.demo.model.rdbms.SeatDetails;
import com.mybooking.demo.repository.rdbms.PurchaseRepository;
import com.mybooking.demo.service.PromotionService;
import com.mybooking.demo.service.PurchaseService;

@Service
public class PurchaseServiceImpl extends BaseServiceImpl implements PurchaseService {

	private PurchaseRepository purchaseRepo;
	private PromotionService promotionService;

	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepo, PromotionService promotionService) {
		this.purchaseRepo = purchaseRepo;
		this.promotionService = promotionService;
	}

	@Override
	public Purchase getPurchase(Long purchaseId) {
		Optional<Purchase> requestedPurchase = purchaseRepo.findById(purchaseId);
		if (requestedPurchase.isEmpty()) {
			throw new InvalidPurchaseException("Invalid purchase");
		}
		return requestedPurchase.get();
	}

	@Override
	public Purchase preparePurchase(MovieTimeslot movieTimeSlot, Set<Long> seatIds) {
		Double priceForSingleTicket = movieTimeSlot.getSeatDetails().stream().findFirst().get().getPrice();
		Double totalamount = movieTimeSlot.getSeatDetails().stream().map(SeatDetails::getPrice).reduce(0d, Double::sum);
		Double tax = getTax(totalamount);
		Purchase purchase = new Purchase(priceForSingleTicket, seatIds.size(), totalamount, tax, 0d,
				getPayableamount(totalamount, tax, 0d), PurchaseStatus.IN_CHECKOUT.getStatus(), getLoggedInCustomerId(),
				getCurrentDateTime());
		movieTimeSlot.getSeatDetails()
				.forEach(seatDetail -> purchase.addPurchaseItem(new PurchaseItem(seatDetail.getId(),
						seatDetail.getPrice(), getLoggedInCustomerId(), getCurrentDateTime())));
		checkAndApplySelfApplicablePromotionIfAny(purchase);
		return purchase;
	}

	public Double getPayableamount(Double totalamount, Double tax, Double discount) {
		if (totalamount < discount) {
			discount = totalamount;
		}
		return (totalamount + tax - discount);
	}

	/*
	 * we can keep tax calculation here... we can store tax configuration either in
	 * the configuration file like application.properties or in the database-table
	 */
	public Double getTax(Double totalamount) {
		return 0d;
	}

	public void checkAndApplySelfApplicablePromotionIfAny(Purchase purchase) {
		List<Promotion> promotions = promotionService.getSelfAppliedPromotions();
		for (Promotion promotion : promotions) {
			if (promotionService.isPurchaseElligibleForPromotion(purchase, promotion)) {
				Double discount = promotionService.calculateDiscount(purchase, promotion);
				applyPromotionOnPurchase(purchase, discount, promotion.getPromotionCode());
				break;
			}
		}
	}

	@Override
	public Purchase applyPromotionOnPurchase(Purchase purchase, Double discount, String promotionCode) {
		purchase.setDiscount(discount);
		purchase.setPromotionCode(promotionCode);
		purchase.setPayableamount(getPayableamount(purchase.getTotalamount(), purchase.getTax(), discount));
		return purchase;
	}

	@Override
	public Purchase save(Purchase purchase) {
		return purchaseRepo.save(purchase);
	}

}
