package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;

public interface GoodService {
    Good saveGood(Good good);
    void renameGoods (String sku, String newNameGoods);
    void deleteGoods (String sku);
    Good getGoods (String sku);
    Good createGood(String sku, String nameGoods);
    void setLastBuyPrise(String sku, int lastBuyPrice);
    void setLastSellPrice(String sku, int lastSellPrice);

}
