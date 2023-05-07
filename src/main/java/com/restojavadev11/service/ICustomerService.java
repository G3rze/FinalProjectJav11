package com.restojavadev11.service;

import com.restojavadev11.models.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerEntity> allCustomers();

    Optional<CustomerEntity> getCustomerById(long id);

    CustomerEntity newCustomer(String name, String lastName, String address, String phoneNumber, String email);

    void deleteCustomer(long id);

    void updateCustomer(CustomerEntity newCustomer);
}
