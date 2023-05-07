package com.restojavadev11.service;

import com.restojavadev11.models.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<OrderEntity> allOrders();

    Optional<OrderEntity> getOrderById(long id);

    OrderEntity newOrder(String type, double total, long idMenu);

    void updateOrder(OrderEntity newOrder);

    void deleteOrder(long id);

}
