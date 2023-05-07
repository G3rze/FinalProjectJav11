package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "table", schema = "project", catalog = "")
@Getter
@Setter
public class TableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nTable", nullable = false)
    private Long idNTable;

    @Basic
    @Column(name = "t_capacity", nullable = false)
    private int tCapacity;
}
