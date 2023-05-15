package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@NotBlank
public class EmployeeParameters {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String position;
    private double salary;
    private Date dateOfHire;
    private long idRestaurant;
    private Byte status;
    /*

    void setDate(LocalDate localDate){
        this.dateOfHire = Date.valueOf(localDate);
    }*/

    void setSalary(double salary){
        this.salary = Math.round(salary);
    }

}
