package crm.receipt.impl;

import crm.Car;
import crm.Rental;
import crm.receipt.ReceiptMakingStrategy;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
public class DefaultReceiptStrategy implements ReceiptMakingStrategy {

    @Override
    public String getReceipt(String customerName, List<Rental> rentals) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        long totalLoyaltyPoints = 0;
        final String separator = System.lineSeparator();
        final String tab = "\t";
        final StringBuilder stringBuilder = new StringBuilder("Rental Record for ");
        stringBuilder.append(customerName).append(separator);
        for (Rental rental : rentals) {
            final Car car = rental.getCar();
            final int rentalPeriod = rental.getPeriod();
            BigDecimal thisAmount = car.getRentPriceCalcStrategy().calculateRentPrice(rentalPeriod);
            long loyaltyPoints = car.getLoyaltyPointsCalcStrategy().calculateLoyaltyPoints(rentalPeriod);
            totalLoyaltyPoints += loyaltyPoints;
            stringBuilder.append(tab).append(car.getTitle()).append(tab)
                .append(thisAmount.setScale(2, RoundingMode.CEILING)).append(separator);
            totalAmount = totalAmount.add(thisAmount);
        }
        stringBuilder.append("Amount price is ")
            .append(totalAmount.setScale(2, RoundingMode.CEILING))
            .append("$").append(separator)
            .append("You earned ").append(totalLoyaltyPoints).append(" loyalty points");

        return stringBuilder.toString();
    }
}
