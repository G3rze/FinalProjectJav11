package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NotBlank
@ToString
public class CustomerParameters {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;

}
