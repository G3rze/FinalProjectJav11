package com.restojavadev11.controller;

import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.parameters.EmployeeParameters;
import com.restojavadev11.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.allEmployees();
    }

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/getById{id}")
    public Optional<EmployeeEntity> getEmployeeById(@RequestParam("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @PreAuthorize("hasAnyRole('WORKER', 'ADMIN') or hasAnyAuthority('SCOPE_ROLE_WORKER', 'SCOPE_ROLE_ADMIN')")
    @GetMapping("/myInfo")
    public Optional<EmployeeEntity> getMyOwn(long myId){
        return employeeService.getEmployeeById(myId);
    }

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/create")
    public void insertEmployee(@RequestBody EmployeeParameters employeeParameters){
        employeeService.createEmployee(employeeParameters);
    }

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/changeStatusOf{id}To{status}")
    public void changeEmployeeStatusTo(@RequestParam("id") long id, @RequestParam("status") boolean status){
        EmployeeEntity employee = employeeService.getEmployeeById(id).orElse(null);

        if(employee != null) {
            employee.setStatus(status);
            employeeService.updateEmployee(employee);
        }
    }
}
