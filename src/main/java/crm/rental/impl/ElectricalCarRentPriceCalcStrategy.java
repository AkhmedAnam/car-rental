package crm.rental.impl;

import crm.rental.RentPriceCalcStrategy;
import java.math.BigDecimal;

/**
 * 29.08.2023
 *
 * @author a.anam
 */
public class ElectricalCarRentPriceCalcStrategy implements RentPriceCalcStrategy {
    private static final long INITIAL_PRICE = 15;
    private static final long DAYS_THRESHOLD = 3;
    @Override
    public BigDecimal calculateRentPrice(int rentPeriod) {
        BigDecimal price = BigDecimal.valueOf(INITIAL_PRICE);
        if(rentPeriod > DAYS_THRESHOLD){
            long delta = (rentPeriod - DAYS_THRESHOLD) * INITIAL_PRICE;
            price = price.add(BigDecimal.valueOf(delta));
        }
        return price;
    }
}
