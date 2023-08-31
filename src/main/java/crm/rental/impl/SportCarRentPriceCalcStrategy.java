package crm.rental.impl;

import crm.rental.RentPriceCalcStrategy;
import java.math.BigDecimal;

/**
 * 29.08.2023
 *
 * @author a.anam
 */
public class SportCarRentPriceCalcStrategy implements RentPriceCalcStrategy {
    private static final long INITIAL_PRICE = 30;
    private static final long DAYS_TO_SUBSTRACT = 2;

    @Override
    public BigDecimal calculateRentPrice(int rentPeriod) {
        BigDecimal price = new BigDecimal(INITIAL_PRICE);
        if(rentPeriod > DAYS_TO_SUBSTRACT){
            final long delta = (rentPeriod - DAYS_TO_SUBSTRACT) * INITIAL_PRICE;
            price = price.add(BigDecimal.valueOf(delta));
        }
        return price;
    }
}
