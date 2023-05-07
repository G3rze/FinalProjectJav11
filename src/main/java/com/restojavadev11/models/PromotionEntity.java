package com.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "promotion", schema = "project", catalog = "")
@Getter
@Setter
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promotion", nullable = false)
    private Long idPromotion;

    @Basic
    @Column(name = "p_nameOfPromotion", nullable = false, length = 100)
    private String pNameOfPromotion;

    @Basic
    @Column(name = "p_description", nullable = false, length = 200)
    private String pDescription;

    @Basic
    @Column(name = "p_discount", nullable = false, precision = 0)
    private Double pDiscount;

    @Basic
    @Column(name = "p_startDate", nullable = false)
    private Date pStartDate;

    @Basic
    @Column(name = "p_finishDate", nullable = false)
    private Date pFinishDate;

    @OneToMany(mappedBy = "promotionByBIdPromotion")
    private Collection<BillEntity> billsByIdPromotion;
}
