package crm;

import crm.loyalty.LoyaltyPointsCalcStrategy;
import crm.loyalty.LoyaltyPointsDecorator;
import crm.loyalty.impl.FrequentLoyaltyPointsCalcStrategy;
import crm.loyalty.impl.RegularCarLoyaltyPointsCalcStrategy;
import crm.receipt.ReceiptPrinter;
import crm.receipt.impl.ConsoleReceiptPrinter;
import crm.rental.impl.ElectricalCarRentPriceCalcStrategy;
import crm.rental.impl.RegularCarRentPriceCalcStrategy;
import crm.rental.impl.SportCarRentPriceCalcStrategy;
import java.util.LinkedList;

public class Main {

    public static final Car FERRARI;
    public static final Car FORD;
    public static final Car TESLA;

    static {
        final FrequentLoyaltyPointsCalcStrategy frequentLoyaltyPointsCalcStrategy = new FrequentLoyaltyPointsCalcStrategy();
        FERRARI = new Car("Ferrari F40", new SportCarRentPriceCalcStrategy(), frequentLoyaltyPointsCalcStrategy);
        final LoyaltyPointsCalcStrategy regularCarLoyaltyPointsCalcStrategy = LoyaltyPointsDecorator.builder()
            .startWith(frequentLoyaltyPointsCalcStrategy)
            .decorate(new RegularCarLoyaltyPointsCalcStrategy())
            .build();
        FORD = new Car("Ford Focus", new RegularCarRentPriceCalcStrategy(), regularCarLoyaltyPointsCalcStrategy);
        TESLA = new Car("Tesla model 3", new ElectricalCarRentPriceCalcStrategy(), frequentLoyaltyPointsCalcStrategy);
    }
    public static void main(String[] args) {
        LinkedList<Rental> rentals = new LinkedList<>();
        rentals.add(new Rental(FERRARI, 1));
        rentals.add(new Rental(FORD, 4));
        rentals.add(new Rental(TESLA, 5));

        Customer customer = new Customer("Vasiliy Pupkin", rentals);

        final String receipt = customer.getReceipt();
        ReceiptPrinter receiptPrinter = new ConsoleReceiptPrinter();
        receiptPrinter.print(receipt);
    }
}
