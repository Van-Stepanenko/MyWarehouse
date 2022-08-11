package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Good;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InMemoryGoodServiceTest {
    @Test
    public void shouldCreateGoods(){

        String expectedGoods = "newGood";
        InMemoryGoodService service = new InMemoryGoodService();
        Good good = new Good();
        good.setName(expectedGoods);
        good.setSku(expectedGoods);
        assertNotNull(service.saveGood(good));
        Good actualGoods = service.getGoods(expectedGoods);
        assertNotNull(actualGoods);
        String actualGoodsName = actualGoods.getName();
        assertEquals(expectedGoods, actualGoodsName);


    }

    @Test
    public void renameGood(){
        String expectedNewName = "БутЫлка";
        String actualNewName;
        String oldName = "БутИлка";
        String sku = "Бутыль001";
        Good good = new Good();
        InMemoryGoodService service = new InMemoryGoodService();
        good.setName(oldName);
        good.setSku(sku);
        service.saveGood(good);
        service.renameGoods(sku,expectedNewName);
        Good actualGood = service.getGoods(sku);
        actualNewName = actualGood.getName();
        assertEquals(expectedNewName, actualNewName);

    }
    @Test
    public void ifGoodOnSkuNotFoundGetException(){
        String oldName = "БутИлка";
        String sku = null;
        Good good = new Good();
        InMemoryGoodService service = new InMemoryGoodService();
        good.setName(oldName);
        good.setSku(sku);
        assertThrows(NotFoundException.class, ()->{
            service.saveGood(good);
        });



    }
    @Test
    public void ifSetNewNameNullGetException(){
        String expectedNewName = null;
        String oldName = "БутИлка";
        String sku = "Бутылка001";
        Good good = new Good();
        InMemoryGoodService service = new InMemoryGoodService();
        good.setName(oldName);
        good.setSku(sku);
        service.saveGood(good);
        assertThrows(NullPointerException.class, ()->{
            service.renameGoods(sku,expectedNewName);
        });
    }
    @Test
    public void shouldDellGood(){
        Good good = new Good();
        String sku = "Ящик12234102";
        InMemoryGoodService service = new InMemoryGoodService();
        good.setName("Ящик");
        good.setSku(sku);
        service.saveGood(good);
        service.deleteGoods(sku);
        assertThrows(NotFoundException.class, ()->{
            service.getGoods(sku);
        });
    }

    @Test
    public void shouldGetExceptionIfGoodNotFound(){
        Good good = new Good();
        String sku = "Ящик12234102";
        String sku2 = "БракованныйЯщик";
        InMemoryGoodService service = new InMemoryGoodService();
        good.setName("Ящик");
        good.setSku(sku);
        service.saveGood(good);
        assertThrows(NotFoundException.class, ()->{
            service.deleteGoods(sku2);
        });
    }

    @Test
    public void shouldGetGood(){
        Good good = new Good();
        String sku3 = null;
        String sku2 = "113";
        String sku = "123";
        String name = "ящик";
        InMemoryGoodService service = new InMemoryGoodService();
        good.setSku(sku);
        good.setName(name);
        service.saveGood(good);
        assertNotNull(service.getGoods(sku));
        assertThrows(NotFoundException.class, ()->{
            service.getGoods(sku2);
        });
        assertThrows(NotFoundException.class, ()->{
            service.getGoods(sku3);
        });
    }

   /* @Test
    public void changeAmount(){
        String sku = "Квас";
        String skuNotFound = "НЕКвас";
        InMemoryGoodService service = new InMemoryGoodService();
        Good good = new Good();
        good.setName(sku);
        good.setSku(sku);
        service.saveGood(good);
        service.changeAmount(sku,125);
        service.saveGood(good);
        int actualAmount = good.getAmount();
        assertEquals(125,actualAmount);
        assertThrows(NullPointerException.class, ()->{
            service.changeAmount(sku,0);
        });
        assertThrows(NotFoundException.class, ()->{
            service.changeAmount(skuNotFound,125);
        });

    }

    @Test
    public void shouldChangeGoodIfBuyGood(){

        Good oldGood = new Good();
        Good newGood = new Good();
        String warehouse = "warehouse1232";
        String sku = "Букварь1232";
        int amount = 12;
        String nameGood = "Букварь за 1 класс";
        InMemoryGoodService service = new InMemoryGoodService();


        oldGood.setAmount(amount);
        oldGood.setName(nameGood);
        oldGood.setSku(sku);
        oldGood.setWarehouse(warehouse);
        service.saveGood(oldGood);

        newGood.setAmount(amount);
        newGood.setName(nameGood);
        newGood.setSku(sku);
        newGood.setWarehouse(warehouse);
        service.saveGood(newGood);
        service.buyGoods(sku, 15,100,warehouse);


        assertNotEquals(oldGood.getAmount(),newGood.getAmount());
        assertEquals(oldGood.getWarehouse(),newGood.getWarehouse());
    }
    @Test
    public void shouldGetExceptionIfGoodNotFoundWhenBuyGood(){


        String warehouse = "warehouse1232";
        String sku = "Букварь1232";
        InMemoryGoodService service = new InMemoryGoodService();

        assertThrows(NotFoundException.class, ()->{
            service.buyGoods(sku, 15,100,warehouse);
        });
    }
    @Test
    public void whenSellingGoodShouldBecomeless(){
        Good oldGood = new Good();
        Good newGood = new Good();
        String warehouse = "warehouse1232";
        String sku = "Букварь1232";
        int amount = 16;
        String nameGood = "Букварь за 1 класс";
        InMemoryGoodService service = new InMemoryGoodService();


        oldGood.setAmount(amount);
        oldGood.setName(nameGood);
        oldGood.setSku(sku);
        oldGood.setWarehouse(warehouse);
        service.saveGood(oldGood);

        newGood.setAmount(amount);
        newGood.setName(nameGood);
        newGood.setSku(sku);
        newGood.setWarehouse(warehouse);
        service.saveGood(newGood);
        service.sellGoods(sku, 15,100,warehouse);
        assert(oldGood.getAmount()>newGood.getAmount());
    }
    @Test
    public void whenSellingGoodMoreThanItWasGetException(){
        Good oldGood = new Good();
        Good newGood = new Good();
        String warehouse = "warehouse1232";
        String sku = "Букварь1232";
        int amount = 1;
        String nameGood = "Букварь за 1 класс";
        InMemoryGoodService service = new InMemoryGoodService();


        oldGood.setAmount(amount);
        oldGood.setName(nameGood);
        oldGood.setSku(sku);
        oldGood.setWarehouse(warehouse);
        service.saveGood(oldGood);

        newGood.setAmount(amount);
        newGood.setName(nameGood);
        newGood.setSku(sku);
        newGood.setWarehouse(warehouse);
        service.saveGood(newGood);

        assertThrows(NullPointerException.class, ()->{
            service.sellGoods(sku, 15,100,warehouse);
        });
    }*/


}
