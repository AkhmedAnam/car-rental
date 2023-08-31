package crm.loyalty;

/**
 * 29.08.2023
 *
 * @author a.anam
 */
public interface LoyaltyPointsCalcStrategy {
    long calculateLoyaltyPoints(int rentPeriod);
}
