package com.restojavadev11.service;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.parameters.ReservationParameters;

import java.util.List;
import java.util.Optional;

public interface IReservationService {

    List<ReservationEntity> allReservations();


    Optional<ReservationEntity> getReservationById(long id);

    Optional<ReservationEntity> newReservation(ReservationParameters reservationParameters);
    void updateReservation(ReservationParameters reservationParameters);

    void setInProcessReservation(ReservationParameters reservationParameters);
    void cancelReservation(ReservationParameters reservationParameters);
    void closeReservation(ReservationParameters reservationParameters);
    void claimReservation(ReservationParameters reservationParameters);


}
