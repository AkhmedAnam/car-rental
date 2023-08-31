package crm;

import crm.receipt.ReceiptMakingStrategy;
import crm.receipt.impl.DefaultReceiptStrategy;
import java.util.LinkedList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {
    @Getter
    private final String name;
    @Getter
    private final LinkedList<Rental> rentals;
    @Getter
    @Setter
    private ReceiptMakingStrategy receiptMakingStrategy = new DefaultReceiptStrategy();

    public String getReceipt() {
        return receiptMakingStrategy.getReceipt(getName(), rentals);
    }
}
