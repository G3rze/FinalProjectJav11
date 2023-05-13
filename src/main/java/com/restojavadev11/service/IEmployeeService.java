package com.restojavadev11.service;

import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.parameters.EmployeeParameters;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService {

    List<EmployeeEntity> allEmployees();
    Optional<EmployeeEntity> getEmployeeById(long id);

    EmployeeEntity newEmployee(EmployeeParameters employeeParameters);

    void updateEmployee(EmployeeEntity newEmployee);

    void updateStatus(boolean status, long id);

}
