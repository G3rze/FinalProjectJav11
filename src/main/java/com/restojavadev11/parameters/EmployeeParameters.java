package com.restojavadev11.parameters;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NotBlank
public class EmployeeParameters {
    private String name;
    private String lastname;
    private String position;
    private double salary;
    private Date dateOfHire;
    private long idRestaurant;

    void setDate(LocalDate localDate){
        this.dateOfHire = Date.valueOf(localDate);
    }

    void setSalary(double salary){
        this.salary = Math.round(salary);
    }

}
