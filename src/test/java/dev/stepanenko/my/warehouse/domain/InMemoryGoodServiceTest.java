package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.Warehouse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InMemoryGoodServiceTest {
    @Test
    public void shouldCreateGoods(){

        String expectedGoods = "newGood";
        InMemoryGoodService service = new InMemoryGoodService();
        service.createGoods(expectedGoods, 100, 12, "warehouse1");

        Good actualGoods = service.getGoods(expectedGoods);
        String actualGoodsName = actualGoods.getName();
        assertEquals(expectedGoods, actualGoodsName);
    }


}
