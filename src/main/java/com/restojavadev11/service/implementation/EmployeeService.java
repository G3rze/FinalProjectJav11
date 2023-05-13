package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.RestaurantEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.EmployeeParameters;
import com.restojavadev11.repositories.RestaurantRepository;
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
    @Autowired
    private RestaurantRepository restaurantRepository;

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
    public EmployeeEntity newEmployee(EmployeeParameters employeeParameters) {
        EmployeeEntity newEmployee = new EmployeeEntity();
        RestaurantEntity restaurant = restaurantRepository.findById(employeeParameters.getIdRestaurant());

        newEmployee.setEName(employeeParameters.getName());
        newEmployee.setELastName(employeeParameters.getLastname());
        newEmployee.setEPosition(employeeParameters.getPosition());
        newEmployee.setESalary(employeeParameters.getSalary());
        newEmployee.setEDateOfHire(employeeParameters.getDateOfHire());
        newEmployee.setRestaurant(restaurant);

        return newEmployee;
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
