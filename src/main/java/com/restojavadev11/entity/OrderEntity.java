package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "order", schema = "project", catalog = "")
@Getter @Setter
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    @Basic
    @Column(name = "o_type", nullable = false, length = 100)
    private String oType;

    @Basic
    @Column(name = "o_total", nullable = false, precision = 0)
    private double oTotal;

    @Basic
    @Column(name = "o_idMenu", nullable = false)
    private Long oIdMenu;
}
