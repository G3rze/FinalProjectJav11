package com.restojavadev11.controller;

import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.parameters.OrderParameters;
import com.restojavadev11.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/getAll")
    public List<OrderEntity> getAllOrders(){
        return orderService.allOrders();
    }

    @GetMapping("/getById")
    public Optional<OrderEntity> getOrderById(@RequestParam("id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public void getOrderById(@RequestBody OrderParameters orderParameters){
        OrderEntity newOrder = orderService.newOrder(orderParameters);

        orderService.updateOrder(newOrder);
    }

    @DeleteMapping("/delete{id}")
    public void deleteOrderById(@RequestParam("id") long id){
        orderService.deleteOrder(id);
    }
}
