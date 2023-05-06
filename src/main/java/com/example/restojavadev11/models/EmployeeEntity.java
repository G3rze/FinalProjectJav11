package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "project", catalog = "")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_employee", nullable = false)
    @Getter @Setter
    private Long idEmployee;

    @Basic
    @Column(name = "e_name", nullable = false, length = 100)
    @Getter @Setter
    private String eName;

    @Basic
    @Column(name = "e_lastName", nullable = false, length = 100)
    @Getter @Setter
    private String eLastName;

    @Basic
    @Column(name = "e_position", nullable = false, length = 100)
    @Getter @Setter
    private String ePosition;

    @Basic
    @Column(name = "e_salary", nullable = false, precision = 0)
    @Getter @Setter
    private double eSalary;

    @Basic
    @Column(name = "e_date_of_hire", nullable = false)
    @Getter @Setter
    private Date eDateOfHire;

    @Basic
    @Column(name = "id_restaurant", nullable = false)
    @Getter @Setter
    private Long idRestaurant;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", nullable = false)
    @Getter @Setter
    private RestaurantEntity restaurantByIdRestaurant;

    @OneToMany(mappedBy = "employeeByRIdEmployee")
    @Getter @Setter
    private Collection<ReservationEntity> reservationsByIdEmployee;
}
