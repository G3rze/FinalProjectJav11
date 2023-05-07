package com.restojavadev11.service.implementation;

import com.restojavadev11.parameters.CustomerParameters;
import com.restojavadev11.service.ICustomerService;
import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> allCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(long id) {

        try {
            return customerRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public CustomerEntity newCustomer(CustomerParameters customerParameters) {
        return newCustomer(customerParameters);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(CustomerEntity newCustomer) {
        customerRepository.save(newCustomer);
    }
}
