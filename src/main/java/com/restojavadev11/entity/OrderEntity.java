package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu_order", schema = "project")
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
    @Column(name = "o_total", nullable = false)
    private double oTotal;

    @JoinColumn(name = "o_id_menu")
    @ManyToOne
    private MenuEntity menuEntity;
}
