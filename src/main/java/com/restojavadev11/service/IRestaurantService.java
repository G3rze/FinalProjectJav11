package com.restojavadev11.service;

import com.restojavadev11.entity.RestaurantEntity;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService {

    List<RestaurantEntity> allRestaurants();

    Optional<RestaurantEntity> getRestaurantById(long id);

}
