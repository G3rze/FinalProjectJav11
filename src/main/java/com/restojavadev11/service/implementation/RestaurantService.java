package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.RestaurantEntity;
import com.restojavadev11.exceptions.DataAccessException;
import com.restojavadev11.repositories.RestaurantRepository;
import com.restojavadev11.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantEntity> allRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<RestaurantEntity> getRestaurantById(long id) {
        try {
            return Optional.ofNullable(restaurantRepository.findById(id));
        } catch (Exception e){
            //Catch the corresponding exception with the DataAccesEx. class, if there's a problem with the id search
            throw new DataAccessException("Cannot find the restaurant id", e);
        }
    }
}
