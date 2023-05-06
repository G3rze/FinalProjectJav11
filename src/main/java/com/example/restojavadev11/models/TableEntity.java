package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "table", schema = "project", catalog = "")
public class TableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nTable", nullable = false)
    @Getter @Setter
    private Long idNTable;

    @Basic
    @Column(name = "t_capacity", nullable = false)
    @Getter @Setter
    private int tCapacity;

    @OneToMany(mappedBy = "tableByRNTable")
    @Getter @Setter
    private Collection<ReservationEntity> reservationsByIdNTable;
}
