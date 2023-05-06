package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "promotion", schema = "project", catalog = "")
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promotion", nullable = false)
    @Getter @Setter
    private Long idPromotion;

    @Basic
    @Column(name = "p_nameOfPromotion", nullable = false, length = 100)
    @Getter @Setter
    private String pNameOfPromotion;

    @Basic
    @Column(name = "p_description", nullable = false, length = 200)
    @Getter @Setter
    private String pDescription;

    @Basic
    @Column(name = "p_discount", nullable = false, precision = 0)
    @Getter @Setter
    private double pDiscount;

    @Basic
    @Column(name = "p_startDate", nullable = false)
    @Getter @Setter
    private Date pStartDate;

    @Basic
    @Column(name = "p_finishDate", nullable = false)
    @Getter @Setter
    private Date pFinishDate;

    @OneToMany(mappedBy = "promotionByBIdPromotion")
    @Getter @Setter
    private Collection<BillEntity> billsByIdPromotion;
}
