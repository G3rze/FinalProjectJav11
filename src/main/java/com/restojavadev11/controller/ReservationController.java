package com.restojavadev11.controller;

import com.restojavadev11.entity.ReservationEntity;
import com.restojavadev11.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping("getAll")
    public List<ReservationEntity> getAllReservations(){
        return reservationService.allReservations();
    }

}
