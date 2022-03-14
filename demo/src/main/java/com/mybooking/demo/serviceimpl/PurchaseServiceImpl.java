package com.mybooking.demo.serviceimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		BigDecimal priceForSingleTicket = movieTimeSlot.getSeatDetails().stream().findFirst().get().getPrice();
		BigDecimal totalamount = movieTimeSlot.getSeatDetails().stream().map(SeatDetails::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal tax = getTax(totalamount);
		Purchase purchase = new Purchase(priceForSingleTicket, seatIds.size(), totalamount, tax, BigDecimal.ZERO,
				getPayableamount(totalamount, tax, BigDecimal.ZERO), PurchaseStatus.IN_CHECKOUT.getStatus(),
				getLoggedInCustomerId(), getCurrentDateTime());
		movieTimeSlot.getSeatDetails()
				.forEach(seatDetail -> purchase.addPurchaseItem(new PurchaseItem(seatDetail.getId(),
						seatDetail.getPrice(), getLoggedInCustomerId(), getCurrentDateTime())));
		checkAndApplySelfApplicablePromotionIfAny(purchase);
		return purchase;
	}

	public BigDecimal getPayableamount(BigDecimal totalamount, BigDecimal tax, BigDecimal discount) {
		if (totalamount.compareTo(discount) < 0) {
			discount = totalamount;
		}
		return totalamount.add(tax).subtract(discount).setScale(2, RoundingMode.HALF_EVEN);
	}

	/*
	 * we can keep tax calculation here... we can store tax configuration either in
	 * the configuration file like application.properties or in the database-table
	 */
	public BigDecimal getTax(BigDecimal totalamount) {
		return BigDecimal.ZERO;
	}

	public void checkAndApplySelfApplicablePromotionIfAny(Purchase purchase) {
		List<Promotion> promotions = promotionService.getSelfAppliedPromotions();
		for (Promotion promotion : promotions) {
			if (promotionService.isPurchaseElligibleForPromotion(purchase, promotion)) {
				BigDecimal discount = promotionService.calculateDiscount(purchase, promotion);
				applyPromotionOnPurchase(purchase, discount, promotion.getPromotionCode());
				break;
			}
		}
	}

	@Override
	public Purchase applyPromotionOnPurchase(Purchase purchase, BigDecimal discount, String promotionCode) {
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
