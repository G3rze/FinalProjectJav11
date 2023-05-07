package com.restojavadev11.service;

import com.restojavadev11.models.EmployeeEntity;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService {

    List<EmployeeEntity> allEmployees();

    Optional<EmployeeEntity> getEmployeeById(long id);

}
