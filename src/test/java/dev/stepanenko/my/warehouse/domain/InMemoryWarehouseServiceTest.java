package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.exception.BusinessException;
import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.GoodAmount;
import dev.stepanenko.my.warehouse.model.Warehouse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryWarehouseServiceTest {
    @Test
    public void shouldMemorizeWarehouse() {

        Warehouse expectedWarehouse = new Warehouse();
        expectedWarehouse.setWarehouseName("newName");

        HashMap<String, GoodAmount> goods = new HashMap<>();
        expectedWarehouse.setGoods(goods);

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse("newName");
        Warehouse actualWarehouse = service.getWarehouse("newName");

        assertEquals(expectedWarehouse, actualWarehouse);
    }

    @Test
    public void shouldMemorizeNameWarehouse() {

        String expectedName = "warehouse1";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(expectedName);

        Warehouse warehouse = service.getWarehouse(expectedName);
        String actualName = warehouse.getWarehouseName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void createTwoTimes() {
        String name1 = "name1";
        String name2 = "name2";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name1);
        service.createWarehouse(name2);

        Warehouse warehouse1 = service.getWarehouse(name1);
        Warehouse warehouse2 = service.getWarehouse(name2);

        assertNotEquals(warehouse1, warehouse2);
        assertNotNull(warehouse1);
        assertNotNull(warehouse2);

    }


    @Disabled
    @Test
    public void notCreateWarehouseWithSameNameTwice() {
        String name1 = "name1";
        String name2 = "name2";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name1);
        service.createWarehouse(name1);

        Warehouse warehouse1 = service.getWarehouse(name1);
        Warehouse warehouse2 = service.getWarehouse(name2);

        assertNotEquals(warehouse1, warehouse2);

    }



    @Test
    void shouldRenameWarehouse() {

        String oldName = "name1";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);

        service.renameWarehouse(oldName, newName);

        Warehouse warehouse = service.getWarehouse(newName);

        String actualName = warehouse.getWarehouseName();
        assertEquals("name2", actualName);
    }

    @Test
    void shouldGetErrorIfNotFoundOldName() {
        String oldName = "name1";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();

        assertThrows(NotFoundException.class, () -> {
            service.renameWarehouse(oldName, newName);
        });
    }

    @Test
    void shouldGetErrorIfNewNameMatchesWithAnotherWarehouse() {

        String oldName = "name1";
        String nameAnotherWarehouse = "name2";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);//1
        service.createWarehouse(nameAnotherWarehouse);//2
        assertThrows(BusinessException.NameMatchException.class, () -> {
            service.renameWarehouse(oldName, newName);
        });

    }

    @Test
    void shouldGetErrorIfNameWarehouseIsNull() {

        String oldName = "name1";
        String newName = null;

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);

        service.renameWarehouse(oldName, newName);

        assertThrows(NotFoundException.class, () -> {
            service.renameWarehouse(oldName, newName);
        });
    }

    @Test
    void shouldGetErrorIfNewWarehouseIsNull() {

        String name1 = null;
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        assertThrows(NullPointerException.class, () -> {
            service.createWarehouse(name1);
        });
    }

    @Test
    void shouldDellWarehouse() {
        String name = "name1";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name);

        service.deleteWarehouse(name);
        assertThrows(NotFoundException.class, () -> {
            Warehouse warehouse = service.getWarehouse(name);
        });


    }

    @Test
    void shouldGetErrorIfDellWarehouseNotFound() {
        String name = "name1";

        InMemoryWarehouseService service = new InMemoryWarehouseService();

        assertThrows(NotFoundException.class, () -> {
            service.deleteWarehouse(name);
        });
    }

    @Test
    void shouldGetExceptionIfWarehouseGetNotFound() {
        String name = "name";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        assertThrows(NotFoundException.class, () -> {
            service.getWarehouse(name);
        });
    }

    @Test
    void shouldSaveGoodInWarehouse() {
        String nameWarehouse = "Склад1";
        String nameWarehouse2 = "Склад2";
        String sku = "12147";
        String nameGood = "Вода";
        int amountGood = 15;
        int amountGood2 = 15;
        int lastBuyPrice = 40;
        InMemoryWarehouseService service = new InMemoryWarehouseService();

        service.createWarehouse(nameWarehouse);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastBuyPrice);

        service.createWarehouse(nameWarehouse2);
        service.buyGoods(nameWarehouse2, sku, nameGood, amountGood2, lastBuyPrice);

        Warehouse warehouse1 = service.getWarehouse(nameWarehouse);
        Warehouse warehouse2 = service.getWarehouse(nameWarehouse2);

        assertEquals(warehouse1.getGoods(), warehouse2.getGoods());
    }

    @Test
    void shouldSaveGoodTwice() {
        String nameWarehouse = "Склад1";
        String nameWarehouse2 = "Склад2";
        String sku = "12147";
        String nameGood = "Вода";
        int amountGood = 15;
        int amountGood2 = 30;
        int lastBuyPrice = 40;
        int lastBuyPrice2 = 42;
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(nameWarehouse);
        service.createWarehouse(nameWarehouse2);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastBuyPrice);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastBuyPrice2);
        service.buyGoods(nameWarehouse2, sku, nameGood, amountGood2, lastBuyPrice2);

        Warehouse warehouse1 = service.getWarehouse(nameWarehouse);
        Warehouse warehouse2 = service.getWarehouse(nameWarehouse2);
        assertEquals(warehouse1.getGoods(), warehouse2.getGoods());

    }

    @Test
    void shouldSellGoodFromWarehouse() {
        String nameWarehouse = "Склад1";
        String nameWarehouse2 = "Склад2";
        String sku = "12147";
        String nameGood = "Вода";
        int amountGood = 40;
        int amountGood2 = 20;
        int lastSellPrice = 25;
        InMemoryWarehouseService service = new InMemoryWarehouseService();

        service.createWarehouse(nameWarehouse);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastSellPrice);
        service.sellGoods(nameWarehouse, sku, nameGood, amountGood2, lastSellPrice);


        service.createWarehouse(nameWarehouse2);
        service.buyGoods(nameWarehouse2, sku, nameGood, amountGood2, lastSellPrice);

        Warehouse warehouse1 = service.getWarehouse(nameWarehouse);
        Warehouse warehouse2 = service.getWarehouse(nameWarehouse2);

        assertEquals(warehouse1.getGoods(), warehouse2.getGoods());
    }

    @Test
    void shouldNotSellGoodFromWarehouse() {
        String nameWarehouse = "Склад1";
        String sku = "12147";
        String nameGood = "Вода";
        int amountGood = 40;
        int amountGood2 = 41;
        int lastSellPrice = 25;
        InMemoryWarehouseService service = new InMemoryWarehouseService();

        service.createWarehouse(nameWarehouse);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastSellPrice);

        assertThrows(NotFoundException.class, () -> {
            service.sellGoods(nameWarehouse, sku, nameGood, amountGood2, lastSellPrice);
        });

    }

    @Test
    void shouldGetGoodFromWarehouse() {
        String nameWarehouse = "Склад1";
        String sku = "12147";
        String sku2 = "12141";
        String nameGood = "Вода";
        int amountGood = 15;
        int lastBuyPrice = 40;
        InMemoryWarehouseService service = new InMemoryWarehouseService();

        GoodAmount goodAmount = new GoodAmount();
        goodAmount.setAmount(amountGood);
        Good good = new Good();
        good.setName(nameGood);
        good.setSku(sku);
        good.setLastBuyPrice(lastBuyPrice);
        goodAmount.setGood(good);

        service.createWarehouse(nameWarehouse);
        service.buyGoods(nameWarehouse, sku, nameGood, amountGood, lastBuyPrice);


        assertEquals(goodAmount, service.getGoodAmount(nameWarehouse, sku));
    }

}