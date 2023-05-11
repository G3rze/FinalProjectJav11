package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "bill", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bill", nullable = false)
    private Long idBill;

    @Basic
    @Column(name = "b_date", nullable = false)
    private Date bDate;

    @Basic
    @Column(name = "b_time", nullable = false)
    private Time bTime;

    @Basic
    @Column(name = "b_total", nullable = false)
    private double bTotal;

    @JoinColumn(name = "b_id_order")
    @ManyToOne
    private OrderEntity orderEntity;

    @JoinColumn(name = "b_id_promotion")
    @ManyToOne
    private PromotionEntity promotionEntity;

}
