package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "employee", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "e_lastname", nullable = false, length = 100)
    private String eLastName;

    @Basic
    @Column(name = "e_position", nullable = false, length = 100)
    private String ePosition;

    @Basic
    @Column(name = "e_salary", nullable = false)
    private double eSalary;

    @Basic
    @Column(name = "e_date_of_hire", nullable = false)
    private Date eDateOfHire;

    @Basic
    @Column(name = "id_restaurant", nullable = false)
    private Long idRestaurant;
}
