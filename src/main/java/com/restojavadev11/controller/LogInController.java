package com.restojavadev11.controller;


import com.restojavadev11.parameters.CustomerParameters;
import com.restojavadev11.service.implementation.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@AllArgsConstructor @Setter @Getter
public class LogInController {
    private CustomerService customerService;

    @PostMapping("/signup")
    public void signup(@RequestBody CustomerParameters customerParameters){
        customerService.createCustomer(customerParameters);
    }
}
