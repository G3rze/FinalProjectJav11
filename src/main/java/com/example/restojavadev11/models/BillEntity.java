package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "bill", schema = "project", catalog = "")
public class BillEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bill", nullable = false)
    @Getter @Setter
    private int idBill;

    @Basic
    @Column(name = "b_date", nullable = false)
    @Getter @Setter
    private Date bDate;

    @Basic
    @Column(name = "b_time", nullable = false)
    @Getter @Setter
    private Time bTime;

    @Basic
    @Column(name = "b_total", nullable = false, precision = 0)
    @Getter @Setter
    private double bTotal;

    @Basic
    @Column(name = "b_idOrder", nullable = false)
    @Getter @Setter
    private int bIdOrder;

    @Basic
    @Column(name = "b_idPromotion", nullable = true)
    @Getter @Setter
    private Integer bIdPromotion;

    @ManyToOne
    @JoinColumn(name = "b_idOrder", referencedColumnName = "id_order", nullable = false)
    @Getter @Setter
    private OrderEntity orderByBIdOrder;

    @ManyToOne
    @JoinColumn(name = "b_idPromotion", referencedColumnName = "id_promotion")
    @Getter @Setter
    private PromotionEntity promotionByBIdPromotion;

    @OneToMany(mappedBy = "billByRIdBill")
    @Getter @Setter
    private Collection<ReservationEntity> reservationsByIdBill;
}
