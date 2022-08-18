package dev.stepanenko.my.warehouse.domain;


import dev.stepanenko.my.warehouse.model.GoodAmount;
import dev.stepanenko.my.warehouse.model.Warehouse;

import java.io.IOException;

public interface WarehouseService {
    void createWarehouse (String nameWarehouse);
    void renameWarehouse (String warehouseName, String newNameWarehouse);
    void deleteWarehouse (String nameWarehouse);
    Warehouse getWarehouse (String nameWarehouse);
    void buyGoods(String nameWarehouse, String sku, String nameGood, int amountGood, int lastBuyPrice) throws IOException;
    void sellGoods(String nameWarehouse, String sku, String nameGood, int amountGood, int lastSellPrice) throws IOException;
    GoodAmount getGoodAmount(String nameWarehouse, String sku);
}


