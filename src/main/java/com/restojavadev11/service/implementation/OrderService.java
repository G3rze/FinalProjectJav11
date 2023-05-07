package com.restojavadev11.service.implementation;

import com.restojavadev11.service.IOrderService;
import com.restojavadev11.models.OrderEntity;
import com.restojavadev11.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(long id) {
        try {
            return orderRepository.findById(id);
        } catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public OrderEntity newOrder(String type, double total, long idMenu) {
        return newOrder(type, total, idMenu);
    }

    @Override
    public void updateOrder(OrderEntity newOrder) {
        orderRepository.save(newOrder);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
