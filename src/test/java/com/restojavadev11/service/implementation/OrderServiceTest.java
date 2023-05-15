package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.MenuEntity;
import com.restojavadev11.entity.OrderEntity;
import com.restojavadev11.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;
    private OrderEntity orderEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        orderEntity = new OrderEntity();
        orderEntity.setIdOrder(Long.valueOf(1));
        orderEntity.setOType("reservation");
        orderEntity.setOTotal(5);
    }

    @Test
    void allOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(orderEntity));
        assertNotNull(orderService.allOrders());
    }

    @Test
    void getOrderById() {

        /*Long orderId = Long.valueOf(1);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));

        Optional<OrderEntity> actualOrderEntity = orderService.getOrderById(orderId);

        assertEquals(orderEntity, actualOrderEntity.get());*/
    }
}