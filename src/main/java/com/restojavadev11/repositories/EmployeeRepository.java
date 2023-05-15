package com.restojavadev11.repositories;

import com.restojavadev11.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import java.sql.Date;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findById(long id);
    EmployeeEntity findByUserId(long id);
    @Transactional
    @Procedure("create_new_employee")
    void createNewEmployee(String in_email, String in_password, String in_employee_name, String in_employee_lastname,
                           String in_employee_position, Double in_employee_salary, Date in_employee_hire_date,
                           Integer in_employee_restaurant_id, Byte in_employee_status);
}
