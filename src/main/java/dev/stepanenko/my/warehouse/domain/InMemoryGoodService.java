package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.ApiException;
import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Good;

import java.util.HashMap;

public class InMemoryGoodService implements GoodService {


    public class NameMatchException extends ApiException {
        private int code;

        public NameMatchException(int code, String msg) {
            super(code, msg);
            this.code = code;
        }
    }

    private HashMap<String, Good> goods = new HashMap<>();

    @Override
    public void createGoods(Good good) {

        if (goods.containsKey(good.getName())) {
            throw new NameMatchException(505, "Good name matches existing");
        } else {
            goods.put(good.getName(), good);
        }

    }

    @Override
    public void renameGoods(String oldNameGoods, String newNameGoods) {
        Good good = goods.get(oldNameGoods);
        if (good.getName() == null) {
            throw new NullPointerException("Warehouse name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Warehouse name not  can be null");
        } else if (goods.containsKey(newNameGoods)) {
            throw new NameMatchException(505, "Warehouse name matches existing");
        } else {
            good.setName(newNameGoods);
            goods.put(newNameGoods, good);
        }
    }

    @Override
    public void deleteGoods(String nameGoods) {
        Good good = goods.get(nameGoods);
        if (good == null) {
            throw new NotFoundException(404, "Warehouse name not  can be null");
        } else
            goods.remove(nameGoods);
    }


    @Override
    public Good getGoods(String nameGoods) {
        return goods.get(nameGoods);
    }

    @Override
    public void changeAmount(String nameGoods, int newAmount) {
        Good good = goods.get(nameGoods);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else if (newAmount == 0) {
            throw new NullPointerException("Amount name not  can be null");
        } else {
            good.setAmount(newAmount);
            goods.put(nameGoods, good);
        }


    }

    @Override
    public void buyGoods(String nameGoods, int amount, int lastBylPrice, String warehouse) {
        Good good = goods.get(nameGoods);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else {
            good.setAmount(good.getAmount() + amount);
            goods.put(nameGoods, good);
        }


    }

    @Override
    public void sellGoods(String nameGoods, int amount, int lastSellPrice) {
        Good good = goods.get(nameGoods);
        if (good.getName() == null) {
            throw new NullPointerException("Good name not  can be null");
        } else if (good == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Good name not  can be null");
        } else if (good.getAmount() < amount) {
            throw new NullPointerException("Good amount not enough to sell. Stock balance: " + good.getAmount());

        } else {
            good.setAmount(good.getAmount() - amount);
            goods.put(nameGoods, good);
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
