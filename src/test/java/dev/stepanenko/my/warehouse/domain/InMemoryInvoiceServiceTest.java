package dev.stepanenko.my.warehouse.domain;


import dev.stepanenko.my.warehouse.model.Warehouse;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryInvoiceServiceTest {
    String filePath = "C:\\Users\\Ivan\\IdeaProjects\\MyWarehouse\\src\\main\\java\\dev\\stepanenko\\my\\warehouse\\invoice\\";

    @Test
    public void createInvoice() {

        String nameInvoice = "nameInvoice2";
        boolean actualName = false;
        InMemoryInvoiceService inMemoryInvoiceService = new InMemoryInvoiceService();

        inMemoryInvoiceService.createInvoice(nameInvoice);

        File f = new File(filePath + nameInvoice + ".txt");
        if(f.exists()){
            actualName = true;
        }
        assertEquals(true, actualName);
    }
    @Test
    public void deleteInvoice() {

        String nameInvoice = "nameInvoiceDell";
        boolean actualName = false;
        InMemoryInvoiceService inMemoryInvoiceService = new InMemoryInvoiceService();

        inMemoryInvoiceService.createInvoice(nameInvoice);
        inMemoryInvoiceService.deleteInvoice(nameInvoice);
        File f = new File(filePath + nameInvoice + ".txt");
        if(!f.exists()){
            actualName = true;
        }
        assertEquals(true, actualName);
    }


    @Test
    public void renameInvoice() {

        String nameInvoice = "nameInvoice7778";
        String nameInvoiceNew = "newNameInvoice";
        boolean actualName = false;
        InMemoryInvoiceService inMemoryInvoiceService = new InMemoryInvoiceService();

        inMemoryInvoiceService.createInvoice(nameInvoice);
        inMemoryInvoiceService.putInvoice(nameInvoice,nameInvoiceNew);
        File f = new File(filePath + nameInvoice + ".txt");
        File f2 = new File(filePath + nameInvoiceNew + ".txt");
        if(!f.exists()&&f2.exists()){
            actualName = true;
        }
        assertEquals(true, actualName);
    }


    @Test
    public void createInvoiceNote() throws IOException {

        String nameInvoice = "nameInvoice2555";
        String goodInfo = "bla bla bla3";
        boolean actualName = false;
        InMemoryInvoiceService inMemoryInvoiceService = new InMemoryInvoiceService();

        //inMemoryInvoiceService.createInvoice(nameInvoice);
        inMemoryInvoiceService.addANoteToInvoice(nameInvoice,goodInfo);

        File f = new File(filePath + nameInvoice + ".txt");
        if(f.exists()){
            actualName = true;
        }
        assertEquals(true, actualName);
    }

    @Test
    void shouldSaveGoodInWarehouse() throws IOException {
        String nameWarehouse = "Склад1";
        String nameWarehouse2 = "Склад2";
        String sku = "12147324";
        String nameGood = "Нефть";
        int amountGood = 15;
        int amountGood2 = 15;
        int lastBuyPrice = 40;
        InMemoryWarehouseService service = new InMemoryWarehouseService();

        service.createWarehouse(nameWarehouse);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastBuyPrice);

        service.createWarehouse(nameWarehouse2);
        service.buyGoods(nameWarehouse2, sku, nameGood, amountGood2, lastBuyPrice);
        service.buyGoods(nameWarehouse2, sku, nameGood, amountGood2, lastBuyPrice);
        service.sellGoods(nameWarehouse2, sku, nameGood, amountGood2 , lastBuyPrice);

        Warehouse warehouse1 = service.getWarehouse(nameWarehouse);
        Warehouse warehouse2 = service.getWarehouse(nameWarehouse2);

        assertEquals(warehouse1.getGoods(), warehouse2.getGoods());
    }
}
