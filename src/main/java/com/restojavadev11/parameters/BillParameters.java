package com.restojavadev11.parameters;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Setter
@Getter
public class BillParameters {
    @NotBlank
    private Date date;
    @NotBlank
    private Time time;
    @DecimalMax("2")
    private double total;
    @NotBlank
    private Long idReservation;
    private Long idPromotion;

    void setDate(LocalDate localDate){
        this.date = Date.valueOf(localDate);
    }

    void  setTotal(double dTotal){
        this.total = Math.round(dTotal);
    }
}
