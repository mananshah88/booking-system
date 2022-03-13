package com.mybooking.demo.serviceimpl;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.constant.BaseConstants;
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

		if (BaseConstants.ENTITYTYPE_OVERALL.equalsIgnoreCase(entityType)) {
			return checkForOverAll(promotionType, promotionValue, totalAmount);
		} else if (BaseConstants.ENTITYTYPE_INDIVIDUAL.equalsIgnoreCase(entityType)) {
			if (BaseConstants.ENTITYOPERATOR_ANY.equalsIgnoreCase(entityOperator)) {
				return checkForAny(promotionType, promotionValue, entityValue, priceForSingleTicket);
			} else if (BaseConstants.ENTITYOPERATOR_ONWARDS.equalsIgnoreCase(entityOperator)) {
				return checkForAny(promotionType, promotionValue, (noOfTicket - entityValue), priceForSingleTicket);
			}
		}
		return 0d;
	}

	public Double checkForOverAll(String promotionType, Double promotionValue, Double totalAmount) {
		return BaseConstants.PROMOTIONTYPE_FIXED.equalsIgnoreCase(promotionType) ? promotionValue
				: ((totalAmount * promotionValue) / 100);
	}

	public Double checkForAny(String promotionType, Double promotionValue, Integer entityValue,
			Double priceForSingleTicket) {
		return BaseConstants.PROMOTIONTYPE_FIXED.equalsIgnoreCase(promotionType) ? (promotionValue * entityValue)
				: (((priceForSingleTicket * promotionValue) / 100) * entityValue);
	}

}
