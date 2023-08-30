package crm;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
public class LoyaltyPointsDecoratorBuilder {
    private LoyaltyPointsCalcStrategy loyaltyPointsCalcStrategy;

    public LoyaltyPointsDecoratorBuilder startWith(LoyaltyPointsCalcStrategy loyaltyPointsCalcStrategy) {
        this.loyaltyPointsCalcStrategy = loyaltyPointsCalcStrategy;
        return this;
    }
    public LoyaltyPointsDecoratorBuilder decorate(LoyaltyPointsDecorator loyaltyPointsDecorator) {
        loyaltyPointsDecorator.setStrategy(loyaltyPointsCalcStrategy);
        loyaltyPointsCalcStrategy = loyaltyPointsDecorator;
        return this;
    }

    public LoyaltyPointsCalcStrategy build() {
        return loyaltyPointsCalcStrategy;
    }
}
