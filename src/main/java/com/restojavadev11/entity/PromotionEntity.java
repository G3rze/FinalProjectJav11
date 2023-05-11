package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "promotion", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_promotion", nullable = false)
    private Long idPromotion;

    @Basic
    @Column(name = "p_name_of_promotion", nullable = false, length = 100)
    private String pName;

    @Basic
    @Column(name = "p_description", nullable = false, length = 200)
    private String pDescription;

    @Basic
    @Column(name = "p_discount", nullable = false)
    private double pDiscount;

    @Basic
    @Column(name = "p_start_date", nullable = false)
    private Date pStartDate;

    @Basic
    @Column(name = "p_finish_date", nullable = false)
    private Date pFinishDate;
}
