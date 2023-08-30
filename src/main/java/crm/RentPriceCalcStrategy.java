package crm;

import java.math.BigDecimal;

/**
 * 29.08.2023
 *
 * @author a.anam
 */
public interface RentPriceCalcStrategy {

    BigDecimal calculateRentPrice(int rentPeriod);
}
