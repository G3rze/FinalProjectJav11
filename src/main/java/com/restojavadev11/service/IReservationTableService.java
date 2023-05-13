package com.restojavadev11.service;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.entity.ReservationTableEntity;
import com.restojavadev11.parameters.ReservationTableParameters;

import java.util.List;
import java.util.Optional;

public interface IReservationTableService {

    List<ReservationTableEntity> allReservationTables();

    Optional<ReservationTableEntity> getReservationTableById(long id);

    ReservationTableEntity newReservationTable(ReservationTableParameters reservationTableParameters);

    void updateReservationTable(ReservationTableEntity newReservationTable);

    void deleteReservationTableById(long id);


}
