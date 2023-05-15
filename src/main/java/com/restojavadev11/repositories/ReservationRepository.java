package com.restojavadev11.repositories;

import com.restojavadev11.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    ReservationEntity findById(long id);
    @Procedure(procedureName = "create_reservation")
    Long createReservation(
            @Param("reservation_date") Date reservationDate,
            @Param("reservation_start_time") Time reservationStartTime,
            @Param("reservation_end_time") Time reservationEndTime,
            @Param("reservation_n_people") int reservationNPeople,
            @Param("reservation_n_table") int reservationNTable,
            @Param("reservation_status") char reservationStatus,
            @Param("reservation_id_customer") Long reservationIdCustomer
    );

    @Procedure(procedureName = "update_reservation")
    void updateReservation(
            @Param("p_id") Long id,
            @Param("p_reservation_date") Date reservationDate,
            @Param("p_reservation_start_time") Time reservationStartTime,
            @Param("p_reservation_end_time") Time reservationEndTime,
            @Param("p_reservation_n_people") int reservationNPeople,
            @Param("p_reservation_n_table") int reservationNTable,
            @Param("p_reservation_id_customer") Long reservationIdCustomer,
            @Param("p_reservation_id_employee") Long reservationIdEmployee,
            @Param("p_reservation_status") Character reservationIdStatus
    );
    @Procedure(procedureName = "in_process_reservation")
    void inProcessReservation(
            @Param("p_id") Long id
    );
    @Procedure(procedureName = "cancel_reservation")
    void cancelReservation(
            @Param("p_id") Long id
    );
    @Procedure(procedureName = "close_reservation")
    void closeReservation(
            @Param("p_id") Long id
    );
    @Procedure(procedureName = "claim_reservation")
    void claimReservation(
            @Param("p_id") Long id,
            @Param("p_id_employee") Long idEmployee
    );


}
