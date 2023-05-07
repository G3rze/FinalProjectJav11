package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "bill", schema = "project", catalog = "")
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
    @Column(name = "b_total", nullable = false, precision = 0)
    private double bTotal;

    @Basic
    @Column(name = "b_idOrder", nullable = false)
    private Long bIdOrder;

    @Basic
    @Column(name = "b_idPromotion", nullable = true)
    private Long bIdPromotion;

    @ManyToOne
    @JoinColumn(name = "b_idOrder", referencedColumnName = "id_order", nullable = false)
    private OrderEntity orderByBIdOrder;

    @ManyToOne
    @JoinColumn(name = "b_idPromotion", referencedColumnName = "id_promotion")
    private PromotionEntity promotionByBIdPromotion;

    @OneToMany(mappedBy = "billByRIdBill")
    private Collection<ReservationEntity> reservationsByIdBill;
}
