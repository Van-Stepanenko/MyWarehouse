package dev.stepanenko.my.warehouse.domain;

public interface GoodAmountChanger {
    void change(String sku, int amountGood, String nameWarehouse, int lastBuyPrice, String nameGood);

}
