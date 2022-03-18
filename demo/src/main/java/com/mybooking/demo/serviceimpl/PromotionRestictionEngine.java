package com.mybooking.demo.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.constant.BaseConstants;
import com.mybooking.demo.model.rdbms.PromotionRestriction;
import com.mybooking.demo.model.rdbms.Purchase;

@Service
public class PromotionRestictionEngine extends BaseServiceImpl {

	public boolean isConditionFulfilled(Purchase purchase, PromotionRestriction restriction) {
		String condition = restriction.getConditionType();
		String operator = restriction.getConditionOperator();
		String value = restriction.getConditionValue();

		/*
		 * For this logic, there are only few if-else statements. But in the future
		 * if we have multiple if-else then we can use
		 * Strategy Pattern: Replace Conditional Logic with Strategy.
		 *
		 * 1. Strategy + Factory Design Pattern using Map
		 * 2. Strategy + Factory Design Pattern using Enum
		 * See: com.mybooking.demo.designpattern.strategy_factory.Sample File
		 */

		if (BaseConstants.CONDITION_CITY.equalsIgnoreCase(condition)) {
			if (!checkForCityRestriction(purchase, value, operator)) {
				return false;
			}
		} else if (BaseConstants.CONDITION_THEATER.equalsIgnoreCase(condition)) {
			if (!checkForTheaterRestriction(purchase, value, operator)) {
				return false;
			}
		} else if (BaseConstants.CONDITION_NOOFTICKETS.equalsIgnoreCase(condition)) {
			if (!checkForNoOfTicketsRestriction(purchase, value, operator)) {
				return false;
			}
		} else if (BaseConstants.CONDITION_SHOWTIME.equalsIgnoreCase(condition)) {
			if (!checkForShowtimeRestriction(purchase, value, operator)) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	public boolean checkForCityRestriction(Purchase purchase, String value, String operator) {
		Long cityId = getCityFromPurchase();
		Long requireCityId = Long.parseLong(value);
		Set<Long> requireCitIds = getCities(value);
		if (BaseConstants.OPERATOR_EQ.equalsIgnoreCase(operator) && !cityId.equals(requireCityId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_NEQ.equalsIgnoreCase(operator) && cityId.equals(requireCityId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_IN.equalsIgnoreCase(operator) && !requireCitIds.contains(cityId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_NIN.equalsIgnoreCase(operator) && requireCitIds.contains(cityId)) {
			return false;
		}
		return true;
	}

	public boolean checkForTheaterRestriction(Purchase purchase, String value, String operator) {
		Long theaterId = getTheaterIdFromPurchase();
		Long requireTheaterId = Long.parseLong(value);
		Set<Long> requireTheaterIds = getCities(value);
		if (BaseConstants.OPERATOR_EQ.equalsIgnoreCase(operator) && !theaterId.equals(requireTheaterId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_NEQ.equalsIgnoreCase(operator) && theaterId.equals(requireTheaterId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_IN.equalsIgnoreCase(operator) && !requireTheaterIds.contains(theaterId)) {
			return false;
		}
		if (BaseConstants.OPERATOR_NIN.equalsIgnoreCase(operator) && requireTheaterIds.contains(theaterId)) {
			return false;
		}
		return true;
	}

	public boolean checkForNoOfTicketsRestriction(Purchase purchase, String value, String operator) {
		int noOfTickets = purchase.getQuantity();
		int requireTickets = Integer.parseInt(value);
		if (BaseConstants.OPERATOR_EQ.equalsIgnoreCase(operator) && noOfTickets != requireTickets) {
			return false;
		}
		if (BaseConstants.OPERATOR_NEQ.equalsIgnoreCase(operator) && noOfTickets == requireTickets) {
			return false;
		}
		if (BaseConstants.OPERATOR_GT.equalsIgnoreCase(operator) && noOfTickets <= requireTickets) {
			return false;
		}
		if (BaseConstants.OPERATOR_LT.equalsIgnoreCase(operator) && noOfTickets >= requireTickets) {
			return false;
		}
		if (BaseConstants.OPERATOR_GTE.equalsIgnoreCase(operator) && noOfTickets < requireTickets) {
			return false;
		}
		if (BaseConstants.OPERATOR_LTE.equalsIgnoreCase(operator) && noOfTickets > requireTickets) {
			return false;
		}
		return true;
	}

	public boolean checkForShowtimeRestriction(Purchase purchase, String value, String operator) {
		Date ticketTime = getMovieTimeFromPurchase();
		Date requireDatetime = getDate(value);
		if (BaseConstants.OPERATOR_EQ.equalsIgnoreCase(operator) && !requireDatetime.equals(ticketTime)) {
			return false;
		}
		if (BaseConstants.OPERATOR_NEQ.equalsIgnoreCase(operator) && requireDatetime.equals(ticketTime)) {
			return false;
		}
		if (BaseConstants.OPERATOR_GTE.equalsIgnoreCase(operator) && requireDatetime.before(ticketTime)) {
			return false;
		}
		if (BaseConstants.OPERATOR_LTE.equalsIgnoreCase(operator) && requireDatetime.after(ticketTime)) {
			return false;
		}
		return true;
	}

	public Long getCityFromPurchase() {
		return 1l;
	}

	public Long getTheaterIdFromPurchase() {
		return 1l;
	}

	public Date getMovieTimeFromPurchase() {
		return new Date();
	}

	public Set<Long> getCities(String value) {
		Set<String> cities = new HashSet<>(Arrays.asList(value.split(",")));
		return cities.stream().map(Long::parseLong).collect(Collectors.toSet());
	}

	public Set<Long> getTheaters(String value) {
		Set<String> theaters = new HashSet<>(Arrays.asList(value.split(",")));
		return theaters.stream().map(Long::parseLong).collect(Collectors.toSet());
	}

	public Date getDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}


