package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Warehouse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryWarehouseServiceTest {
    @Test
    public void shouldMemorizeWarehouse(){

        Warehouse expectedWarehouse = new Warehouse();
        expectedWarehouse.setWarehouseName("newName");


        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse("newName");

        Warehouse actualWarehouse = service.getWarehouse("newName");



        assertEquals(expectedWarehouse, actualWarehouse);
    }

    @Test
    public void shouldMemorizeNameWarehouse(){

        String expectedName = "warehouse1";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(expectedName);

        Warehouse warehouse = service.getWarehouse(expectedName);
        String actualName = warehouse.getWarehouseName() ;
        assertEquals(expectedName, actualName);
    }
    @Test
    public void createTwoTimes(){
        String name1 = "name1";
        String name2 = "name2";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name1);
        service.createWarehouse(name2);

        Warehouse warehouse1 = service.getWarehouse(name1);
        Warehouse warehouse2 = service.getWarehouse(name2);

        assertNotEquals(warehouse1,warehouse2);
        assertNotNull(warehouse1);
        assertNotNull(warehouse2);

    }


    @Disabled
    @Test
    public void notCreateWarehouseWithSameNameTwice(){
        String name1 = "name1";
        String name2 = "name2";
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name1);
        service.createWarehouse(name1);

        Warehouse warehouse1 = service.getWarehouse(name1);
        Warehouse warehouse2 = service.getWarehouse(name2);

        assertNotEquals(warehouse1,warehouse2);

    }


    //вводим верхаус, который мы хотим измнить
    //вводим имя, на которое будет менятся верхаус
    //1) старое имя не найдено---
    //2) старое имя совпадает с новым---
    //3) новое имя совпадает с другим верхаусом---
    //4) некорректное имя (много символов ключ/имя не должно быть null)---
    //5) старое имя успешно заменено на новое---


    @Test
    void shouldRenameWarehouse() {

        String oldName = "name1";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);

        service.renameWarehouse(oldName,newName);

        Warehouse warehouse = service.getWarehouse(newName);

        String actualName = warehouse.getWarehouseName() ;
        assertEquals("name2", actualName);
    }
    @Test
    void shouldGetErrorIfNotFoundOldName(){
        String oldName = "name1";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();

        assertThrows(NullPointerException.class, ()->{
            service.renameWarehouse(oldName,newName);
        });
    }

    @Test
    void shouldGetErrorIfNewNameMatchesWithAnotherWarehouse() {

        String oldName = "name1";
        String nameAnotherWarehouse = "name2";
        String newName = "name2";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);//1
        service.createWarehouse(nameAnotherWarehouse);//2
        assertThrows(InMemoryWarehouseService.NameMatchException.class, ()->{
            service.renameWarehouse(oldName,newName);
        });

    }

    @Test
    void shouldGetErrorIfNameWarehouseIsNull() {

        String oldName = "name1";
        String newName = null;

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(oldName);

        service.renameWarehouse(oldName,newName);

        assertThrows(NullPointerException.class, ()->{
            service.renameWarehouse(oldName,newName);
        });
    }

    @Test
    void shouldGetErrorIfNewWarehouseIsNull() {

        String name1 = null;
        InMemoryWarehouseService service = new InMemoryWarehouseService();
        assertThrows(NullPointerException.class, ()->{
            service.createWarehouse(name1);
        });
    }
    @Test
    void shouldDellWarehouse(){
        String name = "name1";

        InMemoryWarehouseService service = new InMemoryWarehouseService();
        service.createWarehouse(name);

        service.deleteWarehouse(name);
        Warehouse warehouse = service.getWarehouse(name);
        assertNull(warehouse);
    }
    @Test
    void shouldGetErrorIfDellWarehouseNotFound(){
        String name = "name1";

        InMemoryWarehouseService service = new InMemoryWarehouseService();

        assertThrows(NotFoundException.class, ()->{
            service.deleteWarehouse(name);
        });
    }

}