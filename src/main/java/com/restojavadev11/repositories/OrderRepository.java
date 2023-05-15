package com.restojavadev11.repositories;

import com.restojavadev11.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findById(long id);

    List<OrderEntity> findAllByOrBill(long id);

}
