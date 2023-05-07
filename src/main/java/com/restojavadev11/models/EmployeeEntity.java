package com.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "project", catalog = "")
@Getter
@Setter
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_employee", nullable = false)
    private Long idEmployee;

    @Basic
    @Column(name = "e_name", nullable = false, length = 100)
    private String eName;

    @Basic
    @Column(name = "e_lastName", nullable = false, length = 100)
    private String eLastName;

    @Basic
    @Column(name = "e_position", nullable = false, length = 100)
    private String ePosition;

    @Basic
    @Column(name = "e_salary", nullable = false, precision = 0)
    private double eSalary;

    @Basic
    @Column(name = "e_date_of_hire", nullable = false)
    private Date eDateOfHire;

    @Basic
    @Column(name = "id_restaurant", nullable = false)
    private Long idRestaurant;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", nullable = false)
    private RestaurantEntity restaurantByIdRestaurant;

    @OneToMany(mappedBy = "employeeByRIdEmployee")
    private Collection<ReservationEntity> reservationsByIdEmployee;
}
