package com.mybooking.demo.serviceimpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.constant.BaseConstants;
import com.mybooking.demo.model.rdbms.PromotionEntity;

@Service
public class PromotionCalculationEngine extends BaseServiceImpl {

	public BigDecimal calculate(PromotionEntity pe, BigDecimal totalAmount, Integer noOfTicket,
			BigDecimal priceForSingleTicket) {

		/* possible values: overall, individual */
		String entityType = pe.getEntityType();

		/* possible values: 1, 2, 3 */
		Integer entityValue = pe.getEntityValue();

		/* possible values: any, onwords */
		String entityOperator = pe.getEntityOperator();

		/* possible values: FIXED, PERCENTAGE */
		String promotionType = pe.getPromotionType();

		/* possible values: 20, 50, 100 */
		BigDecimal promotionValue = pe.getPromotionValue();

		if (BaseConstants.ENTITYTYPE_OVERALL.equalsIgnoreCase(entityType)) {
			return checkForOverAll(promotionType, promotionValue, totalAmount);
		} else if (BaseConstants.ENTITYTYPE_INDIVIDUAL.equalsIgnoreCase(entityType)) {
			if (BaseConstants.ENTITYOPERATOR_ANY.equalsIgnoreCase(entityOperator)) {
				BigDecimal bd = new BigDecimal(entityValue);
				return checkForAny(promotionType, promotionValue, bd, priceForSingleTicket);
			} else if (BaseConstants.ENTITYOPERATOR_ONWARDS.equalsIgnoreCase(entityOperator)) {
				BigDecimal bd = new BigDecimal(noOfTicket - entityValue);
				return checkForAny(promotionType, promotionValue, bd, priceForSingleTicket);
			} else if(BaseConstants.ENTITYOPERATOR_EACH.equalsIgnoreCase(entityOperator)) {
				BigDecimal bd = new BigDecimal(noOfTicket);
				return checkForAny(promotionType, promotionValue, bd, priceForSingleTicket);
			}
		}
		return BigDecimal.ZERO;
	}

	public BigDecimal checkForOverAll(String promotionType, BigDecimal promotionValue, BigDecimal totalAmount) {
		return BaseConstants.PROMOTIONTYPE_FIXED.equalsIgnoreCase(promotionType) ? promotionValue
				: (totalAmount.multiply(promotionValue)).divide(new BigDecimal(100));
	}

	public BigDecimal checkForAny(String promotionType, BigDecimal promotionValue, BigDecimal entityValue,
			BigDecimal priceForSingleTicket) {
		return BaseConstants.PROMOTIONTYPE_FIXED.equalsIgnoreCase(promotionType) ? promotionValue.multiply(entityValue)
				: priceForSingleTicket.multiply(promotionValue).divide(new BigDecimal(100)).multiply(entityValue);
	}

}
