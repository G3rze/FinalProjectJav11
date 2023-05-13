package com.restojavadev11.entity;

import com.restojavadev11.entity.embeddable.ReservationTableId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "reservation_table", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationTableEntity {

    @EmbeddedId
    private ReservationTableId rtId;

    @ManyToOne
    @JoinColumn(name = "id_reservation", nullable = false)
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "id_table", nullable = false)
    private TableEntity table;

    @Basic
    @Column(name = "rt_start_time", nullable = false)
    private Time rtStartTime;

    @Basic
    @Column(name = "rt_end_time")
    private Time rtEndTime;
}
