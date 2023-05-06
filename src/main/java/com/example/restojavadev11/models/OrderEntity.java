package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "order", schema = "project", catalog = "")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_order", nullable = false)
    @Getter @Setter
    private Long idOrder;

    @Basic
    @Column(name = "o_type", nullable = false, length = 100)
    @Getter @Setter
    private String oType;

    @Basic
    @Column(name = "o_total", nullable = false, precision = 0)
    @Getter @Setter
    private double oTotal;

    @Basic
    @Column(name = "o_idMenu", nullable = false)
    @Getter @Setter
    private Long oIdMenu;

    @OneToMany(mappedBy = "orderByBIdOrder")
    @Getter @Setter
    private Collection<BillEntity> billsByIdOrder;

    @ManyToOne
    @JoinColumn(name = "o_idMenu", referencedColumnName = "id_menu", nullable = false)
    @Getter @Setter
    private MenuEntity menuByOIdMenu;
}
