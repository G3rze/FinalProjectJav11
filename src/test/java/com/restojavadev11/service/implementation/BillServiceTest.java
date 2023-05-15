package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.entity.PromotionEntity;
import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.parameters.BillParameters;
import com.restojavadev11.repositories.BillRepository;
import com.restojavadev11.repositories.PromotionRepository;
import com.restojavadev11.repositories.ReservationRepository;
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
import static org.mockito.Mockito.*;

class BillServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private PromotionRepository promotionRepository;
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

    @Test
    void newBill() {
        long idReservation = 1;
        ReservationEntity reservation = new ReservationEntity();
        when(reservationRepository.findById(idReservation)).thenReturn(reservation);

        long idPromotion = 1;
        PromotionEntity promotion = new PromotionEntity();
        when(promotionRepository.findById(idPromotion)).thenReturn(promotion);

        BillParameters billParameters = new BillParameters();
        billParameters.setIdReservation(idReservation);
        billParameters.setIdPromotion(idPromotion);
        billParameters.setTime(Time.valueOf("12:00:00"));
        billParameters.setDate(Date.valueOf("2023-05-15").toLocalDate());


        BillEntity result = billService.newBill(billParameters);

        assertEquals(reservation, result.getReservation());
        assertEquals(promotion, result.getPromotionEntity());
        assertEquals(Time.valueOf("12:00:00"), result.getBTime());
        assertEquals(Date.valueOf("2023-05-15"), result.getBDate());
    }

    @Test
    void updateBill() {
        billEntity.setIdBill(Long.valueOf(1));
        billEntity.setBDate(Date.valueOf("2023-05-12"));
        billEntity.setBTime(Time.valueOf("21:30:00"));
        billEntity.setBTotal(30);

        billService.updateBill(billEntity);

        verify(billRepository, times(1)).save(billEntity);
    }
}