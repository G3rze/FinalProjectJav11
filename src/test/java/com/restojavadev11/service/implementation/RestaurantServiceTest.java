package com.restojavadev11.service.implementation;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.entity.RestaurantEntity;
import com.restojavadev11.repositories.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;
    @InjectMocks
    private RestaurantService restaurantService;
    private RestaurantEntity restaurantEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        restaurantEntity = new RestaurantEntity();
        restaurantEntity.setIdRestaurant(Long.valueOf(1));
        restaurantEntity.setRName("The Gourmet Palace #1");
        restaurantEntity.setRAddress("Bulevar y Urbanización, Blvr. Sta. Elena #10, San Salvador");
        restaurantEntity.setRPhone("2290-8416");
        restaurantEntity.setREmail("gourmet.palace@gmail.com");
        restaurantEntity.setRSchedule("Monday to Friday from 11:00 a.m. to 12:00 p.m.");
    }

    @Test
    void allRestaurants() {
        when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurantEntity));
        assertNotNull(restaurantService.allRestaurants());
    }

    @Test
    void getRestaurantById() {

        //En comprobacion
        Long restaurantId = Long.valueOf(1);

        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(restaurantEntity));

        Optional<RestaurantEntity> actualRestaurantEntity = restaurantService.getRestaurantById(restaurantId);

        assertEquals(restaurantEntity, actualRestaurantEntity.get());
    }
}