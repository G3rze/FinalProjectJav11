package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "restaurant", schema = "project", catalog = "")
public class RestaurantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_restaurant", nullable = false)
    @Getter @Setter
    private int idRestaurant;

    @Basic
    @Column(name = "r_name", nullable = false, length = 100)
    @Getter @Setter
    private String rName;

    @Basic
    @Column(name = "r_address", nullable = false, length = 100)
    @Getter @Setter
    private String rAddress;

    @Basic
    @Column(name = "r_phone", nullable = false, length = 9)
    @Getter @Setter
    private String rPhone;

    @Basic
    @Column(name = "r_email", nullable = false, length = 100)
    @Getter @Setter
    private String rEmail;

    @Basic
    @Column(name = "r_schedule", nullable = false, length = 100)
    @Getter @Setter
    private String rSchedule;

    @OneToMany(mappedBy = "restaurantByIdRestaurant")
    @Getter @Setter
    private Collection<EmployeeEntity> employeesByIdRestaurant;
}
