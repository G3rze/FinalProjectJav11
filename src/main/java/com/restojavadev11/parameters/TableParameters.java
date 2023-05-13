package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@NotBlank
@Getter
@Setter
public class TableParameters {
    private int capacity;
}
