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
import com.mybooking.demo.model.rdbms.PromotionRestriction;
import com.mybooking.demo.model.rdbms.Purchase;

@Service
public class PromotionRestictionEngine extends BaseServiceImpl {

	public boolean isConditionFulfilled(Purchase purchase, PromotionRestriction restriction) {
		String condition = restriction.getConditionType();
		String operator = restriction.getConditionOperator();
		String value = restriction.getConditionValue();

		if ("city".equalsIgnoreCase(condition)) {
			if (!checkForCityRestriction(purchase, value, operator)) {
				return false;
			}
		} else if ("theater".equalsIgnoreCase(condition)) {
			if (!checkForTheaterRestriction(purchase, value, operator)) {
				return false;
			}
		} else if ("nooftickets".equalsIgnoreCase(condition)) {
			if (!checkForNoOfTicketsRestriction(purchase, value, operator)) {
				return false;
			}
		} else if("showtime".equalsIgnoreCase(condition)) {
			if(!checkForShowtimeRestriction(purchase, value, operator)) {
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
		if ("eq".equalsIgnoreCase(operator) && !cityId.equals(requireCityId)) {
			return false;
		}
		if ("neq".equalsIgnoreCase(operator) && cityId.equals(requireCityId)) {
			return false;
		}
		if ("in".equalsIgnoreCase(operator) && !requireCitIds.contains(cityId)) {
			return false;
		}
		if ("nin".equalsIgnoreCase(operator) && requireCitIds.contains(cityId)) {
			return false;
		}
		return true;
	}

	public boolean checkForTheaterRestriction(Purchase purchase, String value, String operator) {
		Long theaterId = getTheaterIdFromPurchase();
		Long requireTheaterId = Long.parseLong(value);
		Set<Long> requireTheaterIds = getCities(value);
		if ("eq".equalsIgnoreCase(operator) && !theaterId.equals(requireTheaterId)) {
			return false;
		}
		if ("neq".equalsIgnoreCase(operator) && theaterId.equals(requireTheaterId)) {
			return false;
		}
		if ("in".equalsIgnoreCase(operator) && !requireTheaterIds.contains(theaterId)) {
			return false;
		}
		if ("nin".equalsIgnoreCase(operator) && requireTheaterIds.contains(theaterId)) {
			return false;
		}
		return true;
	}

	public boolean checkForNoOfTicketsRestriction(Purchase purchase, String value, String operator) {
		int noOfTickets = purchase.getQuantity();
		int requireTickets = Integer.parseInt(value);
		if ("eq".equalsIgnoreCase(operator) && noOfTickets != requireTickets) {
			return false;
		}
		if ("neq".equalsIgnoreCase(operator) && noOfTickets == requireTickets) {
			return false;
		}
		if ("gt".equalsIgnoreCase(operator) && noOfTickets <= requireTickets) {
			return false;
		}
		if ("lt".equalsIgnoreCase(operator) && noOfTickets >= requireTickets) {
			return false;
		}
		if ("gte".equalsIgnoreCase(operator) && noOfTickets < requireTickets) {
			return false;
		}
		if ("lte".equalsIgnoreCase(operator) && noOfTickets > requireTickets) {
			return false;
		}
		return true;
	}
	
	public boolean checkForShowtimeRestriction(Purchase purchase, String value, String operator) {
		Date ticketTime = getMovieTimeFromPurchase();
		Date requireDatetime = getDate(value);
		if ("eq".equalsIgnoreCase(operator) && !requireDatetime.equals(ticketTime)) {
			return false;
		}
		if ("neq".equalsIgnoreCase(operator) && requireDatetime.equals(ticketTime)) {
			return false;
		}
		if ("gte".equalsIgnoreCase(operator) && requireDatetime.before(ticketTime)) {
			return false;
		}
		if ("lte".equalsIgnoreCase(operator) && requireDatetime.after(ticketTime)) {
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
