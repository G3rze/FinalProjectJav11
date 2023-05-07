package com.restojavadev11.parameters;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
public class BillParameters {
    private Date date;
    private Time time;
    private double total;
    private long idPromotion;
}
