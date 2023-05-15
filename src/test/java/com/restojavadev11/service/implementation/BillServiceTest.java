package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.repositories.BillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BillServiceTest {

    @Mock
    private BillRepository billRepository;
    @InjectMocks
    private BillService billService;
    private BillEntity billEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        billEntity = new BillEntity();
        billEntity.setIdBill(Long.valueOf(1));
        billEntity.setBDate(Date.valueOf("2023-05-12"));
        billEntity.setBTime(Time.valueOf("21:30:00"));
        billEntity.setBTotal(30);
    }

    @Test
    void allBills() {
        when(billRepository.findAll()).thenReturn(Arrays.asList(billEntity));
        assertNotNull(billService.allBills());
    }

    @Test
    void getBillById() {
        Long billId = Long.valueOf(1);

        when(billRepository.findById(billId)).thenReturn(Optional.of(billEntity));

        Optional<BillEntity> actualBillEntity = billService.getBillById(billId);

        assertEquals(billEntity, actualBillEntity.get());
    }
}