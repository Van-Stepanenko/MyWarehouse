package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.exception.ChangerException;
import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.GoodAmount;
import dev.stepanenko.my.warehouse.model.Warehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Slf4j
public abstract class AbstractGoodAmountChanger implements GoodAmountChanger {
    final protected WarehouseService warehouseService;

    protected AbstractGoodAmountChanger(WarehouseService warehouseService) {
        if (warehouseService == null) {
            throw new IllegalArgumentException("not null warehouseService mandatory");
        }
        this.warehouseService = warehouseService;
    }

    @Override
    public void change(String sku, int changeAmount, String nameWarehouse, int lastBuyPrice, String nameGood) {

        if (sku == null) {
            throw new ChangerException("Sku should not be null");
        } else if (changeAmount < 0) {
            throw new ChangerException("changeAmount should not be less then 0");
        } else if (nameGood == null) {
            throw new ChangerException("nameGood should not be null");
        } else if (nameWarehouse == null) {
            throw new ChangerException("nameWarehouse should not be null");
        } else if (lastBuyPrice < 0) {
            throw new ChangerException("lastByPrice should not be less then 0 (lastBuyPrice = " + lastBuyPrice);
        } else {

            Warehouse warehouse
                    =
                    warehouseService.getWarehouse(nameWarehouse);
            HashMap<String, GoodAmount> goods = warehouse.getGoods();

            GoodAmount goodAmount = goods.get(sku);

            if (goodAmount == null) {
                Good good = doIfNoGood(sku, nameGood, lastBuyPrice);
                GoodAmount ga = new GoodAmount();
                ga.setGood(good);
                ga.setAmount(changeAmount);
                goods.put(sku, ga);
            } else {
                int amount = doIfGoodPresent(goodAmount.getAmount(), changeAmount);
                goodAmount.setAmount(amount);
            }

           /* goodAmount.setAmount(goodAmount.getAmount() + changeAmount);
            goodAmount.setAmount(goodAmount.getAmount() - changeAmount);*/
            //1. проверить входящие данные на валидность
            //2. Находим склад
            //3. На складе ищем товар по ску и находим amountGood по ску

            //4 a.  товар есть - действие doIfGoodPresent( int changeAmount, int amountGood)
            //4 б. Товара нет - действие doIfNoGood(String sku, int changeAmount, String nameWarehouse)

            //doIfGoodPresent прих - увеличить amountGood на changeAmount

            //doIfGoodPresent расх - проверить, что changeAmount(значение пришло) < чем было amountGood(на складе)
            //doIfGoodPresent расх.a changeAmount <  amountGood бросить исключение
            //doIfGoodPresent расх.б changeAmount >  amountGood вычесть из amountGood changeAmount

            //doIfNoGood прих - товара нет . создать новый товар в количестве changeAmount и сохранить
            //doIfNoGood расх - товара нет. бросить исключение


        }

        //todo прочесть книгу чистая архитектура https://refactoring.guru/ru
    }

    protected abstract int doIfGoodPresent(int amountGood, int changeAmount);


    protected abstract Good doIfNoGood(String sku, String nameGood, int lastBuyPrice);

}