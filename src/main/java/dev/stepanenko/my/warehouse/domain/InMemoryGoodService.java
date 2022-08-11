package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Good;

import java.util.HashMap;

public class InMemoryGoodService implements GoodService {



    private HashMap<String, Good> goods = new HashMap<>();

    @Override
    public Good saveGood(Good good) {
        if(good.getName() == null){
            throw new NotFoundException(404, "Name can't be null");
        }
        else if(good.getSku() == null){
            throw new NotFoundException(404, "SKU can't be null");
        }
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
    public Good createGood(String sku, String nameGoods) {
        if(nameGoods==null){
            throw new NotFoundException(404, "Good not found");
        }
        else if (sku == null){
            throw new NotFoundException(404, "Good not found");
        }
        else {
            Good good = new Good();
            good.setSku(sku);
            good.setName(nameGoods);
            return good;
        }
    }

    @Override
    public void setLastBuyPrise(String sku, int lastBuyPrice) {
        if(lastBuyPrice<0){
            throw new NullPointerException("last Buy Price can't be null.");
        }
        else {
            Good good = goods.get(sku);
            good.setLastBuyPrice(lastBuyPrice);

            goods.put(sku, good);
        }
    }

    @Override
    public void setLastSellPrice(String sku, int lastSellPrice) {
        if(lastSellPrice<0){
            throw new NullPointerException("Last Sell Price can't be null.");
        }
        else {
            Good good = goods.get(sku);
            good.setLastSellPrice(lastSellPrice);

            goods.put(sku, good);
        }
    }

}
