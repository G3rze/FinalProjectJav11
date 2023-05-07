package com.restojavadev11.service;

import com.restojavadev11.models.ReservationEntity;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IReservationService {

    List<ReservationEntity> allReservations();

    Optional<ReservationEntity> getReservationById(long id);

    ReservationEntity newReservation(Date date, Time startTime, Time endTime, int nPeople, int nTable, long idCustomer, long idBill, long idEmployee);

    void deleteReservation(long id);

    void updateReservation(ReservationEntity newReservation);

}
