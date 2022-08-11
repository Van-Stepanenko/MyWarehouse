package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.exception.BusinessException;
import dev.stepanenko.my.warehouse.model.Good;
import dev.stepanenko.my.warehouse.model.GoodAmount;
import dev.stepanenko.my.warehouse.model.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryWarehouseService implements WarehouseService {

    private HashMap<String, Warehouse> warehouses = new HashMap<>();

    @Override
    public void createWarehouse(String nameWarehouse) {
        Warehouse newWarehouse = new Warehouse();

        if (nameWarehouse == null) { // Если новое имя null
            throw new NullPointerException("Warehouse name not  can be null");//IllegalArgumentException вместо NullPoint
        } else if (warehouses.containsKey(nameWarehouse)) { // если новое имя warehouse совпадает с тем, что уже есть в HashMap(е)
            throw new BusinessException.NameMatchException(505, "Warehouse name matches existing");
        } else {
            newWarehouse.setWarehouseName(nameWarehouse);
            HashMap<String, GoodAmount> goods = new HashMap<>();
            newWarehouse.setGoods(goods);
            warehouses.put(nameWarehouse, newWarehouse);
        }


    }

    @Override
    public void renameWarehouse(String warehouseName, String newNameWarehouse) {


        Warehouse warehouse = warehouses.get(warehouseName);
        if (warehouse == null) {
            throw new NotFoundException(404, "Warehouse name not  can be null");

        } else if (warehouse.getWarehouseName() == null) {
            throw new NotFoundException(404, "Warehouse name not  can be null");
        } else if (warehouses.containsKey(newNameWarehouse)) {
            throw new BusinessException.NameMatchException(505, "Warehouse name matches existing");
        } else { // если все ок

            warehouse.setWarehouseName(newNameWarehouse);
            warehouses.put(newNameWarehouse, warehouse);
        }
    }

    @Override
    public void deleteWarehouse(String nameWarehouse) {
        Warehouse warehouse = warehouses.get(nameWarehouse);
        if (warehouse == null) {
            throw new NotFoundException(404, "Warehouse name not  can be null");
        } else
            warehouses.remove(nameWarehouse);
    }

    @Override
    public Warehouse getWarehouse(String nameWarehouse) {
        if (warehouses.get(nameWarehouse) == null) {
            throw new NotFoundException(404, "Warehouse not found");
        } else
            return warehouses.get(nameWarehouse);


    }

    @Override
    public void buyGoods(String nameWarehouse, String sku, String nameGood, int amountGood, int lastBuyPrice) {
        if (amountGood<1){
            throw new NullPointerException("amount not  can be <1");
        }
        else if (lastBuyPrice<1){
            throw new NullPointerException("lastBuyPrice not  can be <1");
        }
        else {
            Warehouse warehouse = warehouses.get(nameWarehouse);
            GoodAmount goodAmount = new GoodAmount();
            goodAmount.setAmount(amountGood);
            Good good = new Good();
            good.setName(nameGood);
            good.setSku(sku);
            good.setLastBuyPrice(lastBuyPrice);
            goodAmount.setGood(good);


            HashMap<String, GoodAmount> goodsHashMap = warehouse.getGoods();

            if(!warehouse.getGoods().containsKey(sku)){

                goodAmount.setAmount(amountGood);
                goodsHashMap.put(sku, goodAmount);
                warehouse.setGoods(goodsHashMap);

            }
            else {
                GoodAmount goodAmountOld = goodsHashMap.get(sku);
                goodAmount.setAmount(goodAmountOld.getAmount()+amountGood);
                goodsHashMap.put(sku,goodAmount);
                warehouse.setGoods(goodsHashMap);

            }

        }
    }

    @Override
    public void sellGoods(String nameWarehouse, String sku, String nameGood, int amountGood, int lastSellPrice) {
        if (amountGood<1){
            throw new NullPointerException("amount not  can be <1");
        }
        else if (lastSellPrice<1){
            throw new NullPointerException("lastBuyPrice not  can be <1");
        }
        else {
            Warehouse warehouse = warehouses.get(nameWarehouse);
            GoodAmount goodAmount = new GoodAmount();
            goodAmount.setAmount(amountGood);
            Good good = new Good();
            good.setName(nameGood);
            good.setSku(sku);
            good.setLastBuyPrice(lastSellPrice);
            goodAmount.setGood(good);


            HashMap<String, GoodAmount> goodsHashMap = warehouse.getGoods();

            if(!warehouse.getGoods().containsKey(sku)){
                throw new NotFoundException(404, "Good not found");
            }
            else {
                GoodAmount goodAmountOld = goodsHashMap.get(sku);
                if(goodAmountOld.getAmount()<amountGood){
                    throw new NotFoundException(404, "Not enough goods in warehouse");
                }
                else {
                    goodAmount.setAmount(goodAmountOld.getAmount() - amountGood);
                    goodsHashMap.put(sku, goodAmount);
                    warehouse.setGoods(goodsHashMap);
                }
            }

        }
    }

    @Override
    public GoodAmount getGoodAmount(String nameWarehouse, String sku) {
        Warehouse warehouse = warehouses.get(nameWarehouse);
        return warehouse.getGoods().get(sku);
    }

}
