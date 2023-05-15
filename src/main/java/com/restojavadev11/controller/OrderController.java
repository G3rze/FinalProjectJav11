package com.restojavadev11.controller;

import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.parameters.OrderParameters;
import com.restojavadev11.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/getAll")
    public List<OrderEntity> getAllOrders(){
        return orderService.allOrders();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'WORKER') or hasAnyAuthority('SCOPE_ROLE_ADMIN', 'WORKER')")
    @GetMapping("/getById")
    public Optional<OrderEntity> getOrderById(@RequestParam("id") long id){
        return orderService.getOrderById(id);
    }

    @PreAuthorize("hasRole('ADMIN') or hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/create")
    public void getOrderById(@RequestBody OrderParameters orderParameters){
        OrderEntity newOrder = orderService.newOrder(orderParameters);

        orderService.updateOrder(newOrder);
    }
}
