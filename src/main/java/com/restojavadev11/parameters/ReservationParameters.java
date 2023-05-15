package com.restojavadev11.parameters;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NotBlank
public class ReservationParameters {
    private Long id;
    @Future
    private Date date;

    private Time startTime;

    private Time endTime;

    private int nPeople;

    private int nTable;

    private long idCustomer;

    private long idEmployee;

    private char status;

}
