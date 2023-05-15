package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.entity.ReservationTableEntity;
import com.restojavadev11.repositories.ReservationTableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReservationTableServiceTest {

    @Mock
    private ReservationTableRepository reservationTableRepository;
    @InjectMocks
    private ReservationTableService reservationTableService;
    private ReservationTableEntity reservationTableEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationTableEntity = new ReservationTableEntity();
        reservationTableEntity.setRtStartTime(Time.valueOf("12:30:00"));
        reservationTableEntity.setRtEndTime(Time.valueOf("01:30:00"));
    }

    @Test
    void allReservationTables() {
        when(reservationTableRepository.findAll()).thenReturn(Arrays.asList(reservationTableEntity));
        assertNotNull(reservationTableService.allReservationTables());
    }

    @Test
    void getReservationTableById() {
        Long reservationTableId = Long.valueOf(1);

        when(reservationTableRepository.findById(reservationTableId)).thenReturn(Optional.of(reservationTableEntity));

        Optional<ReservationTableEntity> actualReservationTableEntity = reservationTableService.getReservationTableById(reservationTableId);

        assertEquals(reservationTableEntity, actualReservationTableEntity.get());
    }
}