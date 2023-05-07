package com.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "menu", schema = "project", catalog = "")
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
    @Column(name = "m_price", nullable = false, precision = 0)
    private double mPrice;

    @OneToMany(mappedBy = "menuByOIdMenu")
    private Collection<OrderEntity> ordersByIdMenu;
}
