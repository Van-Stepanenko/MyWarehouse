package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.ApiException;
import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Good;

import java.util.HashMap;

public class InMemoryGoodService implements GoodService {


    public class BusinessLayerException extends RuntimeException {
        private int code;

        public BusinessLayerException(int code, String msg) {
            super(msg);
            this.code = code;
        }
    }

    private HashMap<String, Good> goods = new HashMap<>();

    @Override
    public Good saveGood(Good good) {
        if(good.getName() == null){
            throw new NotFoundException(404, "Name can't be null");
        }
        else if(good.getSku() == null){
            throw new NotFoundException(404, "SKU can't be null");
        }
      /* else if (goods.containsKey(good.getName())) {
            throw new BusinessLayerException(505, "Good name matches existing");
        } */
        else {
            goods.put(good.getSku(), good);
        }
        return good;
    }

    @Override
    public void renameGoods(String sku, String newNameGoods) {
        Good good = goods.get(sku);
        if (good == null) {
            throw new NotFoundException(404, "Old name not found.");
        }
        else if (newNameGoods == null) {
            throw new NullPointerException("Old name can't be null.");
        }
        else {
            good.setName(newNameGoods);
            goods.put(sku, good);
        }
    }

    @Override
    public void deleteGoods(String sku) {
        Good good = goods.get(sku);
        if (good == null) {
            throw new NotFoundException(404, "Good not found");
        } else
            goods.remove(sku);
    }


    @Override
    public Good getGoods(String sku) {
        if (sku == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "SKU not  can be null");
        }
        else if (goods.get(sku)==null) {
            throw new NotFoundException(404, "Good not found");
        }
        else {
        return goods.get(sku);}

    }

    @Override
    public void changeAmount(String sku, int newAmount) {
        Good good = goods.get(sku);
        if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else if (newAmount == 0) {
            throw new NullPointerException("Amount name not  can be null");
        } else {
            good.setAmount(newAmount);
            goods.put(sku, good);
        }


    }

    @Override
    public void buyGoods(String sku, int amount, int lastBylPrice, String warehouse) {
        Good good = goods.get(sku);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else {
            good.setAmount(good.getAmount() + amount);
            goods.put(sku, good);
        }


    }

    @Override
    public void sellGoods(String sku, int amount, int lastSellPrice) {
        Good good = goods.get(sku);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else if (good.getAmount() < amount) {
            throw new NullPointerException("Good amount not enough to sell. Stock balance: " + good.getAmount());

        } else {
            good.setAmount(good.getAmount() - amount);
            goods.put(sku, good);
        }
    }

    @Override
    public void changeWarehouse(String nameGoods, int amount, String oldWarehouse, String newWarehouse) {
        Good good = goods.get(nameGoods);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else {
            good.setWarehouse(newWarehouse);
            goods.put(nameGoods, good);
        }

    }
}
