package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "table", schema = "project")
@Getter
@Setter
public class TableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_n_table", nullable = false)
    private Long idNTable;

    @Basic
    @Column(name = "t_capacity", nullable = false)
    private int tCapacity;
}
