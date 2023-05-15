package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.BillEntity;
import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService customerService;
    private CustomerEntity customerEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerEntity = new CustomerEntity();
        customerEntity.setIdCustomer(Long.valueOf(1));
        customerEntity.setCName("Hazel");
        customerEntity.setCLastName("Hernandez");
        customerEntity.setCAddress("Torres puerta del alma, Avenida el espino y, C. el Pedregal, San Salvador");
        customerEntity.setCPhone("7146-7852");
    }

    @Test
    void allCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customerEntity));
        assertNotNull(customerService.allCustomers());
    }

    @Test
    void getCustomerById() {
        Long customerId = Long.valueOf(1);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));

        Optional<CustomerEntity> actualCustomerEntity = customerService.getCustomerById(customerId);

        assertEquals(customerEntity, actualCustomerEntity.get());
    }
}