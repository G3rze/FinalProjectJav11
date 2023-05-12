package com.restojavadev11.parameters;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@NotBlank
public class BillParameters {
    private Date date;
    private Time time;
    @DecimalMax("2")
    private double total;
    private long idPromotion;
}
