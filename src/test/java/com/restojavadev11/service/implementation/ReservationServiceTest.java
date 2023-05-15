package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.entity.ReservationEntity;
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
import static org.mockito.Mockito.when;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private ReservationService reservationService;
    private ReservationEntity reservationEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationEntity = new ReservationEntity();
        reservationEntity.setIdNReservation(Long.valueOf(1));
        reservationEntity.setRReservationDate(Date.valueOf("2023-01-05"));
        reservationEntity.setRReservationStartTime(Time.valueOf("11:11:01"));
        reservationEntity.setRReservationEndTime(Time.valueOf("10:12:02"));
        reservationEntity.setRNPeople(5);
        reservationEntity.setRNTable(7);
        reservationEntity.setStatus(Character.valueOf('P'));
    }

    @Test
    void allReservations() {
        when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservationEntity));
        assertNotNull(reservationService.allReservations());
    }

    @Test
    void getReservationById() {

        //En comprobacion
        Long reservationId = Long.valueOf(1);

        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(reservationEntity));

        Optional<ReservationEntity> actualReservationEntity = reservationService.getReservationById(reservationId);

        assertEquals(reservationEntity, actualReservationEntity.get());
    }
}