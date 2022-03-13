package com.mybooking.demo.serviceimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.constant.BaseConstants;
import com.mybooking.demo.exceptions.InvalidPromotionException;
import com.mybooking.demo.model.rdbms.Promotion;
import com.mybooking.demo.model.rdbms.Purchase;
import com.mybooking.demo.repository.rdbms.PromotionRepository;
import com.mybooking.demo.service.PromotionService;

@Service
public class PromotionServiceImpl extends BaseServiceImpl implements PromotionService {

	private PromotionRepository promotionRepo;
	private PromotionRestictionEngine promotionEngine;
	private PromotionCalculationEngine promotionCalculationEngine;

	@Autowired
	public PromotionServiceImpl(PromotionRepository promotionRepo, PromotionRestictionEngine promotionEngine,
			PromotionCalculationEngine promotionCalculationEngine) {
		this.promotionRepo = promotionRepo;
		this.promotionEngine = promotionEngine;
		this.promotionCalculationEngine = promotionCalculationEngine;
	}

	@Override
	public Purchase applyPromotion(Long cityId, Long theaterId, Long screenId, Integer noOfTickets, Date timeslot,
			Long purchaseId) {

		return null;
	}

	@Override
	public Promotion getPromotion(String promotionCode) {
		/* Validate promotionCode */
		Optional<Promotion> requestedPromotion = promotionRepo.findByPromotionCode(promotionCode);
		if (requestedPromotion.isEmpty()) {
			throw new InvalidPromotionException("Invalid promotion");
		}
		return requestedPromotion.get();
	}

	@Override
	public boolean isPurchaseElligibleForPromotion(Purchase purchase, Promotion promotion) {
		return promotion.getRestrictions().stream()
				.noneMatch(restriction -> !promotionEngine.isConditionFulfilled(purchase, restriction));
	}

	@Override
	public BigDecimal calculateDiscount(Purchase purchase, Promotion promotion) {
		BigDecimal discount = promotion
				.getEntities().stream().map(pe -> promotionCalculationEngine.calculate(pe, purchase.getTotalamount(),
						purchase.getQuantity(), purchase.getPriceForSingleTicket()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		if (discount.compareTo(BigDecimal.ZERO) < 0) {
			discount = BigDecimal.ZERO;
		}
		if (purchase.getTotalamount().compareTo(discount) < 0) {
			discount = purchase.getTotalamount();
		}
		return discount;
	}

	@Override
	public List<Promotion> getSelfAppliedPromotions() {
		return promotionRepo.findByType(BaseConstants.PROMOTIONTYPE_SELF);
	}

}
