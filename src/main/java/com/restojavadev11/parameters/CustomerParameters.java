package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NotBlank
public class CustomerParameters {
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
}
