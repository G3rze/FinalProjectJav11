package com.restojavadev11.repositories;

import com.restojavadev11.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    RestaurantEntity findById(long id);

}
