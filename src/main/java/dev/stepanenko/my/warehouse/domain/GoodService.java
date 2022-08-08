package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;

public interface GoodService {
    void createGoods (Good good);
    void renameGoods (String oldNameGoods, String newNameGoods);
    void deleteGoods (String nameGoods);
    Good getGoods (String nameGoods);
    void changeAmount (String nameGoods, int newAmount);
    void buyGoods(String nameGoods, int amount, int lastByPrice, String warehouse);
    void sellGoods(String nameGoods, int amount, int lastSellPrice);
    void changeWarehouse(String nameGoods,int amount, String oldWarehouse,String newWarehouse);
}
