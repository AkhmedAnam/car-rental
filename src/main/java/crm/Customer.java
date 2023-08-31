package crm;

import crm.receipt.ReceiptMakingStrategy;
import crm.receipt.impl.DefaultReceiptStrategy;
import java.util.List;
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
    private final List<Rental> rentals;
    @Getter
    @Setter
    private ReceiptMakingStrategy receiptMakingStrategy = new DefaultReceiptStrategy();

    public String getReceipt() {
        return receiptMakingStrategy.getReceipt(getName(), rentals);
    }
}
