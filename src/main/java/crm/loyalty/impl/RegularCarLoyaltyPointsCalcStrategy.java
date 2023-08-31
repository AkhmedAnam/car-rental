package crm.loyalty.impl;

import crm.loyalty.LoyaltyPointsDecorator;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
public class RegularCarLoyaltyPointsCalcStrategy extends LoyaltyPointsDecorator {

    private static final int RENT_THRESHOLD = 1;
    private static final int BONUS_POINTS_TO_ADD = 1;

    @Override
    public long calculateLoyaltyPoints(int rentPeriod) {
        long loyaltyPoints = super.calculateLoyaltyPoints(rentPeriod);
        if (rentPeriod > RENT_THRESHOLD) {
            loyaltyPoints += BONUS_POINTS_TO_ADD;
        }
        return loyaltyPoints;
    }
}
