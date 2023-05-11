package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "promotion", schema = "project", catalog = "")
@Getter
@Setter
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   // @Column(name = "id_promotion", nullable = false)
    private Long idPromotion;

    @Basic
  //  @Column(name = "p_nameOfPromotion", nullable = false, length = 100)
    private String p_nameOfPromotion;

    @Basic
   // @Column(name = "p_description", nullable = false, length = 200)
    private String p_description;

    @Basic
   // @Column(name = "p_discount", nullable = false, precision = 0)
    private Double p_discount;

    @Basic
   // @Column(name = "p_startDate", nullable = false)
    private Date p_startDate;

    @Basic
    //@Column(name = "p_finishDate", nullable = false)
    private Date p_finishDate;
}
