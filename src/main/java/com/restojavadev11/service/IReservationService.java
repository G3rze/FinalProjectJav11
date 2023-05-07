package com.restojavadev11.service;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.parameters.ReservationParameters;

import java.util.List;
import java.util.Optional;

public interface IReservationService {

    List<ReservationEntity> allReservations();

    Optional<ReservationEntity> getReservationById(long id);

    ReservationEntity newReservation(ReservationParameters reservationParameters);

    void deleteReservation(long id);

    void updateReservation(ReservationEntity newReservation);

}
