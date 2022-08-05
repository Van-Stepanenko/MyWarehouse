package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.ApiException;
import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Warehouse;

import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.util.HashMap;

public class InMemoryWarehouseService implements WarehouseService {


    public class NameMatchException extends ApiException {
        private int code;
        public NameMatchException (int code, String msg) {
            super(code, msg);
            this.code = code;
        }
    }


    private HashMap<String, Warehouse> warehouses = new HashMap<>();

    @Override
    public void createWarehouse(String nameWarehouse) {
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setWarehouseName(nameWarehouse);
        if (newWarehouse.getWarehouseName()==null){ // Если новое имя null
            throw new NullPointerException("Warehouse name not  can be null");
        }
        else  if(warehouses.containsKey(nameWarehouse)){ // если новое имя warehouse совпадает с тем, что уже есть в HashMap(е)
            throw new NameMatchException(505,"Warehouse name matches existing");
        }
        else
        warehouses.put(nameWarehouse, newWarehouse);

    }

    @Override
    public void renameWarehouse(String warehouseName, String newNameWarehouse) {//при ренейме запрос по старому ключу и после делита
//тесты на синтаксис, на оооп по типу что выведет код? Добавь код и т.д.
        //тесты на core java. лекции core java , упражнения, задачи

        Warehouse warehouse = warehouses.get(warehouseName);
        if (warehouse.getWarehouseName()==null){ // Если новое имя null
            throw new NullPointerException("Warehouse name not  can be null");
        }
        else if (warehouse == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Warehouse name not  can be null");
        }

        else if(warehouses.containsKey(newNameWarehouse)){ // если новое имя warehouse совпадает с тем, что уже есть в HashMap(е)
               throw new NameMatchException(505,"Warehouse name matches existing");
        }
       else { // если все ок

           warehouse.setWarehouseName(newNameWarehouse);
           warehouses.put(newNameWarehouse, warehouse);
       }
    }

    @Override
    public void deleteWarehouse(String nameWarehouse) {
        Warehouse warehouse = warehouses.get(nameWarehouse);
        if (warehouse == null) { // Если старый warehouse не был найден
            throw new NotFoundException(404, "Warehouse name not  can be null");
        }
        else
        warehouses.remove(nameWarehouse);
    }

    @Override
    public Warehouse getWarehouse(String nameWarehouse) {
        return warehouses.get(nameWarehouse);
    }
}
