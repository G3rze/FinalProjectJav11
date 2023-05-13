package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NotBlank
public class MenuParameters {
    private String name;
    private String description;
    private double price;
}
