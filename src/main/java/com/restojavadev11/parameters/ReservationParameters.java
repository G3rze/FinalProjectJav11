package com.restojavadev11.parameters;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
public class ReservationParameters {

    private Date date;

    private Time startTime;

    private Time endTime;

    private int nPeople;

    private int nTable;

    private long idCustomer;

    private long idBill;

    private long idEmployee;

}
