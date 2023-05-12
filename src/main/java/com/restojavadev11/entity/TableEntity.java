package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "restaurant_table", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
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
