package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AbstractGoodAmountChangerTest {

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


    @BeforeEach
    void setUp(){
        AbstractGoodAmountChanger abstractGoodAmountChanger = new AbstractGoodAmountChanger() {

            @Override
            int doIfGoodPresent(int amountGood, int changeAmount) {
                return 0;
            }

            @Override
            Good doIfNoGood(String sku, String nameGood, int lastBuyPrice) {
                return null;
            }
        }
    }



}