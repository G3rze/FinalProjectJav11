package com.restojavadev11.parameters;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PromotionParameters {
    private String name;

    private String description;

    private double discount;

    private Date startDate;

    private Date finishDate;
}
