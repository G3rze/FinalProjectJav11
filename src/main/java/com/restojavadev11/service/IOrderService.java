package com.restojavadev11.service;

import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.parameters.OrderParameters;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<OrderEntity> allOrders();

    Optional<OrderEntity> getOrderById(long id);

    OrderEntity newOrder(OrderParameters orderParameters);

    void updateOrder(OrderEntity newOrder);

    void deleteOrder(long id);

}
