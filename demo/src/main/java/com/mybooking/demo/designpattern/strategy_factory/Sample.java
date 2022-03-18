package com.mybooking.demo.designpattern.strategy_factory;

import java.util.HashMap;
import java.util.Optional;

import com.mybooking.demo.constant.BaseConstants;
import com.mybooking.demo.model.rdbms.Purchase;

public class Sample {

}

/* 
==========================================================================
Strategy Pattern: Replace Conditional Logic with Strategy.
( Strategy + Factory Design Pattern )
( By using factory + Map method. ) 
==========================================================================
public interface ValidateRestriction {
	Boolean validate(Purchase purchase, String value, String operator);
}

public class CityValidate implements ValidateRestriction {
    @Override
    public Boolean validate(Purchase purchase, String value, String operator) {
    	// main logic like PromotionRestrictionEngine.checkForCityRestriction
        return true;
    }
}
public class TheaterValidate implements ValidateRestriction {
    @Override
    public Boolean validate(Purchase purchase, String value, String operator) {
    	// main logic like PromotionRestrictionEngine.checkForTheaterRestriction
        return true;
    }
}
... same for the noOfTickets, showtime etc...


public class RestrictionFactory {
    static Map<String, ValidateRestriction> validateRestrictionMap = new HashMap<>();
    static {
    	validateRestrictionMap.put(BaseConstants.CONDITION_CITY, new CityValidate());
    	validateRestrictionMap.put(BaseConstants.CONDITION_THEATER, new TheaterValidate());
    	validateRestrictionMap.put(BaseConstants.CONDITION_NOOFTICKETS, new NoOfTicketsValidate());
    	validateRestrictionMap.put(BaseConstants.CONDITION_SHOWTIME, new ShowTimeValidate());
    }

    public static Optional<ValidateRestriction> getValidateRestriction(String operator) {
        return Optional.ofNullable(validateRestrictionMap.get(operator));
    }
}

// we can use the below method instead of promotionEngine.isConditionFulfilled
public Boolean calculateUsingFactory(Purchase purchase, String value, String operator) {

	ValidateRestriction targetOperation = RestrictionFactory
      .getValidateRestriction(purchase, value, operator)  // value: city , operation:equal
      .orElseThrow(() -> new IllegalArgumentException("Invalid Restriction"));
      
    return targetOperation.validate(purchase, value, operator);
}


*/


/*
==========================================================================
( Strategy + Factory Design Pattern )
( By using factory + Enum method. )
==========================================================================
 Instead of Factory + conditions in Map.... we can directly use Enum
  
*/


