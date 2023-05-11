package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurant", schema = "project")
@Getter @Setter
public class RestaurantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_restaurant", nullable = false)
    private Long idRestaurant;

    @Basic
    @Column(name = "r_name", nullable = false, length = 100)
    private String rName;

    @Basic
    @Column(name = "r_address", nullable = false, length = 100)
    private String rAddress;

    @Basic
    @Column(name = "r_phone", nullable = false, length = 9)
    private String rPhone;

    @Basic
    @Column(name = "r_email", nullable = false, length = 100)
    private String rEmail;

    @Basic
    @Column(name = "r_schedule", nullable = false, length = 100)
    private String rSchedule;
}
