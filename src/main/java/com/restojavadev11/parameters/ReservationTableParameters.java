package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class ReservationTableParameters {
    @NotBlank
    @NotNull
    private long idReservation;
    @NotNull
    @NotBlank
    private long idTable;
    @NotBlank
    @NotNull
    private Time startTime;

    private Time endTime;

}
