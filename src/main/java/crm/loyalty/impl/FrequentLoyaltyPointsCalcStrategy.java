package crm.loyalty.impl;

import crm.loyalty.LoyaltyPointsCalcStrategy;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
public class FrequentLoyaltyPointsCalcStrategy implements LoyaltyPointsCalcStrategy {
    private static final long POINTS_FOR_FREQUENT_USE = 1L;
    @Override
    public long calculateLoyaltyPoints(int rentPeriod) {
        return POINTS_FOR_FREQUENT_USE;
    }
}
