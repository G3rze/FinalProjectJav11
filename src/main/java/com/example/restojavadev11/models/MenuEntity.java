package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "menu", schema = "project", catalog = "")
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_menu", nullable = false)
    @Getter @Setter
    private int idMenu;

    @Basic
    @Column(name = "m_dish_name", nullable = false, length = 100)
    @Getter @Setter
    private String mDishName;

    @Basic
    @Column(name = "m_description", nullable = false, length = 200)
    @Getter @Setter
    private String mDescription;

    @Basic
    @Column(name = "m_price", nullable = false, precision = 0)
    @Getter @Setter
    private double mPrice;

    @OneToMany(mappedBy = "menuByOIdMenu")
    @Getter @Setter
    private Collection<OrderEntity> ordersByIdMenu;
}
