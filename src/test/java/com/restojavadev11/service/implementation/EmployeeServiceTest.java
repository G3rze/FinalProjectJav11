package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.entity.EmployeeEntity;
import com.restojavadev11.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;
    private EmployeeEntity employeeEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeEntity = new EmployeeEntity();
        employeeEntity.setIdEmployee(Long.valueOf(1));
        employeeEntity.setEName("Mauricio");
        employeeEntity.setELastName("Beltran");
        employeeEntity.setEPosition("waiter");
        employeeEntity.setESalary(365);
        employeeEntity.setEDateOfHire(Date.valueOf("2023-05-03"));
    }

    @Test
    void allEmployees() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employeeEntity));
        assertNotNull(employeeService.allEmployees());
    }

    @Test
    void getEmployeeById() {

        //En comprobacion
        Long employeeId = Long.valueOf(1);

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employeeEntity));

        Optional<EmployeeEntity> actualEmployeeEntity = employeeService.getEmployeeById(employeeId);

        assertTrue(actualEmployeeEntity.isPresent());
        assertEquals(employeeEntity, actualEmployeeEntity.get());
    }
}