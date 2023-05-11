package com.restojavadev11.parameters;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@NotBlank
@Getter
@Setter
public class PromotionParameters {


    private String name;

    private String description;

    private double discount;

    private Date startDate;

    private Date finishDate;

    public void setStartDate(LocalDate localStartDate){
        this.startDate = Date.valueOf(localStartDate);
    }
    public void setFinishDate(LocalDate localFinishDate){
        this.finishDate = Date.valueOf(localFinishDate);
    }
}
