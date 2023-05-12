package com.restojavadev11.parameters;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NotBlank
public class OrderParameters {
    private String type;
    @DecimalMax("2")
    private double total;
    private long idMenu;
}
