package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.parameters.OrderParameters;
import com.restojavadev11.repositories.MenuRepository;
import com.restojavadev11.service.IOrderService;
import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<OrderEntity> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(long id) {
        try {
            return orderRepository.findById(id);
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the order id", e);
        }
    }

    @Override
    public OrderEntity newOrder(OrderParameters orderParameters) {
        OrderEntity newOrder = new OrderEntity();

        MenuEntity menu = menuRepository.findById(orderParameters.getIdMenu());

        System.out.println(orderParameters.getIdMenu());
        System.out.println(menu);



        newOrder.setOType(orderParameters.getType());
        newOrder.setOTotal(orderParameters.getTotal());
        newOrder.setMenuEntity(menu);

        return orderRepository.save(newOrder);

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
