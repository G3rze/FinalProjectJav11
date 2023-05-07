package com.restojavadev11.parameters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderParameters {
    private String type;
    private double total;
    private long idMenu;
}
