package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu", schema = "project")
@Getter
@Setter
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_menu", nullable = false)
    private Long idMenu;

    @Basic
    @Column(name = "m_dish_name", nullable = false, length = 100)
    private String mDishName;

    @Basic
    @Column(name = "m_description", nullable = false, length = 200)
    private String mDescription;

    @Basic
    @Column(name = "m_price", nullable = false)
    private double mPrice;
}
