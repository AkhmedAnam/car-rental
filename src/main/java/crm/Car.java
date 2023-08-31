package crm;

import crm.loyalty.LoyaltyPointsCalcStrategy;
import crm.rental.RentPriceCalcStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Car {
    private final String title;
    private final RentPriceCalcStrategy rentPriceCalcStrategy;
    private final LoyaltyPointsCalcStrategy loyaltyPointsCalcStrategy;
}
