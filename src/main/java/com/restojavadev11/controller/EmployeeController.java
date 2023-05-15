package com.restojavadev11.controller;

import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.parameters.EmployeeParameters;
import com.restojavadev11.repositories.EmployeeRepository;
import com.restojavadev11.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.allEmployees();
    }

    @GetMapping("/getById{id}")
    public Optional<EmployeeEntity> getEmployeeById(@RequestParam("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/myInfo")
    public Optional<EmployeeEntity> getMyOwn(long myId){
        return employeeService.getEmployeeById(myId);
    }

    @PostMapping("/create")
    public void insertEmployee(@RequestBody EmployeeParameters employeeParameters){
        EmployeeEntity employee = employeeService.newEmployee(employeeParameters);
        employeeService.updateEmployee(employee);
    }

    @PostMapping("/changeStatusOf{id}To{status}")
    public void changeEmployeeStatusTo(@RequestParam("id") long id, @RequestParam("status") boolean status){
        EmployeeEntity employee = employeeService.getEmployeeById(id).orElse(null);

        if(employee != null) {
            employee.setStatus(status);
            employeeService.updateEmployee(employee);
        }
    }
}
