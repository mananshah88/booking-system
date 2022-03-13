package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.model.rdbms.PromotionEntity;

@Service
public class PromotionCalculationEngine extends BaseServiceImpl {

	public Double calculate(PromotionEntity pe, Double totalAmount, Integer noOfTicket, Double priceForSingleTicket) {

		/* possible values: overall, individual */
		String entityType = pe.getEntityType();

		/* possible values: 1, 2, 3 */
		Integer entityValue = pe.getEntityValue();

		/* possible values: any, onwords */
		String entityOperator = pe.getEntityOperator();

		/* possible values: FIXED, PERCENTAGE */
		String promotionType = pe.getPromotionType();

		/* possible values: 20, 50, 100 */
		Double promotionValue = pe.getPromotionValue();

		if ("overall".equalsIgnoreCase(entityType)) {
			return checkForOverAll(promotionType, promotionValue, totalAmount);
		} else if ("individual".equalsIgnoreCase(entityType)) {
			if ("any".equalsIgnoreCase(entityOperator)) {
				return checkForAny(promotionType, promotionValue, entityValue, priceForSingleTicket);
			} else if ("onwards".equalsIgnoreCase(entityOperator)) {
				return checkForAny(promotionType, promotionValue, (noOfTicket - entityValue), priceForSingleTicket);
			}
		}
		return 0d;
	}

	public Double checkForOverAll(String promotionType, Double promotionValue, Double totalAmount) {
		return "fixed".equalsIgnoreCase(promotionType) ? promotionValue : ((totalAmount * promotionValue) / 100);
	}

	public Double checkForAny(String promotionType, Double promotionValue, Integer entityValue,
			Double priceForSingleTicket) {
		return "fixed".equalsIgnoreCase(promotionType) ? (promotionValue * entityValue)
				: (((priceForSingleTicket * promotionValue) / 100) * entityValue);
	}

}
