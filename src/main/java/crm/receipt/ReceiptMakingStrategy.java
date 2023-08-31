package crm.receipt;

import crm.Rental;
import java.util.List;

/**
 * 30.08.2023
 *
 * @author a.anam
 */
public interface ReceiptMakingStrategy {
    String getReceipt(String customerName, List<Rental> rentals);
}
