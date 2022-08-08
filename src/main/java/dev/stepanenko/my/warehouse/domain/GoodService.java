package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;

public interface GoodService {
    Good saveGood(Good good);
    void renameGoods (String sku, String newNameGoods);
    void deleteGoods (String sku);
    Good getGoods (String sku);
    void changeAmount (String sku, int newAmount);
    void buyGoods(String sku, int amount, int lastByPrice, String warehouse);
    void sellGoods(String sku, int amount, int lastSellPrice);
    void changeWarehouse(String sku,int amount, String oldWarehouse,String newWarehouse);
}
