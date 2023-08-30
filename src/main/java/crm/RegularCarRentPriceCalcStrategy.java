package crm;

import java.math.BigDecimal;

/**
 * 29.08.2023
 *
 * @author a.anam
 */
public class RegularCarRentPriceCalcStrategy implements RentPriceCalcStrategy{

    private static final int FACTOR = 10;
    @Override
    public BigDecimal calculateRentPrice(int rentPeriod) {
        return BigDecimal.valueOf((long) rentPeriod * FACTOR);
    }
}
