package crm.receipt.impl;

import crm.receipt.ReceiptPrinter;

/**
 * 31.08.2023
 *
 * @author a.anam
 */
public class ConsoleReceiptPrinter implements ReceiptPrinter {
    @Override
    public void print(String receipt) {
        System.out.println(receipt);
    }
}
