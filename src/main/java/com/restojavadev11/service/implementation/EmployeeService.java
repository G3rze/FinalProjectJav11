package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.RestaurantEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.EmployeeParameters;
import com.restojavadev11.repositories.RestaurantRepository;
import com.restojavadev11.security.jwt.PasswordHashGenerator;
import com.restojavadev11.service.IEmployeeService;
import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordHashGenerator passwordHashGenerator;

    @Override
    public List<EmployeeEntity> allEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(long id) {

        try {
            return Optional.ofNullable(employeeRepository.findById(id));
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the employee id", e);
        }
    }

    @Override
    @Transactional
    public void createEmployee(EmployeeParameters employeeParameters) {
        employeeRepository.createNewEmployee(employeeParameters.getEmail(), passwordHashGenerator.passwordEncoder().encode(employeeParameters.getPassword()), employeeParameters.getName(), employeeParameters.getLastname(), employeeParameters.getPosition(), employeeParameters.getSalary(), employeeParameters.getDateOfHire(), employeeParameters.getIdRestaurant(), employeeParameters.getStatus());
    }

    @Override
    public void updateEmployee(EmployeeEntity newEmployee) {
        employeeRepository.save(newEmployee);
    }

    @Override
    public void updateStatus(boolean status, long id) {
        EmployeeEntity employee = employeeRepository.findById(id);

        employee.setStatus(status);

        employeeRepository.save(employee);
    }
}
