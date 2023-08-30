package crm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class LoyaltyPointsDecorator implements LoyaltyPointsCalcStrategy{
    @Getter
    @Setter
    private LoyaltyPointsCalcStrategy strategy;

    @Override
    public long calculateLoyaltyPoints(int rentPeriod) {
        return strategy != null ? strategy.calculateLoyaltyPoints(rentPeriod) : 0;
    }

    public static LoyaltyPointsDecoratorBuilder builder(){
        return new LoyaltyPointsDecoratorBuilder();
    }
}
