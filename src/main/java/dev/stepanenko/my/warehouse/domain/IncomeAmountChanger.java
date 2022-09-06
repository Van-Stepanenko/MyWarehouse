package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;
import org.springframework.stereotype.Service;



@Service
public class IncomeAmountChanger extends AbstractGoodAmountChanger{

    public IncomeAmountChanger(WarehouseService warehouseService) {
        super(warehouseService);
    }

    @Override
   protected int doIfGoodPresent(int amountGood, int changeAmount) {
        return amountGood+changeAmount;
    }

    @Override
    protected Good doIfNoGood(String sku, String nameGood, int lastBuyPrice) {
       Good good = new Good();
       good.setName(nameGood);
       good.setSku(sku);
       good.setLastBuyPrice(lastBuyPrice);
        return good;
    }
}
