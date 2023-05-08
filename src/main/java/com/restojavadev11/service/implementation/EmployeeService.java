package com.restojavadev11.service.implementation;

import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.service.IEmployeeService;
import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> allEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(long id) {

        try {
            return employeeRepository.findById(id);
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the employee id", e);
        }
    }
}
