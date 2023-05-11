package com.restojavadev11.parameters;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NotBlank
public class ReservationParameters {
    @Future
    private LocalDate date;

    private Time startTime;

    private Time endTime;

    private int nPeople;

    private int nTable;

    private long idCustomer;

    private long idBill;

    private long idEmployee;

}
