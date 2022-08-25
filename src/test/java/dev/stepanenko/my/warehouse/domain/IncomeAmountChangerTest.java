package dev.stepanenko.my.warehouse.domain;

import dev.stepanenko.my.warehouse.api.NotFoundException;
import dev.stepanenko.my.warehouse.model.Good;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

public class IncomeAmountChangerTest {
    @BeforeEach // аннотация тестового фреймворка junit5. говорит, что запустить этот метод каждый раз перед запуском теста
    void setUp(){
        MockitoAnnotations.openMocks(this); // типа  "Магии внедрения зависимостей" но для теста - библиотека Mockito
    }
    @InjectMocks
    IncomeAmountChanger incomeAmountChanger ;
    @Test
    public void incomeAmountChanger(){
        int amountGood = 21;
        int changeAmount = 25;
        int result = incomeAmountChanger.doIfGoodPresent(amountGood,changeAmount);
        assertEquals(46, result);

    }



}
