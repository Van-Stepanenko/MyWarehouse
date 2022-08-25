package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;
import org.springframework.stereotype.Service;

@Service
public class OutcomeAmountChanger extends AbstractGoodAmountChanger{

    @Override
    int doIfGoodPresent(int amountGood, int changeAmount) {
        if (changeAmount <  amountGood){
            throw new RuntimeException("На складе товара меньше, чем хотите отгрузить");
        }else {
        return amountGood - changeAmount;
        }
    }

    @Override
    Good doIfNoGood(String sku, String nameGood, int lastBuyPrice) {
        throw new RuntimeException("На складе нет товара, который хотите отгрузить");

    }
}
