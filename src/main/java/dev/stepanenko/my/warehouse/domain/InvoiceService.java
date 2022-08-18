package dev.stepanenko.my.warehouse.domain;

import java.io.IOException;

public interface InvoiceService {
    void createInvoice(String nameInvoice);
    void deleteInvoice(String nameInvoice);
    void putInvoice(String nameInvoice, String newName);
    void addANoteToInvoice(String nameInvoice, String goodInfo) throws IOException;

}
