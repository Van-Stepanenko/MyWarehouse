package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.GoodAmount;
import dev.stepanenko.my.warehouse.model.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OutcomeAmountChangerTest {
    String sku = "sku";
    int amount = 5;
    String nameWarehouse = "warehouse";
    int lastByPrice = 12;
    String nameGood = "fish";


    @Test
    void shouldDecreaseAmount() {
        Good good = new Good();
        good.setName(nameGood);
        good.setSku(sku);
        good.setLastBuyPrice(lastByPrice);
        GoodAmount goodAmount = new GoodAmount();
        goodAmount.setAmount(amount);
        goodAmount.setGood(good);
        HashMap<String, GoodAmount> hashMapGoodAmount = new HashMap<>();
        hashMapGoodAmount.put(sku, goodAmount);

        WarehouseService warehouseService = new InMemoryWarehouseService();
        warehouseService.createWarehouse(nameWarehouse);
        warehouseService.getWarehouse(nameWarehouse).setGoods(hashMapGoodAmount);

        OutcomeAmountChanger outcomeAmountChanger = new OutcomeAmountChanger(warehouseService);
        outcomeAmountChanger.change(sku,2,nameWarehouse,lastByPrice,nameGood);

        Warehouse warehouse = warehouseService.getWarehouse(nameWarehouse);//у экземпляра какого класса мы будем требовать дать нам верхаус по имени верхауснейм
        assertEquals(3,  warehouse.getGoods().get(sku).getAmount());
    }
    
}