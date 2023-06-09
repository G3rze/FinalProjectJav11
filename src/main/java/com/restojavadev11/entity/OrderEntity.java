package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "menu_order", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
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

    @JoinColumn(name= "o_id_menu")
    @ManyToOne
    private MenuEntity menuEntity;

    @JoinColumn(name = "o_id_bill")
    @ManyToOne
    private BillEntity bill;


}
