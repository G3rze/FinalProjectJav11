package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservation", schema = "project", catalog = "")
@Getter
@Setter
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nReservation", nullable = false)
    private Long idNReservation;

    @Basic
    @Column(name = "r_reservationDate", nullable = false)
    private Date rReservationDate;

    @Basic
    @Column(name = "r_reservationStartTime", nullable = false)
    private Time rReservationStartTime;

    @Basic
    @Column(name = "r_reservationEndTime", nullable = false)
    private Time rReservationEndTime;

    @Basic
    @Column(name = "r_nPeople", nullable = false)
    private Integer rNPeople;

    @Basic
    @Column(name = "r_nTable", nullable = false)
    private Integer rNTable;

    @Basic
    @Column(name = "r_idCustomer", nullable = false)
    private Long rIdCustomer;

    @Basic
    @Column(name = "r_idBill", nullable = false)
    private Long rIdBill;

    @Basic
    @Column(name = "r_idEmployee", nullable = false)
    private Long rIdEmployee;
}
