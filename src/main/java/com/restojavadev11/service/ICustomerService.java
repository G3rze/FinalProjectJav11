package com.restojavadev11.service;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.parameters.CustomerParameters;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerEntity> allCustomers();

    Optional<CustomerEntity> getCustomerById(long id);

    CustomerEntity newCustomer(CustomerParameters customerParameters);

    void deleteCustomer(long id);

    void updateCustomer(CustomerEntity newCustomer);
}
