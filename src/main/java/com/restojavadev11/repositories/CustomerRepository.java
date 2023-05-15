package com.restojavadev11.repositories;

import com.restojavadev11.entity.CustomerEntity;
import com.restojavadev11.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Procedure("create_new_customer")
    void createNewCustomer(String in_email, String in_password, String in_customer_name, String in_customer_lastname,
                           String in_customer_address, String in_customer_phone_number);

    CustomerEntity findByUserId(long id);
}
