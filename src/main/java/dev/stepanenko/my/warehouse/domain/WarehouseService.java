package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.model.Warehouse;

public interface WarehouseService {
    void createWarehouse (String nameWarehouse);
    void renameWarehouse (String warehouseName, String newNameWarehouse);
    void deleteWarehouse (String nameWarehouse);
    Warehouse getWarehouse (String nameWarehouse);
}


