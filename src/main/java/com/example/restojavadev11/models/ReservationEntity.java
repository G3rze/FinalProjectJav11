package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservation", schema = "project", catalog = "")
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nReservation", nullable = false)
    @Getter @Setter
    private Long idNReservation;

    @Basic
    @Column(name = "r_reservationDate", nullable = false)
    @Getter @Setter
    private Date rReservationDate;

    @Basic
    @Column(name = "r_reservationStartTime", nullable = false)
    @Getter @Setter
    private Time rReservationStartTime;

    @Basic
    @Column(name = "r_reservationEndTime", nullable = false)
    @Getter @Setter
    private Time rReservationEndTime;

    @Basic
    @Column(name = "r_nPeople", nullable = false)
    @Getter @Setter
    private Long rNPeople;

    @Basic
    @Column(name = "r_nTable", nullable = false)
    @Getter @Setter
    private Long rNTable;

    @Basic
    @Column(name = "r_idCustomer", nullable = false)
    @Getter @Setter
    private Long rIdCustomer;

    @Basic
    @Column(name = "r_idBill", nullable = false)
    @Getter @Setter
    private Long rIdBill;

    @Basic
    @Column(name = "r_idEmployee", nullable = false)
    @Getter @Setter
    private Long rIdEmployee;
    @ManyToOne
    @JoinColumn(name = "r_nTable", referencedColumnName = "id_nTable", nullable = false)
    @Getter @Setter
    private TableEntity tableByRNTable;
    @ManyToOne
    @JoinColumn(name = "r_idCustomer", referencedColumnName = "id_customer", nullable = false)
    @Getter @Setter
    private CustomerEntity customerByRIdCustomer;
    @ManyToOne
    @JoinColumn(name = "r_idBill", referencedColumnName = "id_bill", nullable = false)
    @Getter @Setter
    private BillEntity billByRIdBill;
    @ManyToOne
    @JoinColumn(name = "r_idEmployee", referencedColumnName = "id_employee", nullable = false)
    @Getter @Setter
    private EmployeeEntity employeeByRIdEmployee;

}
