package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservation", schema = "project")
@Getter
@Setter
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_n_reservation", nullable = false)
    private Long idNReservation;

    @Basic
    @Column(name = "r_reservation_date", nullable = false)
    private Date rReservationDate;

    @Basic
    @Column(name = "r_reservation_start_time", nullable = false)
    private Time rReservationStartTime;

    @Basic
    @Column(name = "r_reservation_end_time", nullable = false)
    private Time rReservationEndTime;

    @Basic
    @Column(name = "r_n_people", nullable = false)
    private Integer rNPeople;

    @Basic
    @Column(name = "r_n_table", nullable = false)
    private Integer rNTable;

    @JoinColumn(name = "r_id_customer")
    @ManyToOne
    private CustomerEntity customerEntity;

    @JoinColumn(name = "r_id_bill")
    @ManyToOne
    private BillEntity billEntity;

    @JoinColumn(name = "r_id_employee")
    @ManyToOne
    private EmployeeEntity employeeEntity;
}
